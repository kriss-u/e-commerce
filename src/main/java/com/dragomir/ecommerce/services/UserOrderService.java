package com.dragomir.ecommerce.services;


import com.dragomir.ecommerce.models.*;
import com.dragomir.ecommerce.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserOrderService {
    @PersistenceContext
    EntityManager em;
    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderedProductRepository orderedProductRepository;

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
    @Transactional
    public void confirmOrder(Long userId) {
        User user = userRepository.findUserById(userId);

        List<Cart> carts = cartRepository.findAllByUser_Id(userId);

        UserOrder userOrder = new UserOrder(user);
        userOrder.setAmount(new BigDecimal("0"));

        carts.forEach(cart -> {
            OrderedProduct orderedProduct = new OrderedProduct();

            Product product = cart.getProduct();

            orderedProduct.setUserOrder(userOrder);

            orderedProduct.setProduct(product);
            orderedProduct.setQuantity(cart.getQuantity());

            orderedProduct.setCost(product.getCost());
            userOrder.setAmount(userOrder.getAmount().add(product.getCost().multiply(new BigDecimal(cart.getQuantity()))));

            em.persist(orderedProduct);

            userOrder.getOrderedProducts().add(orderedProduct);
        });
        userOrderRepository.save(userOrder);
        deleteAllCartItems(userId);
    }

    public void confirmSingleOrder(Cart cart) {

    }

    public List<Cart> getAllCartByUser(Long userId) {
        return cartRepository.findAllByUser_Id(userId);
    }
}
