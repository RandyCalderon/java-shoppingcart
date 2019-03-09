package com.randyc.shoppingcart.controller;

import com.randyc.shoppingcart.models.Order;
import com.randyc.shoppingcart.models.User;
import com.randyc.shoppingcart.repository.OrderRepository;
import com.randyc.shoppingcart.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    private OrderRepository orderrepos;

    @Autowired
    private UserRepository userrepos;

    @ApiOperation(value = "List all products and products suppliers", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @GetMapping
    public List<Order> listAllOrders() {
        return orderrepos.findAll();
    }

    /* Posting to order has to create an order and that order must decrement from the quantity of products and also insert into
        user orders
     */
//    @ApiOperation(value = "Create order for user", response = List.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
//    })
//    @PostMapping
//    public Order createOrder(@ApiParam(value="Order body")@RequestBody Order neworder) throws URISyntaxException {
//
//        orderrepos.insertIntoUserOrders(id, neworder.getOrderid());
//        orderrepos.save(neworder);
//    }
}
