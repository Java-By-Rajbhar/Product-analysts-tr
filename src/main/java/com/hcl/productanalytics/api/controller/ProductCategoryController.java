package com.hcl.productanalytics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.productanalytics.api.entity.Product;
import com.hcl.productanalytics.api.entity.ProductCategory;
import com.hcl.productanalytics.api.service.ProductCategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class ProductCategoryController { 
	
	@Autowired
	ProductCategoryServiceImpl productCategoryServiceImpl;
	@GetMapping("/{categoryId}")
	public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable long categoryId)
	{
		List<Product> list_product = productCategoryServiceImpl.getproductByCategoryId(categoryId);
		
		return new ResponseEntity<List<Product>>(list_product, HttpStatus.OK);
	}
	
	@PutMapping("/{userId}/{categoryId}")
	public ResponseEntity<String> updateCategory(@PathVariable long categoryId,@PathVariable long userId,@RequestBody ProductCategory productCategory)
	{
		String update_message = productCategoryServiceImpl.updateCategory(categoryId, userId, productCategory);
		return new ResponseEntity<String>(update_message, HttpStatus.OK);
	}

}
