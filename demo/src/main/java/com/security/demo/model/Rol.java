
package com.security.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.security.demo.model.Users;
import java.util.List;



@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Aquí está el auto-increment
    @Column(name = "rol_id")
    private Integer rolId;
    
    @Column(name = "rol_name")
    private String rolName;
  
    @ManyToMany(mappedBy = "roles")
private List<Users> users; // ✅ nombre plural y tipo correcto
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
       


    // Getters y setters correctos
public List<Users> getUsers() {
    return users;
}

public void setUsers(List<Users> users) {
    this.users = users;
}
    public String getRolName() {
        return rolName;
    }
    
    public void setRolName(String rolName) {
        this.rolName = rolName;
    }



}
