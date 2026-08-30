package com.example.msauthkyc.mapper;

import com.example.msauthkyc.model.KeycloakTokenResponse;
import com.example.msauthkyc.model.TokenResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TokenMapper {

    TokenResponse toTokenResponse(KeycloakTokenResponse keycloakResponse);

}