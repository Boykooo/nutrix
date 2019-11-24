package com.nutrix.auth.service;

import com.nutrix.auth.entity.Account;
import com.nutrix.auth.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Optional<Account> getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

}
