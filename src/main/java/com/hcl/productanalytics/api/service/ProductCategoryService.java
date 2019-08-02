package com.hcl.productanalytics.api.service;

import java.util.List;

import com.hcl.productanalytics.api.entity.Product;
import com.hcl.productanalytics.api.entity.ProductCategory;

public interface ProductCategoryService {
	
	public List<Product> getproductByCategoryId(long categoryId);
	
	public String updateCategory(long categoryId,long userId,ProductCategory productCategory);

	
}
