// catalog/category/CategoryRepository.java

package com.example.grocify.catalog.category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {
}