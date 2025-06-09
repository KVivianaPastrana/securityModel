package com.security.demo.service;
import com.security.demo.dto.ResponseDTO;
import org.springframework.stereotype.Service;
import com.security.demo.model.Users;
import com.security.demo.repository.Iuser;  
import com.security.demo.dto.Usersdto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;          

@Service
public class userService {
    @Autowired
    private Iuser iusers;

    public List<Users> findAll() {
        return iusers.findAll();
    }   
   
    public Optional<Users> getUserById(Integer id) {
        return iusers.findById(id);
    }

    public ResponseDTO createUser(Users user) {
    try {
        // Aquí puedes validar si el usuario ya existe, si quieres
        iusers.save(user);  // Guarda el usuario nuevo en la base de datos
        return new ResponseDTO("User created successfully", true, user);
    } catch (Exception e) {
        return new ResponseDTO("Error creating user", false, null);
    }
}

     
public ResponseDTO deleteUser(Integer id) {
    try {
        Optional<Users> user = iusers.findById(id); // <-- corregido aquí

        if (!user.isPresent()) { // corregido: si no está presente, es "not found"
            return new ResponseDTO("User not found", false, null);
        }
        iusers.deleteById(id);  // Aquí borras el registro


        return new ResponseDTO("User deleted successfully", true, null);
    } catch (Exception e) {
        return new ResponseDTO("Error deleting user", false, null);
    }
}

   public Users save (Users user) {
    return iusers.save(user);
   }

public ResponseDTO updateUser(Users user) {
    try {
        Optional<Users> existingUser = iusers.findById(user.getUserId());
        if (!existingUser.isPresent()) {
            return new ResponseDTO("User not found", false, null);
        }

        existingUser.get().setUsername(user.getUsername());
        existingUser.get().setEmail(user.getEmail());
        iusers.save(existingUser.get());

        return new ResponseDTO("User updated successfully", true, null);
    } catch (Exception e) {
        return new ResponseDTO("Error updating user", false, null);
    }
}


   public Usersdto convertToDTO(Users user) {
    Usersdto dto = new Usersdto();
    dto.setUserId(user.getUserId());
    dto.setUsername(user.getUsername());
    dto.setEmail(user.getEmail());
    dto.setPassword(user.getPassword());
    dto.setStatus(user.getStatus());
    
    return dto;
   }

   public Users convertToModel(Usersdto dto) {
    Users user = new Users();
    user.setUserId(dto.getUserId());
    user.setUsername(dto.getUsername());
    user.setEmail(dto.getEmail());
    user.setPassword(dto.getPassword());
    user.setStatus(dto.getStatus());   
    return user;
   }
}
