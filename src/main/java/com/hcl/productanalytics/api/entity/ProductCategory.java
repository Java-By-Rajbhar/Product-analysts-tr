package com.hcl.productanalytics.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="product_category")
public class ProductCategory  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long categoryId;
	private String categoryName;
	private int likeCount;
}
