package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.Cart;
import com.dragomir.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Boolean existsCartByUser_IdAndProduct_Id(@Param("userId") Long userId, @Param("productId") Long productId);

    Cart findCartByUser_IdAndProduct_Id(@Param("userId") Long userId, @Param("productId") Long productId);

    @Transactional
    void deleteAllByUser_Id(@Param("userId") Long userId);

    @Transactional
    void deleteByUser_IdAndProduct_Id(@Param("userId") Long userId, @Param("productId") Long productId);

    List<Cart> findAllByUser_Id(@Param("userId") Long userId);
}
