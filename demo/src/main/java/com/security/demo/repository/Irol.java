package com.security.demo.repository;
import com.security.demo.model.Rol;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Irol  extends  JpaRepository<Rol, Integer> {
    @Query("select r from Rol r")
    List<Rol> findAll();
    @Query("select r from Rol r where r.rolId = :id")
    Optional<Rol> findById(Integer id);


}
