package com.security.demo.service;
import com.security.demo.dto.ResponseDTO;
import org.springframework.stereotype.Service;
import com.security.demo.model.Rol;
import com.security.demo.repository.Irol;  
import com.security.demo.dto.Roldto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;          

@Service
public class rolService {
    @Autowired
    private Irol irol;

    public List<Rol> findAll() {
        return irol.findAll();
    }
    public Optional<Rol> getRolById(Integer id) {
        return irol.findById(id);
    }

    public ResponseDTO createRol(Rol rol) {
    try {
        // Aquí puedes validar si el rol ya existe, si quieres
        irol.save(rol);  // Guarda el rol nuevo en la base de datos
        return new ResponseDTO("Rol created successfully", true, rol);
    } catch (Exception e) {
        return new ResponseDTO("Error creating rol", false, null);
    }
}
     
public ResponseDTO deleteRol(Integer id) {
    try {
        Optional<Rol> rol = irol.findById(id); // <-- corregido aquí

        if (!rol.isPresent()) { // corregido: si no está presente, es "not found"
            return new ResponseDTO("Rol not found", false, null);
        }

        rol.get().setRolId(null);
        irol.save(rol.get());

        return new ResponseDTO("Rol deleted successfully", true, null);
    } catch (Exception e) {
        return new ResponseDTO("Error deleting rol", false, null);
    }
}

   public Rol save (Rol rol) {
    return irol.save(rol);
   }

public ResponseDTO updateRol(Rol rol) {
    try {
        Optional<Rol> existingRol = irol.findById(rol.getRolId());
        if (!existingRol.isPresent()) {
            return new ResponseDTO("Rol not found", false, null);
        }

        existingRol.get().setRolId(rol.getRolId());
        irol.save(existingRol.get());

        return new ResponseDTO("Rol updated successfully", true, null);
    } catch (Exception e) {
        return new ResponseDTO("Error updating rol", false, null);
    }
}


   public Roldto convertToDTO(Rol rol) {
    Roldto dto = new Roldto();
    dto.setRolId(rol.getRolId());
    dto.setRolId(rol.getRolId());
    
    return dto;
   }    
   public Rol convertToModel(Roldto dto) {
    Rol rol = new Rol();
    rol.setRolId(dto.getRolId());
    rol.setRolId(dto.getRolId());
    return rol;
   }    

}
