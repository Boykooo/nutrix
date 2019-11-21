package com.nutrix.common.exception;

import com.nutrix.common.exception.base.BaseRuntimeException;
import com.nutrix.common.exception.base.ExceptionType;

public class TokenExpiredException extends BaseRuntimeException {
    public TokenExpiredException() {
        super(ExceptionType.TOKEN_EXPIRED);
    }
}
