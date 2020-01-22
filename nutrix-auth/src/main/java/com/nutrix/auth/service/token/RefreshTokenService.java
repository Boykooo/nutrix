package com.nutrix.auth.service.token;

import com.nutrix.auth.dto.token.TokenWrapper;
import com.nutrix.auth.entity.RefreshToken;
import com.nutrix.auth.repository.RefreshTokenRepository;
import com.nutrix.common.exception.TokenExpiredException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProvider jwtProvider;

    public String create(Long accountId) {
        TokenWrapper tokenWrapper = jwtProvider.generateRefresh(accountId);
        RefreshToken rt = new RefreshToken(accountId, null, tokenWrapper.getToken());
        rt = refreshTokenRepository.save(rt);
        return rt.getToken();
    }

    public RefreshToken getByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

}
