// catalog/variant/dto/CreateVariantRequest.java

package com.example.grocify.catalog.variant.dto;

public class CreateVariantRequest {

    private Long productId;

    private String quantity;

    private Double price;

    private Integer stock;

    private String sku;

    public CreateVariantRequest() {
    }

    public Long getProductId() {
        return productId;
    }

    public String getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getSku() {
        return sku;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}