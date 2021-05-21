package com.challenge.warmup.repository;

import java.util.List;

import com.challenge.warmup.model.Post;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends CrudRepository<Post, Integer>{

    @Query(value = "SELECT post_id, title, image, category, creation_date FROM post WHERE title = :title ", nativeQuery = true)
    List<Object> findByTitleLike(@Param("title") String title);

    @Query(value = "SELECT post_id, title, image, category, creation_date FROM post WHERE category = :category", nativeQuery = true)
    List<Object> findByCategoryLike(@Param("category") String category);

    @Query(value = "SELECT post_id, title, image, category, creation_date FROM post WHERE title = :title and category = :category", nativeQuery = true)
    List<Object> findByTitleLikeAndCategoryLike(@Param("title") String title, @Param("category") String category);

    @Query(value = "SELECT post_id, title, image, category, creation_date FROM post", nativeQuery = true)
    List<Object> getPosts();
    

}
