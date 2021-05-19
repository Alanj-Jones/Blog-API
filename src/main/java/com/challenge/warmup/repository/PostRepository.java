package com.challenge.warmup.repository;

import com.challenge.warmup.model.Post;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer>{
    
}
