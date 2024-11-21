package com.example.demo.RestControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	   @Autowired
	    private CategoryService categoryService;
	   
	@PostMapping
	public CategoryEntity createCategory(@RequestBody CategoryEntity CategoryEntity) {
        return categoryService.createCategory(CategoryEntity);
    }
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
	}
	
	@GetMapping("/{id}")
	public CategoryEntity getCategoryById(@PathVariable Long id) {
		return categoryService.getCategoryById(id);
	}
	
	 @GetMapping
	    public Page<CategoryEntity> getAllCategories(@RequestParam(defaultValue = "0") int page) {
	        return categoryService.getAllCategories(PageRequest.of(page, 10));
	    }


	    

	    @PutMapping("/{id}")
	    public CategoryEntity updateCategory(@PathVariable Long id, @RequestBody CategoryEntity updatedCategory) {
	        return categoryService.updateCategory(id, updatedCategory);
	    }

}
