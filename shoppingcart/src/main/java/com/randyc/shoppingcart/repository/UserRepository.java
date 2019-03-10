package com.randyc.shoppingcart.repository;

import com.randyc.shoppingcart.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String username);

    @Query(value = "SELECT userid from user WHERE username = :username ", nativeQuery = true)
    long findUserId(String username);


}
