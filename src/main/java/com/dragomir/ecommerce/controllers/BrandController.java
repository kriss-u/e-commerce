package com.dragomir.ecommerce.controllers;

import com.dragomir.ecommerce.models.Brand;
import com.dragomir.ecommerce.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public @ResponseBody
    Iterable<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{brandId}")
    public @ResponseBody
    Brand getCategory(@PathVariable Long brandId) {
        return brandService.getBrand(brandId);
    }

    @PostMapping
    public void addBrand(@RequestBody Brand brand) {
        brandService.addBrand(brand);
    }

    @DeleteMapping("/{brandId}")
    public void deleteCategory(@PathVariable Long brandId) {
        brandService.deleteBrand(brandId);
    }
}
