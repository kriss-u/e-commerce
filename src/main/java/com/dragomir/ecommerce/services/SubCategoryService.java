package com.dragomir.ecommerce.services;

import com.dragomir.ecommerce.models.SubCategory;
import com.dragomir.ecommerce.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public void addSubCategory(SubCategory subCategory) {
        subCategoryRepository.save(subCategory);
    }

    public SubCategory getSubCategory(Long subCategoryId) {
        return subCategoryRepository.findById(subCategoryId).orElse(null);
    }
    public Iterable<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }
}
