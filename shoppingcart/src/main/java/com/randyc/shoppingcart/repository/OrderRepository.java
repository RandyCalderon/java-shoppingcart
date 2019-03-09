package com.randyc.shoppingcart.repository;

import com.randyc.shoppingcart.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "INSERT INTO user_orders VALUES(:orderid, :userid)", nativeQuery = true)
    Order insertIntoUserOrders(@Param("orderid") long orderid, @Param("userid") long userid);
}
