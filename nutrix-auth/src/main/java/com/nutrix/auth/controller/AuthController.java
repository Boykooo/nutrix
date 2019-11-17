package com.nutrix.auth.controller;

import com.nutrix.auth.dto.Credentials;
import com.nutrix.auth.dto.TokenHolder;
import com.nutrix.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/email")
    public ResponseEntity login(@RequestBody Credentials credentials) {
        TokenHolder tokenHolder = authService.login(credentials);
        return ResponseEntity.ok(tokenHolder);
    }

}
