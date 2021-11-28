package com.sijan.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sijan.model.Product;
import com.sijan.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	//getting all the products
	@GetMapping("/products")
	public List<Product> listAll(){
		return productService.listAll();
	}
	
	
	//getting a single product
	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	//adding a product 
	@PostMapping("/products")
	public void saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
	}
	
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
		 productService.updateProduct(product, id);
		 return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
