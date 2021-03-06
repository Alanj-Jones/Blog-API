package com.challenge.warmup.controller;

import java.util.ArrayList;
import java.util.List;

import com.challenge.warmup.model.Post;
import com.challenge.warmup.repository.PostRepository;
import com.challenge.warmup.repository.UserRepository;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/posts")
    public String viewPosts(
        @RequestParam(required = false, name = "title") String title,
        @RequestParam(required = false, name = "category") String category) {
            List<String> posts = new ArrayList<String>();      
            if (title==null && category==null) {
                for(Object p : postRepo.getPosts()) {
                    posts.add(new Gson().toJson(p));   
                }
            } else if (title!=null && category==null) {
                for (Object p : postRepo.findByTitleLike(title)) {
                    posts.add(new Gson().toJson(p));
                }
            } else if (title==null && category!=null){
                for (Object p : postRepo.findByCategoryLike(category)) {
                    posts.add(new Gson().toJson(p));
                }
            } else {
                for (Object p : postRepo.findByTitleLikeAndCategoryLike(title, category)) {
                    posts.add(new Gson().toJson(p));
                }
            }
            return posts.toString();
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable Integer id) {
        var post = postRepo.findById(id);
        if (!post.isEmpty()) {
            return new Gson().toJson(post.get());
        }
        
        return "El Id del post no existe o es incorrecto.\n";
    }

    @PostMapping("/posts")
    public String newPost(@RequestBody Post post) {        
        try {
            postRepo.save(post);
            return new Gson().toJson(post);
        } catch (Exception e) {
            return "El Post no ha podido ser creado";
        }
    }

    @PatchMapping("/posts/{id}")
    public String editPost(@PathVariable Integer id, @RequestBody Post post) {
        try {
            // Post postToModify = postRepo.findById(id).get();
            post.setPostId(id);
            postRepo.save(post);
            return new Gson().toJson(postRepo.findById(id).get());
        }  catch (Exception e) {
            return "El post no ha podido ser editado";
        }
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(@PathVariable Integer id) {
        try {
            postRepo.deleteById(id);
            return "Usuario borrado con exito";
        } catch (Exception e) {
            return e.getMessage();
        }         
    }

}