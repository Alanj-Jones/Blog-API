package com.challenge.warmup.repository;

import com.challenge.warmup.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>{
    
    
}
