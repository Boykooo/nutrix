package com.nutrix.common.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {
    protected Long id;
    protected String name;
    protected String email;
    protected List<String> roles;
}
