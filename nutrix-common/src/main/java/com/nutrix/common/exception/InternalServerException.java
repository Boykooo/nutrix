package com.nutrix.common.exception;

import com.nutrix.common.exception.base.BaseRuntimeException;
import com.nutrix.common.exception.base.ExceptionType;

public class InternalServerException extends BaseRuntimeException {
    public InternalServerException() {
        super(ExceptionType.INTERNAL_SERVER_ERROR);
    }
}
