package com.example.springtest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springtest.ProductRepository;
import com.example.springtest.exception.ResourceNotFoundException;
import com.example.springtest.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	// get all
	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	// @Valid validates fields with Product model
	@PostMapping("/add")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepository.save(product);
	}
	
	// @PathVariable binds path variable {id} with method parameter id
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable(value="id") Long id) { 
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
	}
	
	// Update a product
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable(value="id") Long id, @Valid @RequestBody Product productDetails) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		
		product.setName(productDetails.getName());
		product.setCategory(productDetails.getCategory());
		
		return productRepository.save(product);
	}
	
	// Delete a product
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value="id") Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		
		productRepository.delete(product);
		return ResponseEntity.ok().build();
	}
}
