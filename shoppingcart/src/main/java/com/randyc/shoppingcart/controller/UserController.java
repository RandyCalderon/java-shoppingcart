package com.randyc.shoppingcart.controller;

import com.randyc.shoppingcart.models.User;
import com.randyc.shoppingcart.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userrepos;

    @ApiOperation(value = "List all Users", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @Secured("ROLE_USER")
    @GetMapping
    public List<User> listAllUsers() {
        return userrepos.findAll();
    }

    @ApiOperation(value = "Get user by username", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @GetMapping("/user/{username}")
    public User findByUsername(@ApiParam(value="Name of user") @PathVariable String name) {
        return userrepos.findByUsername(name);
    }

//    @ApiOperation(value = "Get user's orders", response = List.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
//    })
//    @GetMapping("/user/orders")

//    @Secured("ROLE_USER")
//    @GetMapping("/user/orders")
//    public Object getUserId() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        long userId = userrepos.findUserId(username);
//        return userId;
//    }

}