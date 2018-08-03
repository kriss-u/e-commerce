package com.dragomir.ecommerce.services;


import com.dragomir.ecommerce.models.*;
import com.dragomir.ecommerce.repositories.CartRepository;
import com.dragomir.ecommerce.repositories.ProductRepository;
import com.dragomir.ecommerce.repositories.UserOrderRepository;
import com.dragomir.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderService {
    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public void addToCart(Long productId, Long userId, Integer quantity) {
        Cart cart = cartRepository.findCartByUser_IdAndProduct_Id(userId, productId);
        Product product = productRepository.findProductById(productId);
        User user = userRepository.findUserById(userId);
        if (product == null || user == null)
            return;
        if (cart == null)
            cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(quantity);
        cartRepository.save(cart);
    }

    public void deleteAllCartItems(Long userId) {
        cartRepository.deleteAllByUser_Id(userId);
    }

    public void deleteCartItem(Long userId, Long productId) {
        cartRepository.deleteByUser_IdAndProduct_Id(userId, productId);
    }

    public void checkoutItems(Long userId) {
        UserOrder userOrder = new UserOrder();
        List<Cart> carts = cartRepository.findAllByUser_Id(userId);
        if (carts == null)
            return;
        carts.forEach(cart -> {
            Product product = cart.getProduct();
            OrderedProduct orderedProduct = new OrderedProduct();
            orderedProduct.setUserOrder(userOrder);
            orderedProduct.setProduct(product);
            orderedProduct.setCost(product.getCost());
            orderedProduct.setQuantity(cart.getQuantity());
            userOrder.addOrderedProducts(orderedProduct);
        });
        deleteAllCartItems(userId);
    }
}
