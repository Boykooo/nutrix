package com.nutrix.auth.exception;

import com.nutrix.common.exception.base.BaseRuntimeException;
import com.nutrix.common.exception.base.ExceptionType;

public class AccountNotFoundException extends BaseRuntimeException {
    public AccountNotFoundException() {
        super(ExceptionType.ACCOUNT_NOT_FOUND);
    }
}
