package com.dragomir.ecommerce.controllers;

import com.dragomir.ecommerce.models.SubCategory;
import com.dragomir.ecommerce.services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping
    public @ResponseBody
    Iterable<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }

    @GetMapping("/{subCategoryId}")
    public @ResponseBody
    SubCategory getSubCategory(@PathVariable Long subCategoryId) {
        return subCategoryService.getSubCategory(subCategoryId);
    }

    @PostMapping
    public void addSubCategory(@RequestBody SubCategory subCategory) {
        subCategoryService.addSubCategory(subCategory);
    }

}
