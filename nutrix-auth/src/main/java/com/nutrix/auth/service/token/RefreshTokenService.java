package com.nutrix.auth.service.token;

import com.nutrix.auth.entity.RefreshToken;
import com.nutrix.auth.repository.RefreshTokenRepository;
import com.nutrix.common.exception.TokenExpiredException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public String create(Long accountId) {
        RefreshToken refreshToken = refreshTokenRepository.findById(accountId).orElseThrow(TokenExpiredException::new);
        
    }

}
