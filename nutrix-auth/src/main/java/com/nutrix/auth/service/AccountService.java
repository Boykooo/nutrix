package com.nutrix.auth.service;

import com.nutrix.auth.dto.converter.AccountConverter;
import com.nutrix.auth.entity.Account;
import com.nutrix.auth.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final NutrixCoreService nutrixCoreService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Account getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Transactional
    public Account createNew(String email, String name, String password) {
        Account account = new Account();
        account.setEmail(email);
        account.setPassword(bCryptPasswordEncoder.encode(password));
        account.setRoles(Collections.singleton(roleService.getDefaultRole()));
        account.setRegDate(Instant.now());
        account.setBlocked(false);
        account = accountRepository.save(account);
        nutrixCoreService.createAccount(AccountConverter.toShort(account.getId(), name));
        return account;
    }

}
