// catalog/variant/ProductVariantController.java

package com.example.grocify.catalog.variant;

import com.example.grocify.catalog.variant.dto.
        CreateVariantRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variants")

@Tag(name = "Variant APIs")
public class ProductVariantController {

    private final ProductVariantService
            productVariantService;

    public ProductVariantController(
            ProductVariantService
                    productVariantService
    ) {
        this.productVariantService =
                productVariantService;
    }

    @Operation(summary = "Create variant")
    @PostMapping
    public ProductVariant create(
            @RequestBody
            CreateVariantRequest request
    ) {

        return productVariantService.create(request);
    }

    @Operation(summary = "Get all variants")
    @GetMapping
    public List<ProductVariant> getAll() {

        return productVariantService.getAll();
    }

    @Operation(summary = "Get variant by id")
    @GetMapping("/{id}")
    public ProductVariant getById(
            @PathVariable Long id
    ) {

        return productVariantService.getById(id);
    }

    @Operation(summary = "Delete variant")
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {

        productVariantService.delete(id);
    }
}