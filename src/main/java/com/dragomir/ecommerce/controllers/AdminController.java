package com.dragomir.ecommerce.controllers;

import com.dragomir.ecommerce.models.OrderedProduct;
import com.dragomir.ecommerce.payloads.CountHolder;
import com.dragomir.ecommerce.repositories.OrderedProductRepository;
import com.dragomir.ecommerce.repositories.ProductRepository;
import com.dragomir.ecommerce.repositories.UserOrderRepository;
import com.dragomir.ecommerce.repositories.UserRepository;
import com.dragomir.ecommerce.services.AdminService;
import com.dragomir.ecommerce.services.ProductService;
import com.dragomir.ecommerce.services.UserOrderService;
import com.dragomir.ecommerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderedProductRepository orderedProductRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserOrderRepository userOrderRepository;

    @PostMapping("/addCategory")
    public void addCategoryAdmin(@RequestBody CategorySubCategory categorySubCategory) {
        adminService.addCategoryAdmin(categorySubCategory);
    }

    @PostMapping("/addProduct")
    public void addProductAdmin(@RequestBody ProductAdmin productAdmin) {
        adminService.addProductAdmin(productAdmin);
    }

    @GetMapping("/counts")
    public CountHolder getCounts(){
        int orderedProductSize = orderedProductRepository.findAll().size();
        int productSize = productRepository.findAll().size();
        int userSize = userRepository.findAll().size();
        int userOrderSize = userOrderRepository.findAll().size();
        return new CountHolder(orderedProductSize, productSize, userSize, userOrderSize);
    }
}
