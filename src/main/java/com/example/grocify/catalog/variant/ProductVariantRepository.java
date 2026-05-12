// catalog/variant/ProductVariantRepository.java

package com.example.grocify.catalog.variant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository
        extends JpaRepository<ProductVariant, Long> {
}