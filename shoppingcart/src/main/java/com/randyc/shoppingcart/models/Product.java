package com.randyc.shoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productid;

//    @ManyToMany
//    @JoinTable(name = "order_products",
//    joinColumns = {@JoinColumn(name = "productid")}, inverseJoinColumns = {@JoinColumn(name = "orderid")})
//    private Set<Order> productsorders = new HashSet<>();

    // Product Fields
    private String productname;
    private String description;
    private int quantity;
    private double price;

    // Many to Many With Supplier
    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties("products")
    private Set<Supplier> suppliers = new HashSet<>();

    public Product() {}

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

//    public Set<Order> getProductsorders() {
//        return productsorders;
//    }
//
//    public void setProductsorders(Set<Order> productsorders) {
//        this.productsorders = productsorders;
//    }


    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
