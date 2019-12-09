package com.nutrix.auth.service.social;

import com.nutrix.auth.dto.socialnetwork.SocialNetworkAuthenticationParams;
import com.nutrix.auth.dto.SocialNetworkType;
import com.nutrix.auth.dto.converter.SocialNetworkUserConverter;
import com.nutrix.auth.dto.socialnetwork.google.GoogleTokenHolder;
import com.nutrix.auth.dto.socialnetwork.google.GoogleUserInfo;
import com.nutrix.auth.dto.socialnetwork.SocialNetworkUser;
import com.nutrix.common.exception.InternalServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoogleConnector implements SocialNetworkConnector {

    private static final String AUTHENTICATE_URL = "https://www.googleapis.com/oauth2/v4/token";
    private static final String USER_INFO_URL = "https://openidconnect.googleapis.com/v1/userinfo";
    private final RestTemplate restTemplate;

    @Value("${oauth.google.client-id}")
    private String clientId;

    @Value("${oauth.google.client-secret}")
    private String clientSecret;

    @Override
    public SocialNetworkUser authenticate(SocialNetworkAuthenticationParams params) {
        GoogleTokenHolder th = getAccessToken(params);
        GoogleUserInfo userInfo = getUserInfo(th);
        return SocialNetworkUserConverter.convert(userInfo);
    }

    @Override
    public boolean canProcess(SocialNetworkType type) {
        return type == SocialNetworkType.GOOGLE;
    }

    private GoogleTokenHolder getAccessToken(SocialNetworkAuthenticationParams params) {
        Map<String, String> uriParams = new HashMap<>();
        uriParams.put("code", params.getCode());
        uriParams.put("client_id", clientId);
        uriParams.put("client_secret", clientSecret);
        uriParams.put("grant_type", "authorization_code");
        uriParams.put("redirect_uri", params.getRedirectUri());
        try {
            return restTemplate.postForEntity(AUTHENTICATE_URL, null, GoogleTokenHolder.class, uriParams).getBody();
        } catch (Exception ex) {
            log.error("Couldn't authenticate through Google OAuth service. Erorr = {}", ex.getMessage());
            throw new InternalServerException();
        }
    }

    private GoogleUserInfo getUserInfo(GoogleTokenHolder th) {
        Map<String, String> params = Map.of("access_token", th.getAccessToken());
        try {
            return restTemplate.getForEntity(USER_INFO_URL, GoogleUserInfo.class, params).getBody();
        } catch (Exception ex) {
            log.error("Couldn't retrieve User Info from Google OAuth service. Erorr = {}", ex.getMessage());
            throw new InternalServerException();
        }
    }

}
