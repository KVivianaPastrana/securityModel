package com.security.demo.service;

import com.security.demo.dto.ResponseDTO;
import com.security.demo.dto.Roldto;
import com.security.demo.dto.Usersdto;
import com.security.demo.model.Rol;
import com.security.demo.model.Users;
import com.security.demo.repository.Irol;
import com.security.demo.repository.Iuser;

import lombok.RequiredArgsConstructor;

import com.security.demo.dto.ResponseLogin;
import com.security.demo.dto.RequestRegisterUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class userService {

    private final Iuser userRepository;
    private final jwtServide jwtService;
    private final PasswordEncoder passwordEncoder;
    //Manejador de autenticación
    private final AuthenticationManager authenticationManager;
    

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Optional<Users> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public Optional<Users> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<Users> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    //Metodo para eliminar un usuario por Id
     public ResponseDTO deleteUser(Integer id) {
      Optional <Users> usuario = findById(id);
      if(!usuario.isPresent()){
        //Si no existe el usuario
        return new ResponseDTO(HttpStatus.NOT_FOUND.toString(), "Usuario no encontrado");
      }
      //Si se encuentra el usuario, elimina el usuario
      userRepository.deleteById(id);
      return new ResponseDTO(HttpStatus.OK.toString(), "Usuario eliminado correctamente");
    }


    //Metodo para registrar un usuario
    public ResponseDTO save (RequestRegisterUserDTO userDTO){
    //Se convierte el DTO recibido en un modelo Users
    Users usuario = convertToModelRegister(userDTO);
    //Encriptamos la contraseña
    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

    //Se guarda el usuario en la base de datos
    userRepository.save(usuario);
    return new ResponseDTO(HttpStatus.OK.toString(), "Usuario creado correctamente");
}

//Metodo para hacer login

public ResponseLogin login (RequestLoginDTO login){
//Autenticacion con nombre de usuario y contraseña
authenticationManager.authenticate(
    new UsernamePasswordAuthenticationToken(
     login.getUsername(),
     login.getPassword()));

//Obtener detalles del usuario desde el repositorio
UserDetails user = userRepository.findByUsername(login.getUsername()).orElseThrow();

//Generar token JWR y devolverlo
ResponseLogin response = new ResponseLogin(jwtService.getToken(user));



}










}