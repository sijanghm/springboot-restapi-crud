package com.sijan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sijan.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
