package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.CategoryEntity;

public interface CategoryService {

	CategoryEntity createCategory(CategoryEntity categoryEntity);

	CategoryEntity getCategoryById(Long id);


	CategoryEntity updateCategory(Long id, CategoryEntity updatedCategory);

	void deleteCategory(Long id);

	Page<CategoryEntity> getAllCategories(Pageable pageable);

}
