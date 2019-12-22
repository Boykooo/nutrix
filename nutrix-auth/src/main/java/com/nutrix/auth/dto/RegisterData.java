package com.nutrix.auth.dto;

import lombok.Getter;

@Getter
public class RegisterData extends Credentials {
    private RegisterAccountInfoDto accountInfo;
}
