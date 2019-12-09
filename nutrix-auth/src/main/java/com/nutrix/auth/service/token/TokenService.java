package com.nutrix.auth.service.token;

import com.nutrix.auth.dto.converter.AccountConverter;
import com.nutrix.auth.dto.token.TokenHolder;
import com.nutrix.auth.dto.token.TokenWrapper;
import com.nutrix.auth.entity.Account;
import com.nutrix.auth.entity.RefreshToken;
import com.nutrix.common.security.AccountInfo;
import com.nutrix.common.security.JwtParser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    @Lazy
    @Autowired
    private TokenService tokenService;

    @Value("${token.key}")
    private String tokenKey;

    @Transactional
    public TokenHolder generate(Account account) {
        AccountInfo info = AccountConverter.toInfo(account);
        TokenWrapper accessToken = jwtProvider.generateAccess(info);
        String refreshToken = refreshTokenService.create(info.getId());
        return new TokenHolder(accessToken.getToken(), refreshToken, accessToken.getExpired());
    }

    /**
     * Creating new tokens by refresh token
     */
    @Transactional
    public TokenHolder generate(String refreshToken) {
        Long accountId = JwtParser.parse(refreshToken, tokenKey, true, Long.class);
        RefreshToken rt = refreshTokenService.getByAccountId(accountId);
        return tokenService.generate(rt.getAccount());
    }

}
