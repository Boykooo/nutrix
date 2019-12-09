package com.nutrix.auth.dto.socialnetwork;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SocialNetworkUser {
    private String email;
    private String picture;
    private boolean emailVerified;
}
