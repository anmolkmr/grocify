// catalog/brand/BrandController.java

package com.example.grocify.catalog.brand;

import com.example.grocify.catalog.brand.dto.
        CreateBrandRequest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    private final BrandService brandService;

    public BrandController(
            BrandService brandService
    ) {
        this.brandService = brandService;
    }

    @PostMapping
    public Brand create(
            @RequestBody
            CreateBrandRequest request
    ) {

        return brandService.create(request);
    }

    @GetMapping
    public List<Brand> getAll() {

        return brandService.getAll();
    }
}