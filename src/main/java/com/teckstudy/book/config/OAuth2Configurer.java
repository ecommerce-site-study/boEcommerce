package com.teckstudy.book.config;

import com.teckstudy.book.domain.member.types.SocialType;
import com.teckstudy.book.domain.oauth2.ClientRegistration;
import com.teckstudy.book.domain.oauth2.ClientRegistrationRepository;
import com.teckstudy.book.domain.oauth2.CustomOAuth2Provider;
import com.teckstudy.book.domain.oauth2.OAuth2ClientProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class OAuth2Configurer {

    private final OAuth2ClientProperties oAuth2ClientProperties;

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {

        List<ClientRegistration> registrations = oAuth2ClientProperties.getRegistration().keySet().stream()
                .map(c -> getRegistration(c))
                .filter(registration -> registration != null)
                .collect(Collectors.toList());

        return new ClientRegistrationRepository(registrations);
    }

    private ClientRegistration getRegistration(String client) {
        if (client.equalsIgnoreCase(SocialType.GOOGLE.name())) {
            return ClientRegistration.builder().registrationId(client)
                    .clientId(oAuth2ClientProperties.getRegistration().get(client).getClientId())
                    .clientSecret(oAuth2ClientProperties.getRegistration().get(client).getClientSecret())
                    .authorizationGrantType(oAuth2ClientProperties.getRegistration().get(client).getAuthorizationGrantType())
                    .redirectUri(oAuth2ClientProperties.getRegistration().get(client).getRedirectUri())
                    .scopes(oAuth2ClientProperties.getRegistration().get(client).getScope())
                    .authorizationUri(oAuth2ClientProperties.getProvider().get(client).getAuthorizationUri())
                    .tokenUri(oAuth2ClientProperties.getProvider().get(client).getTokenUri())
                    .userInfoUri(oAuth2ClientProperties.getProvider().get(client).getUserInfoUri())
                    .unlinkUri(oAuth2ClientProperties.getProvider().get(client).getUnlinkUri())
                    .build();
        }
        if (client.equalsIgnoreCase(SocialType.NAVER.name())) {
            return ClientRegistration.builder().registrationId(client)
                    .clientId(oAuth2ClientProperties.getRegistration().get(client).getClientId())
                    .clientSecret(oAuth2ClientProperties.getRegistration().get(client).getClientSecret())
                    .authorizationGrantType(oAuth2ClientProperties.getRegistration().get(client).getAuthorizationGrantType())
                    .redirectUri(oAuth2ClientProperties.getRegistration().get(client).getRedirectUri())
                    .scopes(oAuth2ClientProperties.getRegistration().get(client).getScope())
                    .authorizationUri(oAuth2ClientProperties.getProvider().get(client).getAuthorizationUri())
                    .tokenUri(oAuth2ClientProperties.getProvider().get(client).getTokenUri())
                    .userInfoUri(oAuth2ClientProperties.getProvider().get(client).getUserInfoUri())
                    .unlinkUri(oAuth2ClientProperties.getProvider().get(client).getUnlinkUri())
                    .build();
        }
        if (client.equalsIgnoreCase(SocialType.KAKAO.name())) {
            return ClientRegistration.builder().registrationId(client)
                    .clientId(oAuth2ClientProperties.getRegistration().get(client).getClientId())
                    .clientSecret(oAuth2ClientProperties.getRegistration().get(client).getClientSecret())
                    .authorizationGrantType(oAuth2ClientProperties.getRegistration().get(client).getAuthorizationGrantType())
                    .redirectUri(oAuth2ClientProperties.getRegistration().get(client).getRedirectUri())
                    .scopes(oAuth2ClientProperties.getRegistration().get(client).getScope())
                    .authorizationUri(oAuth2ClientProperties.getProvider().get(client).getAuthorizationUri())
                    .tokenUri(oAuth2ClientProperties.getProvider().get(client).getTokenUri())
                    .userInfoUri(oAuth2ClientProperties.getProvider().get(client).getUserInfoUri())
                    .unlinkUri(oAuth2ClientProperties.getProvider().get(client).getUnlinkUri())
                    .build();
        }
        return null;
    }
}
