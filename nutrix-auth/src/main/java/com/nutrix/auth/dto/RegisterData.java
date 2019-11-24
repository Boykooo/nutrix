package com.nutrix.auth.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class RegisterData extends Credentials {
    @NotEmpty(message = "Name must be not empty.")
    private String name;
}
