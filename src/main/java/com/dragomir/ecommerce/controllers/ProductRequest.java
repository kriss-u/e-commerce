package com.dragomir.ecommerce.controllers;

public class ProductRequest {
    private Long productId;
    private Long userId;
    private Integer quantity;

    public ProductRequest() {
    }

    public ProductRequest(Long productId, Long userId, Integer quantity) {
        this.productId = productId;
        this.userId = userId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}