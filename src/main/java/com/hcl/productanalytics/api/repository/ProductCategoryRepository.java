package com.hcl.productanalytics.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.productanalytics.api.dto.ProductCategoryDto;
import com.hcl.productanalytics.api.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
	
	public ProductCategory findByCategoryId(long categoryId);
	
	@Query("select New com.hcl.productanalytics.api.dto.ProductCategoryDto( pc.categoryName,pc.likeCount )from ProductCategory pc where pc.categoryId=:categoryId")
    public List<ProductCategoryDto> getAnalyticsByCategoryId(@Param("categoryId") long categoryId);

}
