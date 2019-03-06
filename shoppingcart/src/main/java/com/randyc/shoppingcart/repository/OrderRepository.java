package com.randyc.shoppingcart.repository;

import com.randyc.shoppingcart.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
