package com.teckstudy.book.feature.member.application;

import com.teckstudy.book.feature.oauth2.OAuth2Token;
import com.teckstudy.book.feature.oauth2.account.OAuth2AccountDTO;
import com.teckstudy.book.feature.oauth2.userInfo.OAuth2UserInfo;
import com.teckstudy.book.feature.member.ui.request.SignUpRequest;
import com.teckstudy.book.feature.member.ui.request.UpdateProfileRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface MemberService {
    void signUp(SignUpRequest signUpRequest);

    void updateProfile(String username, UpdateProfileRequest updateProfileRequest);

    UserDetails loginOAuth2User(String provider, OAuth2Token oAuth2Token, OAuth2UserInfo userInfo);

    Optional<OAuth2AccountDTO> getOAuth2Account(String username);

    UserDetails linkOAuth2Account(String username, String provider, OAuth2Token oAuth2Token, OAuth2UserInfo userInfo);

    OAuth2AccountDTO unlinkOAuth2Account(String username);

    Optional<OAuth2AccountDTO> withdrawUser(String username);
}