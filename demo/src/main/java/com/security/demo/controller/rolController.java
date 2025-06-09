package com.security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.security.demo.model.Rol;
import com.security.demo.service.rolService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.security.demo.dto.Roldto;
import java.util.Optional;
import org.springframework.http.ResponseEntity;


import org.springframework.http.HttpStatus;
import java.util.List;


@RestController
@RequestMapping("/rol")
public class rolController {
@Autowired
private rolService rolService;

    @GetMapping
    public List<Rol> findAll() {
        return rolService.findAll();
    }       
    @GetMapping("/{id}")
    public ResponseEntity<Object> getRolById(@PathVariable Integer id) {
        Optional<Rol> rol = rolService.getRolById(id);

        if (rol.isPresent()) {
            return new ResponseEntity<>(rol.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Rol not found", HttpStatus.NOT_FOUND);
        }
    }
    // POST /rol
    @PostMapping
    public ResponseEntity<Object> createRol(@RequestBody Roldto rolDto) {
        // Mapear DTO a entidad Rol
        Rol rolEntity = new Rol();
        rolEntity.setRolName(rolDto.getRolName());
        // No se setea rolId porque normalmente es generado por la base de datos al crear

        var response = rolService.createRol(rolEntity);  // Asumo que tienes un método createRol en tu servicio
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Object> updateRol(@RequestBody Roldto rolDto) {
        // Mapeo manual de DTO a entidad Rol
        Rol rolEntity = new Rol();
        rolEntity.setRolId(rolDto.getRolId());
        rolEntity.setRolName(rolDto.getRolName());

        var response = rolService.updateRol(rolEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRol(@PathVariable Integer id) {
        var rol = rolService.deleteRol(id);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

}
