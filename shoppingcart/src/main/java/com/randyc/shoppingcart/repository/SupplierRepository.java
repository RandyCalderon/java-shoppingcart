package com.randyc.shoppingcart.repository;

import com.randyc.shoppingcart.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
