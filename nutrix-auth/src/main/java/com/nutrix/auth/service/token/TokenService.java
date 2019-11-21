package com.nutrix.auth.service.token;

import com.nutrix.auth.dto.token.TokenHolder;
import com.nutrix.auth.dto.token.TokenWrapper;
import com.nutrix.common.dto.AccountInfo;
import com.nutrix.common.security.JwtParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${token.key}")
    private String tokenKey;

    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    public TokenHolder generate(AccountInfo account) {
        TokenWrapper accessToken = jwtProvider.generateAccess(account);
        String refreshToken = refreshTokenService.create(account.getId());
        return new TokenHolder(accessToken.getToken(), refreshToken, accessToken.getExpired());
    }

    /**
     * Creating new tokens by refresh token
     */
    public TokenHolder loginByRefreshToken(String refreshToken) {
        Long accountId = JwtParser.parse(refreshToken, tokenKey, true, Long.class);
    }

    public TokenHolder updateRefreshToken(String refreshToken) {
        Long accountId = JwtParser.parse(refreshToken, tokenKey, true, Long.class);
        return refreshTokenService.update(refreshToken, accountId);
    }

}
