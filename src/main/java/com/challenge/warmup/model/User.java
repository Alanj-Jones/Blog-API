package com.challenge.warmup.model;

public class User {
    
    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        
    }

    private Integer userId;
    private String email;
    private String password;

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
