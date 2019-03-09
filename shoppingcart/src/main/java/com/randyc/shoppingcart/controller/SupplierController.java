package com.randyc.shoppingcart.controller;

import com.randyc.shoppingcart.models.Supplier;
import com.randyc.shoppingcart.repository.SupplierRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierController {

    @Autowired
    private SupplierRepository supplierrepos;

    @ApiOperation(value = "List all suppliers and suppliers products", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @GetMapping
    public List<Supplier> listAllSuppliers() {
        return supplierrepos.findAll();
    }
}
