package com.security.demo.repository;
import com.security.demo.model.Users;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface Iuser  extends  JpaRepository<Users, Integer> {
    @Query("select u from Users u")
    List<Users> findAll();
    @Query("select u from Users u where u.userId = :id")
    Optional<Users> findById(Integer id);

}
