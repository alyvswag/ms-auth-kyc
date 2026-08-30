package com.example.msauthkyc.service;

import com.example.msauthkyc.client.MsAccountClient;
import com.example.msauthkyc.client.model.CreateAccountRequest;
import com.example.msauthkyc.client.model.CreateAccountResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final MsAccountClient msAccountClient;

    public CreateAccountResponse createAccount(OidcUser oidcUser) {
        return msAccountClient.createAccount(CreateAccountRequest.builder()
                .externalId(oidcUser.getSubject())
                .email(oidcUser.getEmail())
                .fullName(oidcUser.getFullName())
                .pictureUrl(oidcUser.getPicture())
                .build());
    }
}
