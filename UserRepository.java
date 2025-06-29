package com.example.Spring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Spring.Model.*;
public interface UserRepository extends JpaRepository<User,Integer> {
    public List<User> findByEmail(String email);
}
