package com.security.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.security.demo.repository.Iuser;
import com.security.demo.model.Users;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class authService implements  Iuser{
    private final Iuser userRepository;
    private final jwtServide jwtService;


    public 
}