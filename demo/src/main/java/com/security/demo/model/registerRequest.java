package com.security.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class registerRequest {
 private String firstName;
 private String lastName;
 private String username;
 private String password;
}
