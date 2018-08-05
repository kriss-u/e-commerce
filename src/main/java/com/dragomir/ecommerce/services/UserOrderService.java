package com.dragomir.ecommerce.services;


import com.dragomir.ecommerce.controllers.ProductRequest;
import com.dragomir.ecommerce.models.*;
import com.dragomir.ecommerce.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public void addToCart(Long productId, String username, Integer quantity) {
        Cart cart = cartRepository.findCartByUser_UsernameAndProduct_Id(username, productId);
        Product product = productRepository.findProductById(productId);
        User user = userRepository.findByUsername(username);
        if (product == null || user == null)
            return;
        if (cart == null)
            cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(quantity);
        cartRepository.save(cart);
    }

    public void addToCartInBatch() {

    }

    public List<ProductRequest> getAllCartItemsByUser(String username) {
        List<ProductRequest> cartItems = new ArrayList<>();
        cartRepository.findAllByUser_Username(username).forEach(cart -> {
            ProductRequest productRequest = new ProductRequest();
            productRequest.setProductId(cart.getProduct().getId());
            productRequest.setUsername(username);
            productRequest.setQuantity(cart.getQuantity());
            cartItems.add(productRequest);
        });
        return cartItems;
    }

    public void deleteAllCartItems(String username) {
        cartRepository.deleteAllByUser_Username(username);
    }

    public void deleteCartItem(String username, Long productId) {
        cartRepository.deleteByUser_UsernameAndProduct_Id(username, productId);
    }

    @Transactional
    public void confirmOrder(String username) {
        User user = userRepository.findByUsername(username);

        if (user == null) return;

        List<Cart> carts = cartRepository.findAllByUser_Username(username);

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

            product.decreaseInventory();
            productRepository.save(product);

        });

        userOrderRepository.save(userOrder);
        deleteAllCartItems(username);
    }

    public void confirmSingleOrder(Cart cart) {

    }
    public List<Product> getAllCartProducts(String username) {
        List<Cart> carts = cartRepository.findAllByUser_Username(username);
        List<Product> products = new ArrayList<>();
        carts.forEach(cart -> {
            Product product = cart.getProduct();
            products.add(product);
        });
        return products;
    }
    public List<Cart> getAllCartByUser(String username) {
        return cartRepository.findAllByUser_Username(username);
    }
}
