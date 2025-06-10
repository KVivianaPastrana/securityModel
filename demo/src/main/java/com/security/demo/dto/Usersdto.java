package com.security.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Usersdto {
private String username;
private String email;
    @JsonIgnore
private String password;
private Boolean status;
private List<Roldto> roles;

    public Usersdto() {
    }

    public Usersdto(String username, String email, String password, Boolean status) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        
    }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
    
       public List<Roldto> getRoles() {
        return roles;
    }

    public void setRoles(List<Roldto> roles) {
        this.roles = roles;
    }
}


