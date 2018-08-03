package com.dragomir.ecommerce.controllers;

import com.dragomir.ecommerce.models.Cart;
import com.dragomir.ecommerce.services.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    @PostMapping("/addToCart")
    public void addToCart(@RequestBody ProductRequest productRequest) {
        userOrderService.addToCart(productRequest.getProductId(), productRequest.getUserId(), productRequest.getQuantity());
    }

    @PostMapping("/checkout")
    public void checkOut(@RequestBody Long userId) {
        userOrderService.checkoutItems(userId);
    }
}
