package com.hcl.productanalytics.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.productanalytics.api.entity.Product;

public interface ProductReposiroty extends JpaRepository<Product, Long> { 
	
	public List<Product> findByCategoryId(long categoryId);

}
