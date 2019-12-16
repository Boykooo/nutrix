package com.nutrix.core.service;

import com.nutrix.common.exception.TokenExpiredException;
import com.nutrix.core.dto.NewAccountDto;
import com.nutrix.core.entity.Account;
import com.nutrix.core.repository.AccountRepository;
import com.nutrix.core.security.CurrentUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CurrentUser currentUser;

    public void create(NewAccountDto account) {
        var newAccount = new Account();
        newAccount.setId(account.getId());
        newAccount.setName(account.getName());
        accountRepository.save(newAccount);
    }

    public void getCurrentShort() {
        var account = accountRepository.findById(currentUser.getId()).orElseThrow(TokenExpiredException::new);
    }

    public void updateName(String name) {
        accountRepository.updateName(currentUser.getId(), name);
    }

}
