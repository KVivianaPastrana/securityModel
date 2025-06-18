package com.security.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class userPublicController {

@PostMapping("/login")
public ResponseEntity<String> login (@RequestBody String entity){
return new ResponseEntity<>(body:"end-point Publico login",HttpStatus.OK);
}

@PostMapping("/register")
public ResponseEntity<String> register (@RequestBody String entity){ 
        return new ResponseEntity<>(body:"end-point Publico register", HttpStatus.OK);

}
}
