package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.OrderedProduct;
import com.dragomir.ecommerce.models.OrderedProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, OrderedProductId> {
}
