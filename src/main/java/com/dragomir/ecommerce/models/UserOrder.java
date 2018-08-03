package com.dragomir.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "userOrder", targetEntity = OrderedProduct.class, cascade = CascadeType.ALL)
    private List<OrderedProduct> orderedProducts;

    public UserOrder() {
    }

    public UserOrder(User user) {
        this.user = user;
    }

    public UserOrder(BigDecimal amount, User user, List<OrderedProduct> orderedProducts) {
        this.amount = amount;
        this.user = user;
        this.orderedProducts = orderedProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderedProduct> getOrderedProducts() {
        List<OrderedProduct> orderedProduct = new ArrayList<>();
        return orderedProducts == null ? orderedProduct : orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public void addOrderedProduct(OrderedProduct orderedProduct) {
        this.orderedProducts.add(orderedProduct);
    }
}
