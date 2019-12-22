package com.nutrix.auth.dto;

import com.nutrix.auth.dto.socialnetwork.SocialNetworkType;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class SocialNetworkAuthenticationParams {
    @Valid
    private RegisterAccountInfoDto accountInfo;
    @NotEmpty
    private String code;
    @NotEmpty
    private String redirectUri;
    @NotNull
    private SocialNetworkType socialNetworkType;
}
