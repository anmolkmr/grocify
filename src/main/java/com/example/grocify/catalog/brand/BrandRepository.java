// catalog/brand/BrandRepository.java

package com.example.grocify.catalog.brand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository
        extends JpaRepository<Brand, Long> {
}