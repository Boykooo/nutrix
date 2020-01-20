package com.nutrix.auth.service.social;

import com.nutrix.auth.dto.socialnetwork.SocialNetworkType;
import com.nutrix.auth.dto.register.SocialNetworkRegisterData;
import com.nutrix.auth.dto.socialnetwork.SocialNetworkUser;

public interface SocialNetworkConnector {

    SocialNetworkUser authenticate(SocialNetworkRegisterData params);

    boolean canProcess(SocialNetworkType type);

}
