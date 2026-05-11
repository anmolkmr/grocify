// catalog/subcategory/SubCategoryRepository.java

package com.example.grocify.catalog.subcategory;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository
        extends JpaRepository<SubCategory, Long> {
}