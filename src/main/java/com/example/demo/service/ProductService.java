package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.ProductEntity;

public interface ProductService {

	ProductEntity createProduct(ProductEntity productEntity);

	Page<ProductEntity> getAllProducts(Pageable pageable);

	ProductEntity getProductById(Long id);

	void deleteProduct(Long id);

	ProductEntity updateProduct(Long id, ProductEntity updatedProduct);

}
