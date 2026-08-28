package com.example.msauthkyc.client.mock;

import com.example.msauthkyc.client.MsAccountClient;
import com.example.msauthkyc.client.model.CreateAccountRequest;
import com.example.msauthkyc.client.model.CreateAccountResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Primary
@Profile("mock")
public class MockMsAccountClient implements MsAccountClient {

    @Override
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        return CreateAccountResponse.builder()
                .accountId(UUID.randomUUID().toString())
                .status(Boolean.TRUE)
                .build();
    }

    //todo: local test
}