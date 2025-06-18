package com.security.demo.repository;
import com.security.demo.model.Users;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
public interface Iuser extends JpaRepository<Users, Integer> {
    List<Users> findAll();

    @Query("SELECT u FROM Users u WHERE u.status != false")
    List<Users> getListUserActive();
    
    Optional<Users> findByUsername(String username);
    
    Optional<Users> findByEmail(String email);

    List<Users> findAllByStatus(boolean status);
}
