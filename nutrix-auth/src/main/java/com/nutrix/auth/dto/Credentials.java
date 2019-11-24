package com.nutrix.auth.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Getter
public class Credentials {
    @Email(message = "Email is required.")
    private String email;
    @Min(value = 8, message = "Minimum password length is 8 symbols.")
    private String password;
}
