package com.security.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Usersdto {
    private Integer userId;
    private String username;
    private String email;
    @JsonIgnore
private String password;

    private Boolean status;

    // ✅ NUEVO: lista de roles
    private List<Integer> roleIds;  // Podrías también usar List<RolDto> si quieres más detalles por rol

    public Usersdto() {
    }

    public Usersdto(Integer userId, String username, String email, String password, Boolean status, List<Integer> roleIds) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.roleIds = roleIds;
    }

    // Getters y setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }

    public List<Integer> getRoleIds() { return roleIds; }
    public void setRoleIds(List<Integer> roleIds) { this.roleIds = roleIds; }
    
}
