package com.example.msauthkyc.controller;

import com.example.msauthkyc.model.LoginResponse;
import com.example.msauthkyc.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/me")
    public LoginResponse me(@AuthenticationPrincipal OidcUser oidcUser,
                            Authentication authentication) {
        return authService.handleLogin(oidcUser, authentication);
    }
}