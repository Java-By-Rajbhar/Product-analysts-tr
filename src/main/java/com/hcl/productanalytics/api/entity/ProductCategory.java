package com.hcl.productanalytics.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_category")
public class ProductCategory {
	
	@Id
	@GeneratedValue
	private long categoryId;
	private String categoryName;
	private int likeCount;
}
