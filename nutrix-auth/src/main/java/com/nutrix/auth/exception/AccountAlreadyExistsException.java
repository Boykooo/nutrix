package com.nutrix.auth.exception;

import com.nutrix.common.exception.base.BaseRuntimeException;
import com.nutrix.common.exception.base.ExceptionType;

public class AccountAlreadyExistsException extends BaseRuntimeException {
    public AccountAlreadyExistsException() {
        super(ExceptionType.ACCOUNT_ALREADY_EXISTS);
    }
}
