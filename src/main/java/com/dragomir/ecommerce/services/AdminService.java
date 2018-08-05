package com.dragomir.ecommerce.services;

import com.dragomir.ecommerce.controllers.CategorySubCategory;
import com.dragomir.ecommerce.controllers.ProductAdmin;
import com.dragomir.ecommerce.models.Brand;
import com.dragomir.ecommerce.models.Category;
import com.dragomir.ecommerce.models.Product;
import com.dragomir.ecommerce.models.SubCategory;
import com.dragomir.ecommerce.repositories.BrandRepository;
import com.dragomir.ecommerce.repositories.ProductRepository;
import com.dragomir.ecommerce.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class AdminService {
    @PersistenceContext
    EntityManager em;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Transactional
    public void addCategoryAdmin(CategorySubCategory categorySubCategory) {
        Category category = new Category();
        category.setName(categorySubCategory.getCategoryName());
        category.setIconName(categorySubCategory.getCategoryIcon());
        em.persist(category);
        categorySubCategory.getNames().forEach(name -> {
            SubCategory subCategory = new SubCategory();
            subCategory.setName(name.getName());
            subCategory.setCategory(category);
            em.persist(subCategory);
        });
    }

    public void addProductAdmin(ProductAdmin productAdmin) {
        Brand brand = brandRepository.findById(productAdmin.getBrandId()).orElse(null);
        SubCategory subCategory = subCategoryRepository.findById(productAdmin.getSubCategoryId()).orElse(null);
        if (brand == null || subCategory == null)
            return;
        Product product = new Product();
        product.setName(productAdmin.getName());
        product.setModel(productAdmin.getModel());
        product.setCost(productAdmin.getCost());
        product.setBrand(brand);
        product.setSubCategory(subCategory);
        product.setInventory(productAdmin.getInventory());
        product.setSpecifications(productAdmin.getSpecifications());
        product.setDescription(productAdmin.getDescription());
        productRepository.save(product);
    }
}
