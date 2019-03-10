package com.randyc.shoppingcart.controller;

import com.randyc.shoppingcart.models.Product;
import com.randyc.shoppingcart.repository.ProductRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    private ProductRepository productrepos;

    @ApiOperation(value = "List all products and products suppliers", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @GetMapping
    public List<Product> listAllProducts() {
        return productrepos.findAll();
    }

    @ApiOperation(value = "List all products and products suppliers by id", response = Optional.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @GetMapping("/product/{id}")
    public Product findProductById(@ApiParam(value="Param for id")@PathVariable long id) {
       Optional<Product> foundProduct = productrepos.findById(id);
       if (foundProduct.isPresent()) {
           return foundProduct.get();
       } else {
           return null;
       }
    }

    @ApiOperation(value = "Create new product", response = Optional.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @PostMapping
    public Product addProduct(@ApiParam(value="Params for request body")@RequestBody Product newproduct) throws URISyntaxException {
        return productrepos.save(newproduct);
    }

    @ApiOperation(value = "Update an existing product", response = Optional.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @PutMapping("/product/{id}")
    public Product updateProduct(@ApiParam(value="Params for request body")@RequestBody Product updatedProduct, @ApiParam(value="Id for existing product")@PathVariable long id) throws URISyntaxException {
        Optional<Product> updateProduct = productrepos.findById(id);
        if (updateProduct.isPresent()) {
            updatedProduct.setProductid(id);
            productrepos.save(updatedProduct);
            return updatedProduct;
        } else {
            return null;
        }
    }

    @ApiOperation(value = "Delete existing product", response = Optional.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resources you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach can not be found")
    })
    @DeleteMapping
    public Product deleteProductById(@ApiParam(value="Id to delete product")@PathVariable long id) {
        var foundProduct = productrepos.findById(id);
        if (foundProduct.isPresent() ) {
            productrepos.deleteById(id);
            return foundProduct.get();
        } else {
            return null;
        }
    }
}
