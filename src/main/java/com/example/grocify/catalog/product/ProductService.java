// catalog/product/ProductService.java

package com.example.grocify.catalog.product;

import com.example.grocify.catalog.brand.Brand;
import com.example.grocify.catalog.brand.BrandRepository;

import com.example.grocify.catalog.product.dto.
        CreateProductRequest;

import com.example.grocify.catalog.subcategory.SubCategory;
import com.example.grocify.catalog.subcategory.
        SubCategoryRepository;

import com.example.grocify.common.dto.PaginatedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final BrandRepository brandRepository;

    private final SubCategoryRepository subCategoryRepository;

    public ProductService(
            ProductRepository productRepository,
            BrandRepository brandRepository,
            SubCategoryRepository subCategoryRepository
    ) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.subCategoryRepository = subCategoryRepository;
    }

    public Product create(
            CreateProductRequest request
    ) {

        Brand brand = brandRepository.findById(
                request.getBrandId()
        ).orElseThrow(() ->
                new RuntimeException("Brand not found"));

        SubCategory subCategory =
                subCategoryRepository.findById(
                        request.getSubCategoryId()
                ).orElseThrow(() ->
                        new RuntimeException(
                                "SubCategory not found"
                        ));

        Product product = new Product();

        product.setName(request.getName());

        product.setDescription(
                request.getDescription()
        );

        product.setImageUrl(
                request.getImageUrl()
        );

        product.setBrand(brand);

        product.setSubCategory(subCategory);

        return productRepository.save(product);
    }

    public PaginatedResponse<Product> getAll(
            Long categoryId,
            Long subCategoryId,
            Long brandId,
            String search,
            int page,
            int size
    ) {

        Pageable pageable =
                PageRequest.of(page, size);

        Specification<Product> specification =
                Specification.where(
                                ProductSpecification
                                        .hasCategory(categoryId)
                        )

                        .and(
                                ProductSpecification
                                        .hasSubCategory(subCategoryId)
                        )

                        .and(
                                ProductSpecification
                                        .hasBrand(brandId)
                        )

                        .and(
                                ProductSpecification
                                        .search(search)
                        );

        Page<Product> productPage =
                productRepository.findAll(
                        specification,
                        pageable
                );

        return new PaginatedResponse<>(
                productPage.getContent(),
                productPage.getTotalElements(),
                productPage.getTotalPages()
        );
    }

    public Product getById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Product not found"
                        ));
    }

    public void delete(Long id) {

        productRepository.deleteById(id);
    }
}