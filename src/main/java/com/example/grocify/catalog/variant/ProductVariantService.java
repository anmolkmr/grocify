// catalog/variant/ProductVariantService.java

package com.example.grocify.catalog.variant;

import com.example.grocify.catalog.product.Product;
import com.example.grocify.catalog.product.
        ProductRepository;

import com.example.grocify.catalog.variant.dto.
        CreateVariantRequest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVariantService {

    private final ProductVariantRepository
            productVariantRepository;

    private final ProductRepository productRepository;

    public ProductVariantService(
            ProductVariantRepository
                    productVariantRepository,

            ProductRepository productRepository
    ) {
        this.productVariantRepository =
                productVariantRepository;

        this.productRepository =
                productRepository;
    }

    public ProductVariant create(
            CreateVariantRequest request
    ) {

        Product product =
                productRepository.findById(
                        request.getProductId()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "Product not found"
                        ));

        ProductVariant variant =
                new ProductVariant();

        variant.setProduct(product);

        variant.setQuantity(
                request.getQuantity()
        );

        variant.setPrice(
                request.getPrice()
        );

        variant.setStock(
                request.getStock()
        );

        variant.setSku(
                request.getSku()
        );

        return productVariantRepository.save(
                variant
        );
    }

    public List<ProductVariant> getAll() {

        return productVariantRepository.findAll();
    }

    public ProductVariant getById(Long id) {

        return productVariantRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Variant not found"
                        ));
    }

    public void delete(Long id) {

        productVariantRepository.deleteById(id);
    }
}