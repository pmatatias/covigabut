package com.xa.potatoo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.xa.potatoo.model.dto.ProductDto;
import com.xa.potatoo.models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
	@Query("select new com.xa.potatoo.model.dto.ProductDto("
			+ "p.productId,p.name,p.description,p.price,p.stock,p.active, "
			+ "	p.variant.id,v.name,c.id,c.name) "
			+ "	from Product p "
			+ "	join Variant v on v.id = p.variant.id "
			+ "	join Category c on c.id = v.category.id "
			+ "	where p.isDelete=false")
	Page<ProductDto> fetchProductVariant(Pageable pageable);
	
	@Query("select new com.xa.potatoo.model.dto.ProductDto("
			+ "p.productId,p.name,p.description, "
			+ "	p.price,p.stock,p.active,p.variant.id,v.name,c.id,c.name) "
			+ "	from Product p "
			+ "	join Variant v on v.id= p.variant.id "
			+ "	join Category c on c.id = v.category.id "
			+ "	where (p.name like %:name% or p.description like %:description%)")
	Page<ProductDto> searchProductBy(Pageable pageable,String name,String description);
	
	@Query("select new com.xa.potatoo.model.dto.ProductDto("
			+ "p.productId,p.name,p.description,p.price,p.stock,"
			+ "	p.active,p.variant.id,v.name,c.id,c.name) "
			+ "	from Product p "
			+ "	join Variant v on v.id = p.variant.id "
			+ "	join Category c on c.id = v.category.id "
			+ "	where p.productId=?1")
	ProductDto findProductById(Long id);
	
	@Modifying
	@Query("update Product p set p.isDelete=true where p.productId=?1")
	int setProductIsDelete(Long id);
	
	

}
