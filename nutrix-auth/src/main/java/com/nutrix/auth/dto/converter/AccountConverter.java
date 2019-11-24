package com.nutrix.auth.dto.converter;

import com.nutrix.auth.entity.Account;
import com.nutrix.common.security.AccountInfo;

public final class AccountConverter {

    public static AccountInfo toInfo(Account account) {
        return AccountInfo.builder()
                .id(account.getId())
                .email(account.getEmail())
                .name(account.getName())
                .roles(RoleConverter.extractRoleNames(account.get))
    }

}
