package com.dragomir.ecommerce.services;

import com.dragomir.ecommerce.controllers.CategorySubCategory;
import com.dragomir.ecommerce.models.Category;
import com.dragomir.ecommerce.models.SubCategory;
import com.dragomir.ecommerce.repositories.CategoryRepository;
import org.apache.lucene.index.DocIDMerger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    /*
    public void updateCategory(Long Id, Category category) {
        categoryRepository.save(category);
    }
    */
    public void deleteCategory(Long Id) {
        categoryRepository.deleteById(Id);
    }

    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
