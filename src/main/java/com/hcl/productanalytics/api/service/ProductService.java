package com.hcl.productanalytics.api.service;

import java.util.List;

import com.hcl.productanalytics.api.dto.ProductDto;
import com.hcl.productanalytics.api.entity.Product;

public interface ProductService {
	
public Product getproductById(long productId);

public List<ProductDto> getAnalyticsByProductId(long productId);

}
