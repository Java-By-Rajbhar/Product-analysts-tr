package com.hcl.productanalytics.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.productanalytics.api.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

}
