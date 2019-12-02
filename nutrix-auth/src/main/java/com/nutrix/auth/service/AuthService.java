package com.nutrix.auth.service;

import com.nutrix.auth.dto.Credentials;
import com.nutrix.auth.dto.RegisterData;
import com.nutrix.auth.dto.SocialNetworkType;
import com.nutrix.auth.dto.converter.AccountConverter;
import com.nutrix.auth.dto.token.TokenHolder;
import com.nutrix.auth.entity.Account;
import com.nutrix.auth.exception.AccountAlreadyExistsException;
import com.nutrix.auth.exception.AccountOrPasswordIncorrectException;
import com.nutrix.auth.service.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountService accountService;
    private final TokenService tokenService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Simple register via email and password
     *
     * @param registerData Email and Password Holder
     */
    @Transactional
    public TokenHolder register(RegisterData registerData) {
        var account = accountService.getAccountByEmail(registerData.getEmail()).orElse(null);
        if (account != null) {
            throw new AccountAlreadyExistsException();
        }
        account = new Account();
        account.setEmail(registerData.getEmail());
        account.setPassword(bCryptPasswordEncoder.encode(registerData.getPassword()));
        account.setRoles(Collections.singleton(roleService.getDefaultRole()));
        account.setName(registerData.getName());
        account.setRegDate(Instant.now());
        account.setBlocked(false);
        account = accountService.save(account);
        return tokenService.generate(AccountConverter.toInfo(account));
    }

    /**
     * Simple authorization via email and password
     *
     * @param credentials Email and Password Holder
     */
    public TokenHolder login(Credentials credentials) {
        var account = accountService.getAccountByEmail(credentials.getEmail()).orElseThrow(AccountOrPasswordIncorrectException::new);
        if (!bCryptPasswordEncoder.matches(credentials.getPassword(), account.getPassword())) {
            throw new AccountOrPasswordIncorrectException();
        }
        return tokenService.generate(AccountConverter.toInfo(account));
    }

    /**
     * Relogin via refresh token
     */
    public TokenHolder login(String refreshToken) {
        return tokenService.generate(refreshToken);
    }

    public TokenHolder login(String code, SocialNetworkType socialNetworkType) {
        return null;
    }

}
