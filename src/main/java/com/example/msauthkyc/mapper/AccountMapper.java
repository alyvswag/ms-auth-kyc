package com.example.msauthkyc.mapper;

import com.example.msauthkyc.client.model.CreateAccountRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(source = "subject", target = "externalId")
    @Mapping(source = "picture", target = "pictureUrl")
    CreateAccountRequest toCreateAccountRequest(OidcUser oidcUser);
}
