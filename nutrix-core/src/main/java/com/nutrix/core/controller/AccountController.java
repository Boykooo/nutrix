package com.nutrix.core.controller;

import com.nutrix.core.dto.NewAccountDto;
import com.nutrix.core.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/current/short")
    public ResponseEntity getCurrentAccount() {
        accountService.getCurrentShort();
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid NewAccountDto account) {
        accountService.create(account);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateName(@RequestParam("name") String name) {
        accountService.updateName(name);
        return ResponseEntity.ok(name);
    }

}
