package com.example.msauthkyc.service;

import com.example.msauthkyc.client.MsAccountClient;
import com.example.msauthkyc.client.model.CreateAccountResponse;
import com.example.msauthkyc.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final MsAccountClient msAccountClient;
    private final AccountMapper accountMapper;

    public CreateAccountResponse createAccount(OidcUser oidcUser) {
        return msAccountClient.createAccount(accountMapper.toCreateAccountRequest(oidcUser));
    }
}
