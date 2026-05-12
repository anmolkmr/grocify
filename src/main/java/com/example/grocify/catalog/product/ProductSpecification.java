package com.example.grocify.catalog.product;

import jakarta.persistence.criteria.Join;

import org.springframework.data.jpa.domain.
        Specification;

public class ProductSpecification {

    public static Specification<Product>
    hasCategory(Long categoryId) {

        return (root, query, cb) -> {

            if (categoryId == null) {
                return null;
            }

            Join<Object, Object> subCategory =
                    root.join("subCategory");

            Join<Object, Object> category =
                    subCategory.join("category");

            return cb.equal(
                    category.get("id"),
                    categoryId
            );
        };
    }

    public static Specification<Product>
    hasSubCategory(Long subCategoryId) {

        return (root, query, cb) -> {

            if (subCategoryId == null) {
                return null;
            }

            return cb.equal(
                    root.get("subCategory").get("id"),
                    subCategoryId
            );
        };
    }

    public static Specification<Product>
    hasBrand(Long brandId) {

        return (root, query, cb) -> {

            if (brandId == null) {
                return null;
            }

            return cb.equal(
                    root.get("brand").get("id"),
                    brandId
            );
        };
    }

    public static Specification<Product>
    search(String search) {

        return (root, query, cb) -> {

            if (search == null || search.isBlank()) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get("name")),
                    "%" + search.toLowerCase() + "%"
            );
        };
    }
}