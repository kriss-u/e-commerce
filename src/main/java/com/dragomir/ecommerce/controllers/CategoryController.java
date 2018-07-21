package com.dragomir.ecommerce.controllers;

import com.dragomir.ecommerce.models.Category;
import com.dragomir.ecommerce.repositories.CategoryRepository;
import com.dragomir.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public @ResponseBody
    Iterable<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public @ResponseBody
    Category getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @PostMapping
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }
    /*
    @PutMapping("/{categoryId}")
    public void updateCategory(@PathVariable Long categoryId, @RequestBody Category category) {
        categoryService.updateCategory(categoryId, category);
    }
    */

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
