package com.randyc.shoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    // User Fields
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    @JsonIgnoreProperties("userid")
    private Set<Order> order = new HashSet<>();

    private String role;
    private String firstname;
    private String middlename;
    private String lastname;
    private String phonenumber;
    private String email;

    public User() {}
}
