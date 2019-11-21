package com.nutrix.auth.service;

import com.nutrix.auth.dto.Credentials;
import com.nutrix.auth.dto.token.TokenHolder;
import com.nutrix.auth.dto.converter.AccountConverter;
import com.nutrix.auth.service.token.TokenService;
import com.nutrix.auth.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountService accountService;
    private final TokenService tokenService;

    /**
     * Simple authorization via email and password
     * @param credentials Email and Password Holder
     */
    public TokenHolder login(Credentials credentials) {
        var account = accountService.getAccountByEmail(credentials.getEmail()).orElseThrow(AccountNotFoundException::new);
        return tokenService.generate(AccountConverter.toInfo(account));
    }

}
