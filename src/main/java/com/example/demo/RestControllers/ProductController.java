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

import com.example.demo.entity.ProductEntity;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	 @Autowired
	    private ProductService productService;
	   
	@PostMapping
	public ProductEntity createProduct(@RequestBody ProductEntity productEntity) {
        return productService.createProduct(productEntity);
    }
	
	  @GetMapping
	    public Page<ProductEntity> getAllProducts(@RequestParam(defaultValue = "0") int page) {
	        return productService.getAllProducts(PageRequest.of(page, 10));
	    }

	    @GetMapping("/{id}")
	    public ProductEntity getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }

	  

	    @PutMapping("/{id}")
	    public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity updatedProduct) {
//	       System.out.println(id);
//	       System.out.println(updatedProduct);
	    	return productService.updateProduct(id, updatedProduct);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	    }
}
