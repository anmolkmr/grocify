// catalog/category/dto/CreateCategoryRequest.java

package com.example.grocify.catalog.category.dto;

public class CreateCategoryRequest {

    private String name;

    public CreateCategoryRequest() {
    }

    public CreateCategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}