package com.nutrix.common.exception.base;

public class BaseRuntimeException extends RuntimeException {

    private int code;
    private String message;

    public BaseRuntimeException(ExceptionType exceptionType) {
        this.code = exceptionType.getCode();
        this.message = exceptionType.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
