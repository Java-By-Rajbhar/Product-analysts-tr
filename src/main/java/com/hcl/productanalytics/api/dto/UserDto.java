package com.hcl.productanalytics.api.dto;

import lombok.Data;

@Data
public class UserDto {

	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String password;
	private String phoneNumber;
}
