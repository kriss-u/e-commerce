package com.dragomir.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "sub_category_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private SubCategory subCategory;

    private String model;

    private BigDecimal cost;

    @Lob
    private String description;

    @Lob
    private String specifications;

    private Integer inventory;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", targetEntity = Cart.class)
    @JsonIgnore
    private List<Cart> carts;

    @OneToMany(mappedBy = "product", targetEntity = OrderedProduct.class)
    private List<OrderedProduct> orderedProducts;

    private String status;

    public Product() {
    }

    public Product(String name, Brand brand, SubCategory subCategory, String model, BigDecimal cost, String description, String specifications, Integer inventory, List<Cart> carts, List<OrderedProduct> orderedProducts, String status) {
        this.name = name;
        this.brand = brand;
        this.subCategory = subCategory;
        this.model = model;
        this.cost = cost;
        this.description = description;
        this.specifications = specifications;
        this.inventory = inventory;
        this.carts = carts;
        this.orderedProducts = orderedProducts;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public void addOrderedProducts(OrderedProduct orderedProduct) {
        this.orderedProducts.add(orderedProduct);
    }
}
