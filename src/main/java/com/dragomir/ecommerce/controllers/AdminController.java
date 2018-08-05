package com.dragomir.ecommerce.controllers;

import com.dragomir.ecommerce.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/addCategory")
    public void addCategoryAdmin(@RequestBody CategorySubCategory categorySubCategory) {
        adminService.addCategoryAdmin(categorySubCategory);
    }

    @PostMapping("/addProduct")
    public void addProductAdmin(@RequestBody ProductAdmin productAdmin) {
        adminService.addProductAdmin(productAdmin);
    }
}
