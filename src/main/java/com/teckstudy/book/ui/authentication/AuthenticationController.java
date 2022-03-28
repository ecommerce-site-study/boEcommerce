package com.teckstudy.book.ui.authentication;

import com.teckstudy.book.application.member.MemberService;
import com.teckstudy.book.config.jwt.JwtProvider;
import com.teckstudy.book.config.security.StatelessCSRFFilter;
import com.teckstudy.book.config.security.UserDetailsImpl;
import com.teckstudy.book.domain.oauth2.*;
import com.teckstudy.book.domain.oauth2.service.OAuth2Service;
import com.teckstudy.book.domain.oauth2.service.OAuth2ServiceFactory;
import com.teckstudy.book.domain.oauth2.userInfo.OAuth2UserInfo;
import com.teckstudy.book.lib.common.util.CookieUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {

    private final MemberService userService;
    private final AuthenticationManager authenticationManager;
    private final ClientRegistrationRepository clientRegistrationRepository;
    private final InMemoryOAuth2RequestRepository inMemoryOAuth2RequestRepository;
    private final RestTemplate restTemplate;
    private final JwtProvider jwtProvider;

    /* 각 소셜 서비스로부터 인증 결과를 처리하는 컨트롤러 */
    @RequestMapping("/oauth2/callback/{provider}")
    public void oAuth2AuthenticationCallback(@PathVariable String provider, OAuth2AuthorizationResponse oAuth2AuthorizationResponse, HttpServletRequest request, HttpServletResponse response, @AuthenticationPrincipal UserDetailsImpl loginUser) throws Exception {

        //인증을 요청할 때 저장했던 request 정보를 가져온다.
        OAuth2AuthorizationRequest oAuth2AuthorizationRequest = inMemoryOAuth2RequestRepository.deleteOAuth2Request(oAuth2AuthorizationResponse.getState());

        //유저가 로그인 페이지에서 로그인을 취소하거나 오류가 발생했을때 처리
        if (oAuth2AuthorizationResponse.getError() != null) {
            redirectWithErrorMessage(oAuth2AuthorizationRequest.getReferer(), oAuth2AuthorizationResponse.getError(), response);
            return;
        }

        //사용자의 요청에 맞는 OAuth2 클라이언트 정보를 매핑한다
        ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId(provider);
        OAuth2Service oAuth2Service = OAuth2ServiceFactory.getOAuth2Service(restTemplate, provider);

        //토큰과 유저 정보를 요청
        OAuth2Token oAuth2Token = oAuth2Service.getAccessToken(clientRegistration, oAuth2AuthorizationResponse.getCode(), oAuth2AuthorizationResponse.getState());
        OAuth2UserInfo oAuth2UserInfo = oAuth2Service.getUserInfo(clientRegistration, oAuth2Token.getToken());

        // social token 역할 끝

        // 저희 서버에서 하는거 .


        //로그인에 대한 콜백 처리
        if (oAuth2AuthorizationRequest.getCallback().equalsIgnoreCase("login")) {
            UserDetails userDetails = userService.loginOAuth2User(provider, oAuth2Token, oAuth2UserInfo);
            generateTokenCookie(userDetails, request, response);
            generateCSRFTokenCookie(response);
        }
        //계정 연동에 대한 콜백 처리
        else if (oAuth2AuthorizationRequest.getCallback().equalsIgnoreCase("link")) {
            //로그인 상태가 아니면
            if (loginUser == null) {
                redirectWithErrorMessage(oAuth2AuthorizationRequest.getReferer(), "unauthorized", response);
                return;
            }
            try {
                userService.linkOAuth2Account(loginUser.getUsername(), provider, oAuth2Token, oAuth2UserInfo);
            } catch (Exception e) {
                redirectWithErrorMessage(oAuth2AuthorizationRequest.getReferer(), e.getMessage(), response);
                return;
            }
        }

        //콜백 성공
        response.sendRedirect(oAuth2AuthorizationRequest.getRedirectUri());
    }

    private void generateTokenCookie(UserDetails userDetails, HttpServletRequest request, HttpServletResponse response) {
        final int cookieMaxAge = jwtProvider.getTokenExpirationDate().intValue();
        //https 프로토콜인 경우 secure 옵션사용
        boolean secure = request.isSecure();
        CookieUtils.addCookie(response, "access_token", jwtProvider.generateToken(userDetails.getUsername()), true, secure, cookieMaxAge);
    }

    private void generateCSRFTokenCookie(HttpServletResponse response) {
        CookieUtils.addCookie(response, StatelessCSRFFilter.CSRF_TOKEN, UUID.randomUUID().toString(), 60 * 60 * 24);
    }


    private void redirectWithErrorMessage(String uri, String message, HttpServletResponse response) throws IOException {
        String redirectUri = UriComponentsBuilder.fromUriString(uri)
                .replaceQueryParam("error", message).encode().build().toUriString();
        response.sendRedirect(redirectUri);
    }

    private String generateState() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
}
