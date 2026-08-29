package com.example.msauthkyc.model;

import lombok.*;
import lombok.experimental.SuperBuilder;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String accountId;
    private String email;
    private String fullName;
    private String pictureUrl;

    private String accessToken;
    private String refreshToken;
}