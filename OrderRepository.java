package com.example.Spring.Repository;

import com.example.Spring.Model.Order;
import com.example.Spring.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByUser(User user);

    List<Order> findByStatus(String status);
    List<Order> findByProductId(int productId);
    List<Order> findByUserAndStatus(User user, String status);
}