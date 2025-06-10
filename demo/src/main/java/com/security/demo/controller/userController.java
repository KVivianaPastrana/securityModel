package com.security.demo.controller;

import com.security.demo.dto.ResponseDTO;
import com.security.demo.dto.Usersdto;
import com.security.demo.model.Users;
import com.security.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class userController {

    @Autowired
    private userService userService;

    @GetMapping
public ResponseEntity<ResponseDTO> getAllActiveUsers() {
    List<Usersdto> users = userService.getAllActiveUsers();  // Cambiado a Usersdto
    ResponseDTO response = new ResponseDTO();
    response.setMessage("Active users retrieved successfully");
    response.setSuccess(true);
    response.setData(users);
    return ResponseEntity.ok(response);
}


    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getUserById(@PathVariable Integer id) {
        Optional<Users> user = userService.getUserById(id);
        
        if (user.isPresent()) {
            ResponseDTO response = new ResponseDTO();
            response.setMessage("User found");
            response.setSuccess(true);
            response.setData(user.get());
            return ResponseEntity.ok(response);
        } else {
            ResponseDTO response = new ResponseDTO();
            response.setMessage("User not found");
            response.setSuccess(false);
            return ResponseEntity.status(404).body(response);
        }
    }

    // Crear nuevo usuario
    @PostMapping
    public ResponseEntity<ResponseDTO> createUser(@RequestBody Usersdto userDto) {
        ResponseDTO serviceResponse = userService.saveUser(userDto);
        
        if (serviceResponse.isSuccess()) {
            return ResponseEntity.status(201).body(serviceResponse);
        } else {
            return ResponseEntity.badRequest().body(serviceResponse);
        }
    }

    // Actualizar usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateUser(
            @PathVariable Integer id,
            @RequestBody Usersdto userDto) {
        ResponseDTO serviceResponse = userService.updateUser(id, userDto);
        
        if (serviceResponse.isSuccess()) {
            return ResponseEntity.ok(serviceResponse);
        } else {
            return ResponseEntity.status(404).body(serviceResponse);
        }
    }

    // Desactivar usuario (eliminación lógica)
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> deactivateUser(@PathVariable Integer id) {
        // Nota: Necesitarías implementar este método en tu service
        ResponseDTO response = new ResponseDTO();
        response.setMessage("Method not implemented yet");
        response.setSuccess(false);
        return ResponseEntity.status(501).body(response);
    }
}