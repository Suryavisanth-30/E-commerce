package com.example.Spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Spring.Model.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
   
    List<Product> findByCategory(String category);
    List<Product> findByNameContainingIgnoreCase(String name);
}