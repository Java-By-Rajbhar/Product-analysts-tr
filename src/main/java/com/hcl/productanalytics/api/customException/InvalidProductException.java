package com.hcl.productanalytics.api.customException;

public class InvalidProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidProductException(String message)
	{
		super(message);
	}

}
