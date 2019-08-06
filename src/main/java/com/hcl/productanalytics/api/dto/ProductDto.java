package com.hcl.productanalytics.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
	
	private long categoryId;
	private String productName;
	private int likeCount;

}
