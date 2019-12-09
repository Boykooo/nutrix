package com.nutrix.auth.dto.converter;

import com.nutrix.auth.dto.socialnetwork.SocialNetworkUser;
import com.nutrix.auth.dto.socialnetwork.google.GoogleUserInfo;

public final class SocialNetworkUserConverter {

    public static SocialNetworkUser convert(GoogleUserInfo user) {
        return SocialNetworkUser.builder()
                .email(user.getEmail())
                .emailVerified(user.isEmailVerified())
                .picture(user.getPicture())
                .build();
    }

}
