// catalog/subcategory/dto/CreateSubCategoryRequest.java

package com.example.grocify.catalog.subcategory.dto;

public class CreateSubCategoryRequest {

    private String name;

    private Long categoryId;

    public CreateSubCategoryRequest() {
    }

    public String getName() {
        return name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}