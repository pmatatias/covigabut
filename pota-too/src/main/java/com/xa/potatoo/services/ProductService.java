package com.xa.potatoo.services;

import java.util.List;

import com.xa.potatoo.model.dto.ProductDto;
import com.xa.potatoo.models.Product;

public interface ProductService {
	
	List<Product> findAllProduct();
	
	Product save (Product product);
	
	void delete (Long produtId);
	
	//
		List<ProductDto> queryProduct (Integer pageNo, Integer PageSize, String SortBy,String SortType);
		
		List<ProductDto> searchProductBy(Integer pageNo, Integer pageSize, String sortBy, String sortType,String name,String description);
		
		//saveDto
		Product saveProductDto(ProductDto productDto);
		
		ProductDto findProductById(Long id);
		
		int setProductIsDelete(Long id);
		

}
