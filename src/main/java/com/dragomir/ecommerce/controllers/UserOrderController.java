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
        userOrderService.addToCart(productRequest.getProductId(), productRequest.getUserId(), productRequest.getQuantity());
    }

    @GetMapping("/confirmOrder/{userId}")
    public void confirmOrder(@PathVariable("userId") Long userId) {
        userOrderService.confirmOrder(userId);
    }

    @GetMapping("/getAllCartByUser/{userId}")
    @ResponseBody public List<Cart> getAllCartByUser(@PathVariable("userId") Long userId) {
        return userOrderService.getAllCartByUser(userId);
    }
}
