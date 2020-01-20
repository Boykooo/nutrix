package com.nutrix.auth.dto.converter;

import com.nutrix.auth.dto.AccountWithPhysicalDataDto;
import com.nutrix.auth.dto.register.AccountPhysicalDataDto;
import com.nutrix.auth.entity.Account;
import com.nutrix.common.security.AccountInfo;

public final class AccountConverter {

    public static AccountInfo toInfo(Account account) {
        return AccountInfo.builder()
                .id(account.getId())
                .email(account.getEmail())
                .roles(RoleConverter.extractRoleNames(account.getRoles()))
                .build();
    }

    public static AccountWithPhysicalDataDto toShort(Long id, AccountPhysicalDataDto accountInfo) {
        return new AccountWithPhysicalDataDto(id, accountInfo);
    }

}
