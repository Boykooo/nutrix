package com.nutrix.auth.dto.socialnetwork;

import com.nutrix.auth.dto.SocialNetworkType;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class SocialNetworkAuthenticationParams {
    @NotEmpty
    private String code;
    @NotEmpty
    private String redirectUri;
    @NotNull
    private SocialNetworkType socialNetworkType;
}
