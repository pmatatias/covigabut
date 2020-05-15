package com.xa.potatoo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.xa.potatoo.model.dto.VariantDto;
import com.xa.potatoo.models.Variant;

public interface VariantRepo  extends JpaRepository<Variant,Long>{
	
	@Query(value = "select new com.xa.potatoo.model.dto.VariantDto(v.id,"
			+"v.name,v.description,v.isActive,c.id,c.name)"
			+"from Variant v join Category c on v.category.id = c.id where v.isDelete=false")
	List<VariantDto> queryVariant();
	
	@Query(value = "select new com.xa.potatoo.model.dto.VariantDto(v.id,"
			+"v.name,v.description,v.isActive,c.id,c.name)"
			+"from Variant v join Category c on v.category.id = c.id and v.id=?1")
	List<VariantDto> queryVariantByCategoryId(Long cateId);
	
	@Query(value = "select new com.xa.potatoo.model.dto.VariantDto(v.id,"
			+"v.name,v.description,v.isActive,c.id,c.name)"
			+"from Variant v join Category c on v.category.id=c.id"
			+"where (v.name like %:name% or v.description like %:description%) and v.isDelete=false")
	List<VariantDto> queryVariantByName(String name, String desc);
	
	@Modifying
	@Query("update Variant v set v.isDelete=true where v.id=?1" )
	int setIsDelete(Long id);

}
