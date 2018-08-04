package com.dragomir.ecommerce.services;

import com.dragomir.ecommerce.models.Product;
import com.dragomir.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }
    /*
    public void updateProduct(Long Id, Product product) {
        updateProduct.save(product);
    }
    */
    public void deleteProduct(Long Id) {
        productRepository.deleteById(Id);
    }

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
