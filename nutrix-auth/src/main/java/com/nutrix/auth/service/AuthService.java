package com.nutrix.auth.service;

import com.nutrix.auth.dto.Credentials;
import com.nutrix.auth.dto.TokenHolder;
import com.nutrix.auth.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountRepository accountRepository;

    /**
     * Simple authorization via email and password
     * @param credentials Email and Password Holder
     */
    public TokenHolder login(Credentials credentials) {
        var account = accountRepository.findByEmail(credentials.getEmail()).orElseThrow(RuntimeException::new);

        return null;
    }

}
