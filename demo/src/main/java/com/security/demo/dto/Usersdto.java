package com.security.demo.dto;


public class Usersdto {
    private Integer userId;
    private String username;
    private String email;   
    private String password;
    private Boolean status;
    public Usersdto(Integer userId, String username, String email, String password,Boolean status) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }   
    public Usersdto() {
        
    }

     public Integer getUserId() {
        return userId;
    }

     public void setUserId(Integer userId) {
        this.userId = userId;
    }

     public String getUsername() {
        return username;
    }

     public void setUsername(String username) {
        this.username = username;
    }

     public String getEmail() {
        return email;
    }

     public void setEmail(String email) {
        this.email = email;
    }

     public String getPassword() {
        return password;
    }   
    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
