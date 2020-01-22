package com.nutrix.common.exception;

import com.nutrix.common.exception.base.BaseRuntimeException;
import com.nutrix.common.exception.base.ExceptionType;

public class AccessDeniedException extends BaseRuntimeException {
    public AccessDeniedException() {
        super(ExceptionType.ACCESS_DENIED);
    }
}
