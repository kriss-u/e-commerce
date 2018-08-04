package com.dragomir.ecommerce.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Lob;

@Document(indexName = "onlineshop", type = "product")
public class Book {

    @Id
    private Long id;
    private String name;
    private String model;
    private String brand;

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    private String subcategory;
    private Long cost;
    private String description;
    private String specifications;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", subcategory='" + subcategory + '\'' +
                ", cost=" + cost +
                ", description='" + description + '\'' +
                ", specifications='" + specifications + '\'' +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Book() {
    }

    public Book(Long id, String name, String model,String description,String specifications,Long cost,String brand,String subcategory) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.brand = brand;
        this.subcategory = subcategory;
        this.cost = cost;
        this.description = description;
        this.specifications = specifications;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
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

}



