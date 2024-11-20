package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.reppository.ProductRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@Service
public class ProductImpl implements ProductService {

	  @Autowired
	    private ProductRepository productRepository;

	  @Autowired
	    private CategoryService categoryService;
	    
	 @Override
	  public Page<ProductEntity> getAllProducts(Pageable pageable) {
	        return productRepository.findAll(pageable);
	    }

	 @Override
	    public ProductEntity getProductById(Long id) {
	        return productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found"));
	    }

	 @Override
	    public ProductEntity createProduct(ProductEntity product) {
	        CategoryEntity category = categoryService.getCategoryById(product.getCategoryEntity().getId());
	        product.setCategoryEntity(category);
	        return productRepository.save(product);
	    }

	 @Override
	    public ProductEntity updateProduct(Long id, ProductEntity updatedProduct) {
	    	ProductEntity existingProduct = getProductById(id);
	        existingProduct.setName(updatedProduct.getName());
	        existingProduct.setPrice(updatedProduct.getPrice());
	        
	   
	        System.out.println(categoryService.getCategoryById(updatedProduct.getCategoryEntity().getId()) );
	        existingProduct.setCategoryEntity(categoryService.getCategoryById(updatedProduct.getCategoryEntity().getId()));
	       
	        return productRepository.save(existingProduct);
	    }

	 @Override
	    public void deleteProduct(Long id) {
	        productRepository.deleteById(id);
	    }
}
