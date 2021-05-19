package com.challenge.warmup.controller;

import com.challenge.warmup.model.User;
import com.challenge.warmup.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    // @Autowired
    // private UserRepository userRepo;

    @PostMapping("/auth/sign_up")
    public String register(@RequestParam String username, String password) {

        
    }
    
}
