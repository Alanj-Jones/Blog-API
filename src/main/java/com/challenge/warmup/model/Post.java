package com.challenge.warmup.model;

import java.util.Date;

public class Post {

    public Post() {}

    public Post(String title, String content, String imageUrl, String category, Date creationDate) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.category = category;
        this.creationDate = creationDate;
    }

    private Integer postId;
    private String title;
    private String content;
    private String imageUrl;
    private String category;
    private Date creationDate;


    public Integer getPostId() {
        return this.postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }    
}
