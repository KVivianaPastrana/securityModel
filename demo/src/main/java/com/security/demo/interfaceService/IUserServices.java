package com.security.demo.interfaceService;


import java.util.List;
import java.util.Optional;

import  com.security.demo.model.Users;
import  com.security.demo.model.registerRequest;

public interface IUserServices {
public Users register (registerRequest request);
public Optional<Users> findByUsername(String username);
public int delete(String id);
public List<Users> findAll();

}
