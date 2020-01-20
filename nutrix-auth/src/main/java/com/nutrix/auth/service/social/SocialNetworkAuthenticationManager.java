package com.nutrix.auth.service.social;

import com.nutrix.auth.dto.register.SocialNetworkRegisterData;
import com.nutrix.auth.dto.socialnetwork.SocialNetworkUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialNetworkAuthenticationManager {

    private final List<SocialNetworkConnector> connectors;

    public SocialNetworkUser authenticate(SocialNetworkRegisterData params) {
        SocialNetworkConnector connector = connectors.stream()
                .filter(x -> x.canProcess(params.getSocialNetworkType()))
                .findFirst()
                .get();
        return connector.authenticate(params);
    }

}
