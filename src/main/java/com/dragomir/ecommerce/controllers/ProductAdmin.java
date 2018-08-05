package com.dragomir.ecommerce.controllers;

import java.math.BigDecimal;

public class ProductAdmin {
    private String name;
    private String model;
    private Long subCategoryId;
    private Long brandId;
    private BigDecimal cost;
    private String description;
    private String specifications;
    private Integer inventory;

    public ProductAdmin() {
    }

    public ProductAdmin(String name, String model, Long subCategoryId, Long brandId, BigDecimal cost, String description, String specifications, Integer inventory) {
        this.name = name;
        this.model = model;
        this.subCategoryId = subCategoryId;
        this.brandId = brandId;
        this.cost = cost;
        this.description = description;
        this.specifications = specifications;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }
}
