package com.dragomir.ecommerce.controllers;

import com.dragomir.ecommerce.models.Cart;
import com.dragomir.ecommerce.models.User;
import com.dragomir.ecommerce.services.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    @PostMapping("/addToCart")
    public void addToCart(@RequestBody ProductRequest productRequest) {
        userOrderService.addToCart(productRequest.getProductId(), productRequest.getUsername(), productRequest.getQuantity());
    }

    @GetMapping("/cartItem/{username}")
    @ResponseBody public List<ProductRequest> getAllCartItemsByUser(@PathVariable("username") String username) {
        return userOrderService.getAllCartItemsByUser(username);
    }

    @GetMapping("/confirmOrder/{username}")
    public void confirmOrder(@PathVariable("username") String username) {
        userOrderService.confirmOrder(username);
    }

    @GetMapping("/getAllCartByUser/{username}")
    @ResponseBody public List<Cart> getAllCartByUser(@PathVariable("username") String username) {
        return userOrderService.getAllCartByUser(username);
    }
}
