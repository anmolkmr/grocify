// catalog/variant/ProductVariant.java

package com.example.grocify.catalog.variant;

import com.example.grocify.catalog.product.Product;

import jakarta.persistence.*;

@Entity
@Table(name = "product_variants")
public class ProductVariant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quantity;

    private Double price;

    private Integer stock;

    private String sku;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductVariant() {
    }

    public Long getId() {
        return id;
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

    public Product getProduct() {
        return product;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setProduct(Product product) {
        this.product = product;
    }
}