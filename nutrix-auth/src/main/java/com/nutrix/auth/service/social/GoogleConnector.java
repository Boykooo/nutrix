package com.nutrix.auth.service.social;

import com.nutrix.auth.dto.socialnetwork.SocialNetworkType;
import com.nutrix.auth.dto.converter.SocialNetworkUserConverter;
import com.nutrix.auth.dto.register.SocialNetworkRegisterData;
import com.nutrix.auth.dto.socialnetwork.SocialNetworkUser;
import com.nutrix.auth.dto.socialnetwork.google.GoogleTokenHolder;
import com.nutrix.auth.dto.socialnetwork.google.GoogleUserInfo;
import com.nutrix.common.exception.InternalServerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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
    public SocialNetworkUser authenticate(SocialNetworkRegisterData params) {
        GoogleTokenHolder th = getAccessToken(params);
        GoogleUserInfo userInfo = getUserInfo(th);
        return SocialNetworkUserConverter.convert(userInfo);
    }

    @Override
    public boolean canProcess(SocialNetworkType type) {
        return type == SocialNetworkType.GOOGLE;
    }

    private GoogleTokenHolder getAccessToken(SocialNetworkRegisterData params) {
        URI uri = UriComponentsBuilder.fromHttpUrl(AUTHENTICATE_URL)
                .queryParam("code", params.getCode())
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("grant_type", "authorization_code")
                .queryParam("redirect_uri", params.getRedirectUri())
                .build()
                .toUri();
        try {
            return restTemplate.postForEntity(uri, null, GoogleTokenHolder.class).getBody();
        } catch (Exception e) {
            log.error("Couldn't authenticate through Google OAuth service. Error = {}", getErrorMsg(e));
            throw new InternalServerException();
        }
    }

    private GoogleUserInfo getUserInfo(GoogleTokenHolder th) {
        var uri = UriComponentsBuilder.fromHttpUrl(USER_INFO_URL)
                .queryParam("access_token", th.getAccessToken())
                .build()
                .toUri();
        try {
            return restTemplate.getForEntity(uri, GoogleUserInfo.class).getBody();
        } catch (Exception e) {
            log.error("Couldn't retrieve User Info from Google OAuth service. Error = {}", getErrorMsg(e));
            throw new InternalServerException();
        }
    }

    private String getErrorMsg(Exception e) {
        return e instanceof HttpClientErrorException ? ((HttpClientErrorException) e).getResponseBodyAsString()
                : e.getMessage();
    }

}
