// catalog/brand/BrandService.java

package com.example.grocify.catalog.brand;

import com.example.grocify.catalog.brand.dto.
        CreateBrandRequest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(
            BrandRepository brandRepository
    ) {
        this.brandRepository = brandRepository;
    }

    public Brand create(
            CreateBrandRequest request
    ) {

        Brand brand = new Brand();

        brand.setName(request.getName());

        return brandRepository.save(brand);
    }

    public List<Brand> getAll() {

        return brandRepository.findAll();
    }
}