package com.hcl.productanalytics.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.productanalytics.api.dto.UserDto;
import com.hcl.productanalytics.api.entity.ProductCategory;
import com.hcl.productanalytics.api.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/registration")
	public ResponseEntity<String> userRegistration(@RequestBody UserDto userDto)
	{
		String message  = userServiceImpl.userRegistration(userDto);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("/login/allCategories")
	public ResponseEntity<List<ProductCategory>> userLogin(@RequestHeader("emailId") String emailId,@RequestHeader("password") String password)
	{
		List<ProductCategory> list_category = userServiceImpl.userLogin(emailId, password);
		return new ResponseEntity<List<ProductCategory>>(list_category, HttpStatus.OK);
	}

}
