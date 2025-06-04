package com.security.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
    


@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Aquí está el auto-increment
    @Column(name = "rol_id")
    private Integer rolId;
    
    @Column(name = "rol_name")
    private String rolName;
    
    public Rol(Integer rolId, String rolName) {
        this.rolId = rolId;
        this.rolName = rolName;
    }
    
    public Rol() {
        
    }
    
    public Integer getRolId() {
        return rolId;
    }
    
    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }
    
    public String getRolName() {
        return rolName;
    }
    
    public void setRolName(String rolName) {
        this.rolName = rolName;
    }



}
