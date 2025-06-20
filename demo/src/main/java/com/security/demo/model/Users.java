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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users implements UserDetails   {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Aquí está el auto-increment
    @Column(name = "user_id",nullable = false)
    private Integer userId;

    @Column(name = "first_name,nullable = false,length = 50")
    private String firstName;

    @Column(name = "last_name,nullable = false,length = 50")
    private String lastName;

    @Column(name = "username,nullable = false,length = 50")
    private String username;

    @Column(name = "password,nullable = false,length = 20")
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(rol.getRolName()));
    }


    @Override
    public String getUsername() {
        return username;
    }
    
}
