package com.demo.jwt.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!auth.isAuthenticated()) throw new RuntimeException();
        return userRepository.findByEmail(auth.getName()).orElseThrow(() -> new RuntimeException());
    }

    public User getUserProfile() {
        return findCurrentUser();
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
