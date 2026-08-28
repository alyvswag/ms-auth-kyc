package com.example.msauthkyc.client;

import com.example.msauthkyc.client.model.CreateAccountRequest;
import com.example.msauthkyc.client.model.CreateAccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-account", primary = false)
public interface MsAccountClient {

    @PostMapping("/createAccount")
    CreateAccountResponse createAccount(@RequestBody CreateAccountRequest request);
}