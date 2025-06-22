package com.security.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.security.demo.repository.Iuser;
import com.security.demo.interfaceService.IUserServices;
import com.security.demo.model.Users;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class authService implements  IUserServices{
    private final Iuser userRepository;
    private final jwtService jwtService;


    public  authResponse register ( registerRequest request) {
        user userData = User.builder()
        .first_name(request.getFirstName())
        .last_name(request.getLastName())
        .username(request.getUsername())
        .password(request.getPassword())
        .build();
      userRepository.save(userData);
      return authResponse.builder()
      .token(jwtService.getToken(userData))
      .build();
    }

    public authResponse login(loginRequest request) {
        return new authResponse(),
    }
}