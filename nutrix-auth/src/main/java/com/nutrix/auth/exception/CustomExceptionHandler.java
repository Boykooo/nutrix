package com.nutrix.auth.exception;

import com.nutrix.common.exception.TokenExpiredException;
import com.nutrix.common.exception.base.BaseRuntimeException;
import com.nutrix.common.exception.base.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({BaseRuntimeException.class})
    public ResponseEntity process(BaseRuntimeException e) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorInfo(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity process(MethodArgumentNotValidException e) {
        int errorCode = HttpStatus.BAD_REQUEST.value();
        FieldError fieldError = e.getBindingResult().getFieldErrors().get(0);
        var errorInfo = new ErrorInfo(errorCode, fieldError.getDefaultMessage());
        return ResponseEntity
                .badRequest()
                .body(errorInfo);
    }

    @ExceptionHandler({TokenExpiredException.class})
    public ResponseEntity processForbidden(BaseRuntimeException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ErrorInfo(e.getCode(), e.getMessage()));
    }

}
