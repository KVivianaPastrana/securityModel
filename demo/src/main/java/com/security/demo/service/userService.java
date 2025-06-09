package com.security.demo.service;

import com.security.demo.dto.ResponseDTO;
import com.security.demo.dto.Usersdto;
import com.security.demo.model.Rol;
import com.security.demo.model.Users;
import com.security.demo.repository.Irol;
import com.security.demo.repository.Iuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class userService {

    @Autowired
    private Iuser userRepository;
    
    @Autowired
    private Irol roleRepository;

    public List<Users> getAllActiveUsers() {
        return userRepository.getListUserActive();
    }

    public Optional<Users> getUserById(Integer id) {
        return userRepository.findById(id);
    }


    public Usersdto convertToDTO(Users user) {
        Usersdto dto = new Usersdto();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setStatus(user.getStatus());
        
        if (user.getRoles() != null) {
            dto.setRoleIds(user.getRoles().stream()
                .map(Rol::getRolId)
                .collect(Collectors.toList()));
        }
        
        return dto;
    }

public ResponseDTO saveUser(Usersdto userDto) {
    // Validaciones básicas
    if (userRepository.existsByUsername(userDto.getUsername())) {
        ResponseDTO response = new ResponseDTO();
        response.setMessage("Username already exists");
        response.setSuccess(false);
        return response;
    }
    
    if (userRepository.existsByEmail(userDto.getEmail())) {
        ResponseDTO response = new ResponseDTO();
        response.setMessage("Email already exists");
        response.setSuccess(false);
        return response;
    }

    Users user = convertToModel(userDto);
    user.setStatus(true); // Por defecto activo
    
    // Asignar roles si existen en el DTO
      // Manejo de roles (ahora con Integers)
    if (userDto.getRoleIds() != null && !userDto.getRoleIds().isEmpty()) {
        List<Rol> roles = roleRepository.findAllById(userDto.getRoleIds());
        user.setRoles(roles);
    }

    Users savedUser = userRepository.save(user);
    return new ResponseDTO("User created successfully", true, convertToDTO(savedUser));
}

public ResponseDTO updateUser(Integer id, Usersdto userDto) {
    return userRepository.findById(id)
        .map(existingUser -> {
            existingUser.setUsername(userDto.getUsername());
            existingUser.setEmail(userDto.getEmail());
            
            if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
                existingUser.setPassword(userDto.getPassword());
            }
            
            // Manejo de roles - CORRECCIÓN: usar existingUser en lugar de user
            if (userDto.getRoleIds() != null && !userDto.getRoleIds().isEmpty()) {
                List<Rol> roles = roleRepository.findAllById(userDto.getRoleIds());
                existingUser.setRoles(roles);  // Cambiado de user a existingUser
            }
            
            Users updatedUser = userRepository.save(existingUser);
            return new ResponseDTO("User updated successfully", true, convertToDTO(updatedUser));
        })
        .orElseGet(() -> {
            ResponseDTO response = new ResponseDTO();
            response.setMessage("User not found");
            response.setSuccess(false);
            return response;
        });
}

    public Users convertToModel(Usersdto dto) {
        Users user = new Users();
        user.setUserId(dto.getUserId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // Asignación directa sin encriptar
        user.setStatus(dto.getStatus());
        
        return user;
    }
}