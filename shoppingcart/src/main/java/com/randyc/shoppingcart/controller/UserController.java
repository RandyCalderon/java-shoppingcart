package com.randyc.shoppingcart.controller;

import com.randyc.shoppingcart.models.User;
import com.randyc.shoppingcart.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
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

    @GetMapping("/user/email/{email}")
    public User findByByEmail(@PathVariable String email) {
        return userrepos.findByEmail(email);
    }

    @ApiOperation(value = "Create a new user", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created user"),
            @ApiResponse(code = 500, message = "User already exists")
    })
    @PostMapping
    public Object createuser(@ApiParam(value = "User body")@RequestBody User newUser) throws URISyntaxException, Exception{
        String checkEmail = newUser.getEmail();
        if(userrepos.findEmail(checkEmail) != null) {
           return "{username unique constraint : " + newUser.getEmail() + " already exists}";
        } else {
           return userrepos.save(newUser);
        }
    }


    // Need to make put mapping for user info and updating profile changes to specific id for user authenticated
//    @PutMapping("/user/{id}")



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