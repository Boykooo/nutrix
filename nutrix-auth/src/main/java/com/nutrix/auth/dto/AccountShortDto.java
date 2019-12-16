package com.nutrix.auth.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountShortDto {
    private Long id;
    private String name;
}
