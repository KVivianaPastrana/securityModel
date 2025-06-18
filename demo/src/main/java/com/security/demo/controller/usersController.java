package com.security.demo.controller;

import com.security.demo.dto.ResponseDTO;
import com.security.demo.dto.Usersdto;
import com.security.demo.model.Users;
import com.security.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
@RequiredArgsConstructor
public class usersController {
    @GetMapping("/profile/")
    public ResponseEntity<String> getProfile(){
        return new ResponseEntity<>("end-point privado profile",HttpStatus.OK);
    }
}