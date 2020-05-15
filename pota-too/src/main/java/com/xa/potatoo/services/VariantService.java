package com.xa.potatoo.services;

import java.util.List;
import java.util.Optional;

import com.xa.potatoo.model.dto.VariantDto;
import com.xa.potatoo.models.Variant;

public interface VariantService {
	
	List<Variant> findVariants();
	
	Variant save(Variant variant);
	
	Optional<Variant> findVariantById(Long id);
	
	void deleteVariantById(Long id);
	
	//Dto
	
	List<VariantDto> queryVariant();
	
	List<VariantDto> queryVariantByCateId(Long id);
	
	int setIsDelete(Long id);
	
	List<VariantDto> queryVariantByName(String name, String desc);
}
