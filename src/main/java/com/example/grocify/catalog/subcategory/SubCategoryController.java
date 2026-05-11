// catalog/subcategory/SubCategoryController.java

package com.example.grocify.catalog.subcategory;

import com.example.grocify.catalog.subcategory.dto.
        CreateSubCategoryRequest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    public SubCategoryController(
            SubCategoryService subCategoryService
    ) {
        this.subCategoryService =
                subCategoryService;
    }

    @PostMapping
    public SubCategory create(
            @RequestBody
            CreateSubCategoryRequest request
    ) {

        return subCategoryService.create(request);
    }
}