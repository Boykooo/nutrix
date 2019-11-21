package com.nutrix.auth.dto.token;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenWrapper {
    private String token;
    private String expired;
}
