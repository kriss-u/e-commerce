package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.Cart;
import com.dragomir.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> getProductBySubCategoryId(@Param("id") Long id);

    Product findProductById(@Param("id") Long productId);

    List<Product> findAllByCarts(List<Cart> carts);
}



