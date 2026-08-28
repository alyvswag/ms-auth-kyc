package com.example.msauthkyc.service;

import com.example.msauthkyc.client.MsAccountClient;
import com.example.msauthkyc.client.model.CreateAccountRequest;
import com.example.msauthkyc.client.model.CreateAccountResponse;
import com.example.msauthkyc.model.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final String REGISTRATION_ID = "pin-client";

    private final MsAccountClient msAccountClient;
    private final OAuth2AuthorizedClientService authorizedClientService;

    public LoginResponse handleLogin(OidcUser oidcUser, Authentication authentication) {
        OAuth2AuthorizedClient authorizedClient = loadAuthorizedClient(authentication);

        String accessToken = authorizedClient.getAccessToken().getTokenValue();
        String refreshToken = extractRefreshToken(authorizedClient);
        String pictureUrl = oidcUser.getPicture();

        CreateAccountResponse accountResponse = createAccount(oidcUser);

        return LoginResponse.builder()
                .accountId(accountResponse.getAccountId())
                .email(oidcUser.getEmail())
                .fullName(oidcUser.getFullName())
                .pictureUrl(pictureUrl)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    private OAuth2AuthorizedClient loadAuthorizedClient(Authentication authentication) {
        return authorizedClientService.loadAuthorizedClient(REGISTRATION_ID, authentication.getName());
    }

    private String extractRefreshToken(OAuth2AuthorizedClient authorizedClient) {
        return authorizedClient.getRefreshToken() != null
                ? authorizedClient.getRefreshToken().getTokenValue()
                : null;
    }

    private CreateAccountResponse createAccount(OidcUser oidcUser) {
        CreateAccountRequest request = CreateAccountRequest.builder()
                .externalId(oidcUser.getSubject())
                .email(oidcUser.getEmail())
                .fullName(oidcUser.getFullName())
                .pictureUrl(oidcUser.getPicture())
                .build();

        return msAccountClient.createAccount(request);
    }
}