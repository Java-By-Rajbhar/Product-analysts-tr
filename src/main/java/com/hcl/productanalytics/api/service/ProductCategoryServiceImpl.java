package com.hcl.productanalytics.api.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productanalytics.api.customException.InvalidCategoryException;
import com.hcl.productanalytics.api.customException.InvalidUserException;
import com.hcl.productanalytics.api.dto.ProductCategoryDto;
import com.hcl.productanalytics.api.entity.Product;
import com.hcl.productanalytics.api.entity.ProductCategory;
import com.hcl.productanalytics.api.entity.User;
import com.hcl.productanalytics.api.repository.ProductCategoryRepository;
import com.hcl.productanalytics.api.repository.ProductReposiroty;
import com.hcl.productanalytics.api.repository.UserRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

	
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	@Autowired
	ProductReposiroty productReposiroty;
	@Autowired
	UserRepository userRepository;

	private static final Logger logger = LogManager.getLogger(ProductCategoryServiceImpl.class);
	
	public List<Product> getproductByCategoryId(long categoryId)
	{
		logger.info("from getproductByCategoryId () of ProductCategoryServiceImpl class ");
		Optional<ProductCategory> category = productCategoryRepository.findById(categoryId);
		if(category.isPresent())
		{
			logger.info("getproductByCategoryId () if method={}",category);
			ProductCategory category2 = category.get();
			category2.setLikeCount(category2.getLikeCount()+1);
			productCategoryRepository.save(category2);
			logger.info("save data is ={}",category2.getCategoryId());
			return productReposiroty.findByCategoryId(categoryId);
		}
		else
		{
			logger.error("Exception has rised ={}",categoryId);
			throw new InvalidCategoryException("Category id "+categoryId+" does not exist");
		}
		
		
	}

	@Override
	public String updateCategory(long categoryId, long userId, ProductCategory productCategory) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent())
		{
			ProductCategory productCat =productCategoryRepository.findByCategoryId(categoryId);
			productCat.setCategoryName(productCategory.getCategoryName());
			productCategoryRepository.save(productCat);
			return "category has updated successfully with id "+categoryId;
			
		}
		else
		{
			throw new InvalidUserException("User with id "+userId+" does not exist");
		}
	}

	@Override
	public List<ProductCategoryDto> getAnalyticsByCategoryId(long categoryId) {
		
		return productCategoryRepository.getAnalyticsByCategoryId(categoryId);
	}



}
