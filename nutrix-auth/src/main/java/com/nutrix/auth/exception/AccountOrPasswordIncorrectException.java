package com.nutrix.auth.exception;

import com.nutrix.common.exception.base.BaseRuntimeException;
import com.nutrix.common.exception.base.ExceptionType;

public class AccountOrPasswordIncorrectException extends BaseRuntimeException {
    public AccountOrPasswordIncorrectException() {
        super(ExceptionType.ACCOUNT_OR_PASSWORD_INCORRECT);
    }
}
