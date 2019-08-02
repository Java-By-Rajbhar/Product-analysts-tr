package com.hcl.productanalytics.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productanalytics.api.customException.InvalidCategoryException;
import com.hcl.productanalytics.api.customException.InvalidUserException;
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
	
	public List<Product> getproductByCategoryId(long categoryId)
	{
		Optional<ProductCategory> category = productCategoryRepository.findById(categoryId);
		if(category.isPresent())
		{
			ProductCategory category2 = category.get();
			category2.setLikeCount(category2.getLikeCount()+1);
			productCategoryRepository.save(category2);
			return productReposiroty.findByCategoryId(categoryId);
		}
		else
		{
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



}
