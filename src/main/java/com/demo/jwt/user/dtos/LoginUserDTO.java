package com.demo.jwt.user.dtos;

import lombok.Data;

@Data
public class LoginUserDTO {
    private String email;
    private String password;
}
