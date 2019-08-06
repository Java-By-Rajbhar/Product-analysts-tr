package com.hcl.productanalytics.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productanalytics.api.customException.InvalidProductException;
import com.hcl.productanalytics.api.dto.ProductDto;
import com.hcl.productanalytics.api.entity.Product;
import com.hcl.productanalytics.api.repository.ProductReposiroty;

@Service 
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductReposiroty productReposiroty;
	@Override
	public Product getproductById(long productId) {
		
		Optional<Product> product = productReposiroty.findById(productId);
		if(product.isPresent())
		{
			Product product2 = product.get();
			product2.setLikeCount(product2.getLikeCount()+1);
			productReposiroty.save(product2);
			return product2;
		}
		else
		{
			throw new InvalidProductException("Product id "+productId+" does not exist");
		}
	}
	@Override
	public List<ProductDto> getAnalyticsByProductId(long productId) {
		
		return productReposiroty.getAnalyticsByProductId(productId);
	}


}
