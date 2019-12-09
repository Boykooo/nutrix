package com.nutrix.auth.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
public class Credentials {
    @Email(message = "Email is required.")
    private String email;
    @Size(min = 8, message = "Minimum password length is 8 symbols.")
    private String password;
}
