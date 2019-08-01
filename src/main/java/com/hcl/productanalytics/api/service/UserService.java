package com.hcl.productanalytics.api.service;

import java.util.List;

import com.hcl.productanalytics.api.dto.UserDto;

public interface UserService {
	
	public String userRegistration(UserDto userDto);
	
	public List<?>  userLogin(String emailId,String password);

}
