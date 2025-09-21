package com.demo.jwt.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<User> getProfile() {
        return ResponseEntity.ok(userService.getUserProfile());
    }

    @GetMapping()
    public  ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findUsers());
    }
}
