package com.hcl.productanalytics.api.customException;

public class InvalidUserNameOrPasswordException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidUserNameOrPasswordException(String message)
	{
		super(message);
	}

}
