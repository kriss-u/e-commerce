package com.dragomir.ecommerce.models;

import javax.persistence.*;

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "customer")
    private Customer customer;
}
