package com.challenge.warmup.repository;

import java.util.List;

import com.challenge.warmup.model.Post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer>{
    
    List<Post> findByTitleLike(String title);
    List<Post> findByCategoryLike(String category);
    List<Post> findByTitleLikeAndCategoryLike(String title, String category);

    @Query(value = "SELECT post_id, title, image, category, creation_date FROM post", nativeQuery = true)
    List<Object> getPosts();
    

}
