// catalog/subcategory/SubCategoryService.java

package com.example.grocify.catalog.subcategory;

import com.example.grocify.catalog.category.Category;
import com.example.grocify.catalog.category.
        CategoryRepository;

import com.example.grocify.catalog.subcategory.dto.
        CreateSubCategoryRequest;

import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    private final CategoryRepository categoryRepository;

    public SubCategoryService(
            SubCategoryRepository subCategoryRepository,
            CategoryRepository categoryRepository
    ) {
        this.subCategoryRepository =
                subCategoryRepository;

        this.categoryRepository =
                categoryRepository;
    }

    public SubCategory create(
            CreateSubCategoryRequest request
    ) {

        Category category =
                categoryRepository.findById(
                        request.getCategoryId()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "Category not found"
                        ));

        SubCategory subCategory =
                new SubCategory();

        subCategory.setName(request.getName());

        subCategory.setCategory(category);

        return subCategoryRepository.save(subCategory);
    }
}