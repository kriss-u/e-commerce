package com.dragomir.ecommerce.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderedProduct {

    @EmbeddedId
    private OrderedProductId id = new OrderedProductId();

    @ManyToOne
    @MapsId("orderId")
    private UserOrder userOrder;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    private Integer quantity;

    private BigDecimal cost;

    public OrderedProduct() {
    }

    public OrderedProduct(OrderedProductId id, UserOrder userOrder, Product product, Integer quantity, BigDecimal cost) {
        this.id = id;
        this.userOrder = userOrder;
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
    }

    public OrderedProductId getId() {
        return id;
    }

    public void setId(OrderedProductId id) {
        this.id = id;
    }

    public UserOrder getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(UserOrder userOrder) {
        this.userOrder = userOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
