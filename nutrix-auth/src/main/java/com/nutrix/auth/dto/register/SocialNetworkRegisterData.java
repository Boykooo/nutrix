package com.nutrix.auth.dto.register;

import com.nutrix.auth.dto.socialnetwork.SocialNetworkType;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Contains information for OAuth authentication in third-party services
 */
@Getter
public class SocialNetworkRegisterData {
    @NotEmpty
    private String code;
    @NotEmpty
    private String redirectUri;
    @NotNull
    private SocialNetworkType socialNetworkType;
    @Valid
    private AccountPhysicalDataDto physicalData;
}
