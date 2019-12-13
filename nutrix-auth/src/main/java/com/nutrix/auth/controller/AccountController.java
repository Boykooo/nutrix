package com.nutrix.auth.controller;

import com.nutrix.auth.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/current/short")
    public ResponseEntity getCurrentAccount() {
        accountService.getCurrentShort();
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateName(@RequestParam("name") String name) {
        accountService.updateName(name);
        return ResponseEntity.ok(name);
    }

}
