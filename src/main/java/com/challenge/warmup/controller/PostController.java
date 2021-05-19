package com.challenge.warmup.controller;

import java.util.ArrayList;
import java.util.List;

import com.challenge.warmup.model.Post;
import com.challenge.warmup.repository.PostRepository;
import com.challenge.warmup.repository.UserRepository;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/posts")
    public String viewPosts() {  
        List<String> posts = new ArrayList<String>();      
        for(Post p : postRepo.findAll()) {
            posts.add(new Gson().toJson(p));   
            System.out.println(p); //Debug        
        }
        System.out.println("Lista: " + posts.toString());
        return null;
    }

    @GetMapping("/posts?title={title}")
    public String postsByTitle() {
        return null;
    }

    @GetMapping("/posts?category={category}")
    public String postsByCategory() {
        return null;
    }

    @GetMapping("/posts?title={title}&category={category}")
    public String postsByTitleAndCategory() {
        return null;
    }

    @GetMapping("/posts/{id}")
    public String singlePost() {
        return null;
    }

    @PostMapping("/posts")
    public String newPost() {
        return null;
    }

    @PatchMapping("/posts/{id}")
    public String editPost() {
        return null;
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost() {
        return null;
    }

}