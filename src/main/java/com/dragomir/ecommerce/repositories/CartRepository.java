package com.dragomir.ecommerce.repositories;

import com.dragomir.ecommerce.models.Cart;
import com.dragomir.ecommerce.models.Product;
import com.dragomir.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Boolean existsCartByUser_IdAndProduct_Id(@Param("userId") Long userId, @Param("productId") Long productId);

    Cart findCartByUser_IdAndProduct_Id(@Param("userId") Long userId, @Param("productId") Long productId);

    Cart findCartByUser_UsernameAndProduct_Id(@Param("username") String username, @Param("productId") Long productId);

    @Transactional
    void deleteAllByUser_Id(@Param("userId") Long userId);

    @Transactional
    void deleteAllByUser_Username(@Param("username") String username);

    @Transactional
    void deleteByUser_UsernameAndProduct_Id(@Param("username") String username, @Param("productId") Long productId);

    @Transactional
    void deleteByUser_IdAndProduct_Id(@Param("userId") Long userId, @Param("productId") Long productId);

    List<Cart> findAllByUser_Id(@Param("userId") Long userId);

    List<Cart> findAllByUser_Username(@Param("username") String username);

    List<Cart> findAllByUser(@Param("user") User user);
}
