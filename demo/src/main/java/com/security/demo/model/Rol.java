
package com.security.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "rol_id")
    private Integer rolId;
    
    @Column(name = "rol_name")
    private String rolName;

      @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonIgnore // Evita problemas de serialización circular
    private Set<Users> users = new HashSet<>();
    public Rol() {
        
    }
    
    public Rol(Integer rolId, String rolName) {
        this.rolId = rolId;
        this.rolName = rolName;
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
  public Set<Users> getUsers() {
        return users;
    }
    
    public void setUsers(Set<Users> users) {
        this.users = users;
    }


}
