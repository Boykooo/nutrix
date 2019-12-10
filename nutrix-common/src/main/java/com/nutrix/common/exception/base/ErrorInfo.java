package com.nutrix.common.exception.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorInfo {
    private int code;
    private String message;
}
