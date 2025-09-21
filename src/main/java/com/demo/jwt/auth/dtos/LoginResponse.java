package com.demo.jwt.auth.dtos;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String email;
}
