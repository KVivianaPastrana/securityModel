package com.security.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class Users   implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Aquí está el auto-increment
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Rol rol;

    @Column(name="status")
    private Boolean status;


    public Users(Integer userId, String username, String email, String password, Boolean status, Rol rol) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public Users() {
        
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
     
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    public Rol getRol() {
        return rol;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.getRolName()));
    }
    
}
