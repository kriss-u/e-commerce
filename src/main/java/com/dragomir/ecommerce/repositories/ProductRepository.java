package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> getProductBySubCategoryId(@Param("id") Long id);

    Product findProductById(@Param("id") Long productId);
}
