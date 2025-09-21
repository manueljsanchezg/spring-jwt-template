package com.demo.jwt.user;

import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Resource
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByName(String name);
}
