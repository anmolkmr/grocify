// catalog/product/dto/CreateProductRequest.java

package com.example.grocify.catalog.product.dto;

public class CreateProductRequest {

    private String name;

    private String description;

    private String imageUrl;

    private Long brandId;

    private Long subCategoryId;

    public CreateProductRequest() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }
}