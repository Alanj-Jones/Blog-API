package com.challenge.warmup.repository;

import java.util.Optional;

import com.challenge.warmup.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    
}
