package com.nutrix.auth.dto.socialnetwork.google;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class GoogleUserInfo {
    private String email;
    @JsonProperty("email_verified")
    private boolean emailVerified;
    private String picture;
    private Long sub;
}
