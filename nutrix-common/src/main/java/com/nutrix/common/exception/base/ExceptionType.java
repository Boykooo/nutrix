package com.nutrix.common.exception.base;

import lombok.Getter;

@Getter
public enum ExceptionType {
    INTERNAL_SERVER_ERROR(1, "Internal Server Error."),
    ACCOUNT_OR_PASSWORD_INCORRECT(2, "Email or password incorrect."),
    ACCOUNT_ALREADY_EXISTS(3, "Account already exists."),
    TOKEN_EXPIRED(4, "Token expired.")
    ;

    private int code;
    private String message;

    ExceptionType(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
