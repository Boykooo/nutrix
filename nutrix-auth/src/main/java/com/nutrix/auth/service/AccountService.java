package com.nutrix.auth.service;

import com.nutrix.auth.entity.Account;
import com.nutrix.auth.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Optional<Account> getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account createNew(String email, String name, String password) {
        Account account = new Account();
        account.setEmail(email);
        account.setPassword(bCryptPasswordEncoder.encode(password));
        account.setRoles(Collections.singleton(roleService.getDefaultRole()));
        account.setName(name);
        account.setRegDate(Instant.now());
        account.setBlocked(false);
        return accountRepository.save(account);
    }

}
