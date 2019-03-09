package com.randyc.shoppingcart.service;

import com.randyc.shoppingcart.models.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}