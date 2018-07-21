package com.dragomir.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String iconName;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "category")
    private Set<SubCategory> subCategories = new HashSet<>();


    public Category() {
    }

    public Category(String name, String iconName) {
        this.name = name;
        this.iconName = iconName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public Set<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
