package com.security.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.security.demo.repository.Iuser;
import com.security.demo.interfaceService.IUserServices;
import com.security.demo.model.Users;
import com.security.demo.model.loginRequest;
import com.security.demo.model.registerRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class authService implements  IUserServices{
    private final Iuser userRepository;
    private final jwtService jwtService;

    // Método que maneja el registro de un nuevo usuario
    public  authResponse register ( registerRequest request) {
// Se construye el objeto userData con los datos recibidos desde el formulario de registro

        user userData = User.builder()
        .first_name(request.getFirstName())
        .last_name(request.getLastName())
        .role(role.User)  //Se asigna el rol User por defecto
        .username(request.getUsername())
        .password(request.getPassword())
        .build();
      userRepository.save(userData); //Se guarda el usuario en la base de datos
     
     //Se genera el token de JWT y se retorna como respuesta
      return authResponse.builder() 
      .token(jwtService.getToken(userData)) //Se genera el token usando los datos del usuario
      .build();  //Se retorna el Objeto authResponse
    }



    // Método que maneja el login de un usuario
    public authResponse login(loginRequest request) {
        return new authResponse();
    }
}