package com.randyc.shoppingcart.repository;

import com.randyc.shoppingcart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
