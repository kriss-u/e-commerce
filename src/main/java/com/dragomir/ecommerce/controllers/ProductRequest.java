package com.dragomir.ecommerce.controllers;

public class ProductRequest {
    private Long productId;
    private String username;
    private Integer quantity;

    public ProductRequest() {
    }

    public ProductRequest(Long productId, String username, Integer quantity) {
        this.productId = productId;
        this.username = username;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}