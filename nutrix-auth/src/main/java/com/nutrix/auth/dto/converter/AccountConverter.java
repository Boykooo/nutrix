package com.nutrix.auth.dto.converter;

import com.nutrix.auth.dto.AccountShortDto;
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

    public static AccountShortDto toShort(Long id, String name) {
        return AccountShortDto.builder()
                .id(id)
                .name(name)
                .build();
    }

}
