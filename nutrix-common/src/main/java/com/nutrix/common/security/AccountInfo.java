package com.nutrix.common.security;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class AccountInfo {
    private Long id;
    private String name;
    private String email;
    private List<String> roles;
}
