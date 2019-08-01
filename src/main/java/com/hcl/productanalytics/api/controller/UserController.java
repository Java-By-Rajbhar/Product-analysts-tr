package com.hcl.productanalytics.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.productanalytics.api.dto.UserDto;
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

}
