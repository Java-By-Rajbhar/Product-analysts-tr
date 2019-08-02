package com.hcl.productanalytics.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.productanalytics.api.entity.Product;
import com.hcl.productanalytics.api.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable long productId)
	{
		Product product = productServiceImpl.getproductById(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

}
