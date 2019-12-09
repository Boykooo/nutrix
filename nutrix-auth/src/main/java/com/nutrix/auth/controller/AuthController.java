package com.nutrix.auth.controller;

import com.nutrix.auth.dto.Credentials;
import com.nutrix.auth.dto.RegisterData;
import com.nutrix.auth.dto.SocialNetworkType;
import com.nutrix.auth.dto.socialnetwork.SocialNetworkAuthenticationParams;
import com.nutrix.auth.dto.token.TokenHolder;
import com.nutrix.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterData registerData) {
        TokenHolder tokenHolder = authService.register(registerData);
        return ResponseEntity.ok(tokenHolder);
    }

    @PostMapping("/email")
    public ResponseEntity login(@RequestBody @Valid Credentials credentials) {
        TokenHolder tokenHolder = authService.login(credentials);
        return ResponseEntity.ok(tokenHolder);
    }

    @PutMapping("/token")
    public ResponseEntity login(@RequestParam("rt") String refreshToken) {
        TokenHolder tokenHolder = authService.login(refreshToken);
        return ResponseEntity.ok(tokenHolder);
    }

    @PostMapping("/social")
    public ResponseEntity login(@RequestBody @Valid SocialNetworkAuthenticationParams params) {
        TokenHolder tokenHolder = authService.login(params);
        return ResponseEntity.ok(tokenHolder);
    }

}
