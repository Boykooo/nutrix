package com.nutrix.auth.service;

import com.nutrix.auth.dto.register.Credentials;
import com.nutrix.auth.dto.register.RegisterData;
import com.nutrix.auth.dto.register.SocialNetworkRegisterData;
import com.nutrix.auth.dto.socialnetwork.SocialNetworkUser;
import com.nutrix.auth.dto.token.TokenHolder;
import com.nutrix.auth.exception.AccountAlreadyExistsException;
import com.nutrix.auth.exception.AccountOrPasswordIncorrectException;
import com.nutrix.auth.service.social.SocialNetworkAuthenticationManager;
import com.nutrix.auth.service.token.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final AccountService accountService;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final SocialNetworkAuthenticationManager socialNetworkAuthenticationManager;

    /**
     * Simple register via email and password
     *
     * @param registerData Email and Password Holder
     */
    @Transactional
    public TokenHolder register(RegisterData registerData) {
        var account = accountService.getAccountByEmail(registerData.getEmail());
        if (account != null) {
            throw new AccountAlreadyExistsException();
        }
        account = accountService.createNew(registerData.getEmail(), registerData.getPassword(), registerData.getPhysicalData());
        return tokenService.generate(account);
    }

    /**
     * Simple authorization via email and password
     *
     * @param credentials Email and Password Holder
     */
    public TokenHolder login(Credentials credentials) {
        var account = accountService.getAccountByEmail(credentials.getEmail());
        if (account == null) {
            throw new AccountOrPasswordIncorrectException();
        }
        if (!bCryptPasswordEncoder.matches(credentials.getPassword(), account.getPassword())) {
            throw new AccountOrPasswordIncorrectException();
        }
        return tokenService.generate(account);
    }

    /**
     * Relogin via refresh token
     */
    public TokenHolder login(String refreshToken) {
        return tokenService.generate(refreshToken);
    }

    /**
     * Register or login via social network OAuth
     */
    public TokenHolder login(SocialNetworkRegisterData params) {
        SocialNetworkUser user = socialNetworkAuthenticationManager.authenticate(params);
        var account = accountService.getAccountByEmail(user.getEmail());
        if (account == null) {
            account = accountService.createNew(user.getEmail(), params.getCode(), params.getPhysicalData());
        }
        return tokenService.generate(account);
    }

}
