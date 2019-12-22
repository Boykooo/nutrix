package com.nutrix.auth.dto;

import lombok.Getter;

@Getter
public class AccountShortDto extends RegisterAccountInfoDto {
    private Long id;

    public AccountShortDto(Long id, RegisterAccountInfoDto accountInfo) {
        super(accountInfo);
        this.id = id;
    }

}
