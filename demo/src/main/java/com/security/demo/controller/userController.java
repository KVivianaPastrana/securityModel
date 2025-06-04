package com.security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.security.demo.model.Users;
import com.security.demo.service.userService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.security.demo.dto.Usersdto;
import java.util.Optional;
import org.springframework.http.ResponseEntity;


import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private userService userService;

    @GetMapping
    public List<Users> findAll() {
        return userService.findAll();
    }

@GetMapping("/{id}")
public ResponseEntity<Object> getUserById(@PathVariable Integer id) {
    Optional<Users> user = userService.getUserById(id);

    if (user.isPresent()) {
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}
@PostMapping
public ResponseEntity<Object> createUser(@RequestBody Usersdto userDto) {
    // Mapear DTO a entidad Users
    Users userEntity = new Users();
    userEntity.setUsername(userDto.getUsername());
    userEntity.setEmail(userDto.getEmail());
    // No se setea userId porque normalmente es generado por la base de datos al crear

    var response = userService.createUser(userEntity);  // Asumo que tienes un método createUser en tu servicio
    return new ResponseEntity<>(response, HttpStatus.CREATED);
}


    @PutMapping
public ResponseEntity<Object> updateUser(@RequestBody Usersdto userDto) {
    // Mapeo manual de DTO a entidad Users
    Users userEntity = new Users();
    userEntity.setUserId(userDto.getUserId());
    userEntity.setUsername(userDto.getUsername());
    userEntity.setEmail(userDto.getEmail());

    var response = userService.updateUser(userEntity);
    return new ResponseEntity<>(response, HttpStatus.OK);
}


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Integer id) {
        var user = userService.deleteUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
