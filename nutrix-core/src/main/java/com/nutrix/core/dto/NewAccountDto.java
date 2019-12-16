package com.nutrix.core.dto;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotNull;

@Getter
public class NewAccountDto {
    @NotNull
    private Long id;
    private String name;
}
