package com.dragomir.ecommerce.services;

import com.dragomir.ecommerce.models.Brand;
import com.dragomir.ecommerce.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public void addBrand(Brand brand) {
        brandRepository.save(brand);
    }
    /*
    public void updateBrand(Long Id, Brand brand) {
        brandRepository.save(brand)
    } */
    public void deleteBrand(Long brandId) {
        brandRepository.deleteById(brandId);
    }

    public Brand getBrand(Long brandId) {
        return brandRepository.findById(brandId).orElse(null);
    }

    public Iterable<Brand> getAllBrands() {
        return brandRepository.findAll();
    }
}
