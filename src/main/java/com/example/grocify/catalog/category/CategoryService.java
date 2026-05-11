// catalog/category/CategoryService.java

package com.example.grocify.catalog.category;

import com.example.grocify.catalog.category.dto.
        CreateCategoryRequest;
import com.example.grocify.catalog.category.dto.
        CategoryResponse;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(
            CategoryRepository categoryRepository
    ) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponse create(
            CreateCategoryRequest request
    ) {

        Category category = new Category();

        category.setName(request.getName());

        Category saved =
                categoryRepository.save(category);

        return new CategoryResponse(
                saved.getId(),
                saved.getName()
        );
    }

    public List<CategoryResponse> getAll() {

        return categoryRepository.findAll()
                .stream()
                .map(category ->
                        new CategoryResponse(
                                category.getId(),
                                category.getName()
                        )
                )
                .toList();
    }
}