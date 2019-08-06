package com.hcl.productanalytics.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCategoryDto {

	private String categoryName;
	private int likeCount;
}
