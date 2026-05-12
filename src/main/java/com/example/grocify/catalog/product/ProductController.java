// catalog/product/ProductController.java

package com.example.grocify.catalog.product;

import com.example.grocify.catalog.product.dto.
        CreateProductRequest;

import com.example.grocify.common.dto.PaginatedResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

@Tag(name = "Product APIs")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService
    ) {
        this.productService = productService;
    }

    @Operation(summary = "Create product")
    @PostMapping
    public Product create(
            @RequestBody
            CreateProductRequest request
    ) {

        return productService.create(request);
    }

    @Operation(summary = "Get all products")
    @GetMapping
    public PaginatedResponse<Product> getAll(

            @RequestParam(required = false)
            Long categoryId,

            @RequestParam(required = false)
            Long subCategoryId,

            @RequestParam(required = false)
            Long brandId,

            @RequestParam(required = false)
            String search,

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "10")
            int size
    ) {

        return productService.getAll(
                categoryId,
                subCategoryId,
                brandId,
                search,
                page,
                size
        );
    }

    @Operation(summary = "Get product by id")
    @GetMapping("/{id}")
    public Product getById(
            @PathVariable Long id
    ) {

        return productService.getById(id);
    }

    @Operation(summary = "Delete product")
    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {

        productService.delete(id);
    }
}