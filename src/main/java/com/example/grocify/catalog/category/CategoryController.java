// catalog/category/CategoryController.java

package com.example.grocify.catalog.category;

import com.example.grocify.catalog.category.dto.
        CategoryResponse;
import com.example.grocify.catalog.category.dto.
        CreateCategoryRequest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(
            CategoryService categoryService
    ) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponse create(
            @RequestBody CreateCategoryRequest request
    ) {

        return categoryService.create(request);
    }

    @GetMapping
    public List<CategoryResponse> getAll() {

        return categoryService.getAll();
    }
}