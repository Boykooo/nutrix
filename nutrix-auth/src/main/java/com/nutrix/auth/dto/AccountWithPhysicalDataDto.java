package com.nutrix.auth.dto;

import com.nutrix.auth.dto.register.AccountPhysicalDataDto;
import lombok.Getter;

/**
 * Contains account information for CORE module.
 * Used for registration in system.
 */
@Getter
public class AccountWithPhysicalDataDto extends AccountPhysicalDataDto {
    private Long id;

    public AccountWithPhysicalDataDto(Long id, AccountPhysicalDataDto accountInfo) {
        super(accountInfo);
        this.id = id;
    }

}
