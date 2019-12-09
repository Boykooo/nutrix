package com.nutrix.auth.service.social;

import com.nutrix.auth.dto.SocialNetworkAuthenticationParams;
import com.nutrix.auth.dto.SocialNetworkType;
import com.nutrix.auth.dto.socialnetwork.SocialNetworkUser;

public interface SocialNetworkConnector {

    SocialNetworkUser authenticate(SocialNetworkAuthenticationParams params);

    boolean canProcess(SocialNetworkType type);

}
