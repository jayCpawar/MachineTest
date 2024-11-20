package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.reppository.CategoryRepository;
import com.example.demo.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

	@Autowired
	public CategoryRepository categoryRepository;
	
	 @Override
	public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }
	 @Override
    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public Page<CategoryEntity> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
    
    
    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity updatedCategory) {
    	CategoryEntity existingCategory = getCategoryById(id);
        existingCategory.setName(updatedCategory.getName());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

	
	
}
