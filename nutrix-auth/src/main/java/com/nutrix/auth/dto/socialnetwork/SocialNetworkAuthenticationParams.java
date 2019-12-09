package com.nutrix.auth.dto.socialnetwork;

import com.nutrix.auth.dto.SocialNetworkType;
import lombok.Getter;

@Getter
public class SocialNetworkAuthenticationParams {
    private String code;
    private String redirectUri;
    private SocialNetworkType socialNetworkType;
}
