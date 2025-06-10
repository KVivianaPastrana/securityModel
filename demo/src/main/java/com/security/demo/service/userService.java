package com.security.demo.service;

import com.security.demo.dto.ResponseDTO;
import com.security.demo.dto.Roldto;
import com.security.demo.dto.Usersdto;
import com.security.demo.model.Rol;
import com.security.demo.model.Users;
import com.security.demo.repository.Irol;
import com.security.demo.repository.Iuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class userService {

    @Autowired
    private Iuser userRepository;
    
    @Autowired
    private Irol roleRepository;

   public List<Usersdto> getAllActiveUsers() {
    return userRepository.getListUserActive().stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
}

    public Optional<Users> getUserById(Integer id) {
        return userRepository.findById(id);
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
  

    Users savedUser = userRepository.save(user);
    return new ResponseDTO("User created successfully", true, convertToDto(savedUser));
}

public ResponseDTO updateUser(Integer id, Usersdto userDto) {
    return userRepository.findById(id)
        .map(existingUser -> {
            existingUser.setUsername(userDto.getUsername());
            existingUser.setEmail(userDto.getEmail());
            
            if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
                existingUser.setPassword(userDto.getPassword());
            }
            
 
            
            Users updatedUser = userRepository.save(existingUser);
            return new ResponseDTO("User updated successfully", true, convertToDto(updatedUser));
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
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); 
        user.setStatus(dto.getStatus());
        
        return user;
    }

    public Usersdto convertToDto(Users user) {
    Usersdto dto = new Usersdto();
    dto.setUsername(user.getUsername());
    dto.setEmail(user.getEmail());
    dto.setStatus(user.getStatus());
    // NO setRoles por ahora
    return dto;
}


}

