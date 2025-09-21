package com.demo.jwt.user.dtos;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String email;
    private String password;
}
