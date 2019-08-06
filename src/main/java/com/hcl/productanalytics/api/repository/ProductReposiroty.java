package com.hcl.productanalytics.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.productanalytics.api.dto.ProductDto;
import com.hcl.productanalytics.api.entity.Product;

public interface ProductReposiroty extends JpaRepository<Product, Long> { 
	
	public List<Product> findByCategoryId(long categoryId);
	
	@Query("select New com.hcl.productanalytics.api.dto.ProductDto( p.categoryId,p.productName,p.likeCount) from Product p where p.id=:productId")
    public List<ProductDto> getAnalyticsByProductId(@Param("productId") long productId);

}
