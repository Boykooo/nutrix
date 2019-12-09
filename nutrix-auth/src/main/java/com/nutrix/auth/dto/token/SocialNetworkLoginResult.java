package com.nutrix.auth.dto.token;

import lombok.Getter;

@Getter
public class SocialNetworkLoginResult extends TokenHolder {
    private boolean isNewUser;

    public SocialNetworkLoginResult(TokenHolder th, boolean isNewUser) {
        super(th.getAccessToken(), th.getRefreshToken(), th.getExpiredTime());
        this.isNewUser = isNewUser;
    }
}
