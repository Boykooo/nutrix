package com.nutrix.auth.dto.converter;

import com.nutrix.auth.dto.socialnetwork.GoogleUserInfo;
import com.nutrix.auth.dto.socialnetwork.SocialNetworkUser;

public final class SocialNetworkUserConverter {

    public static SocialNetworkUser convert(GoogleUserInfo user) {
        return SocialNetworkUser.builder()
                .email(user.getEmail())
                .emailVerified(user.isEmailVerified())
                .picture(user.getPicture())
                .build();
    }

}
