package com.dragomir.ecommerce.controllers;

import java.util.List;

public class CategorySubCategory {
    private String categoryName;
    private String categoryIcon;
    private List<Name> names;

    public CategorySubCategory() {
    }

    public CategorySubCategory(String categoryName, String categoryIcon, List<Name> names) {
        this.categoryName = categoryName;
        this.categoryIcon = categoryIcon;
        this.names = names;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }
}
