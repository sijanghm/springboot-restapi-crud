package com.sijan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sijan.model.Product;
import com.sijan.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	
	public List<Product> listAll(){
		return productRepo.findAll();
	}
	
	public void saveProduct(Product product) {
		productRepo.save(product);
	}
	
	public Product getProduct(Long id) {
		return productRepo.findById(id).get();
	}
	
	public 	Product updateProduct(Product product, Long id) {
		
		Product existingproduct = productRepo.findById(id).orElse(product);
		existingproduct.setName(product.getName());
		existingproduct.setPrice(product.getPrice());
		productRepo.save(existingproduct);
		return existingproduct;
	}
	
	public void deleteProduct(Long id) {
	  productRepo.deleteById(id);
	}
	
	

}
