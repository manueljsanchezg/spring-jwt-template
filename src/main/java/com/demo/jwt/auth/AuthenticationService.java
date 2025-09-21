package com.demo.jwt.auth;

import com.demo.jwt.user.Role;
import com.demo.jwt.user.RoleService;
import com.demo.jwt.user.User;
import com.demo.jwt.user.UserRepository;
import com.demo.jwt.user.dtos.LoginUserDTO;
import com.demo.jwt.user.dtos.RegisterUserDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager,
                                 RoleService roleService)
    {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.roleService = roleService;
    }

    public User signup(RegisterUserDTO input) {
        Role userRole = roleService.findByName("ROLE_USER");

        User user = User.builder()
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .role(userRole)
                .build();

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()));
        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
