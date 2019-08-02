package com.hcl.productanalytics.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productanalytics.api.customException.InvalidUserNameOrPasswordException;
import com.hcl.productanalytics.api.dto.UserDto;
import com.hcl.productanalytics.api.entity.ProductCategory;
import com.hcl.productanalytics.api.entity.User;
import com.hcl.productanalytics.api.repository.ProductCategoryRepository;
import com.hcl.productanalytics.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
	UserRepository userRepository;
    
    @Autowired
    ProductCategoryRepository productCategoryRepository;
    
	@Override
	public String userRegistration(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		
		User userObj  = userRepository.save(user);
		if(userObj!=null)
		{
		return userObj.getFirstName()+" has been registered successfully";
		}
		else
		{
			return "something is wrong";
		}
	}

	@Override
	public List<ProductCategory> userLogin(String emailId, String password) {
		
		Optional<User> optional =  userRepository.findByEmailAndPassword(emailId, password);
		if(optional.isPresent())
		{
		    return productCategoryRepository.findAll();

		}
		else
		{
			throw new InvalidUserNameOrPasswordException(emailId+ " or "+password +" is invalid !!!");
		}
	}

}
