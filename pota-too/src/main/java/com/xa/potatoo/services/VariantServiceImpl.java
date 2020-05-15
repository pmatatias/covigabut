package com.xa.potatoo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.potatoo.model.dto.VariantDto;
import com.xa.potatoo.models.Variant;
import com.xa.potatoo.repository.VariantRepo;

@Service
@Transactional
public class VariantServiceImpl implements VariantService {
	
	@Autowired
	private VariantRepo varRepo;

	@Override
	public List<Variant> findVariants() {
		// TODO Auto-generated method stub
		return varRepo.findAll();
	}

	@Override
	public Variant save(Variant variant) {
		// TODO Auto-generated method stub
		return varRepo.save(variant);
	}

	@Override
	public Optional<Variant> findVariantById(Long id) {
		// TODO Auto-generated method stub
		return varRepo.findById(id);
	}

	@Override
	public void deleteVariantById(Long id) {
		// TODO Auto-generated method stub
		varRepo.deleteById(id);
	}

	@Override
	public List<VariantDto> queryVariant() {
		// TODO Auto-generated method stub
		return varRepo.queryVariant();
	}

	@Override
	public List<VariantDto> queryVariantByCateId(Long id) {
		// TODO Auto-generated method stub
		return varRepo.queryVariantByCategoryId(id);
	}

	@Override
	public int setIsDelete(Long id) {
		// TODO Auto-generated method stub
		return varRepo.setIsDelete(id);
	}

	@Override
	public List<VariantDto> queryVariantByName(String name, String desc) {
		// TODO Auto-generated method stub
		return varRepo.queryVariantByName(name.toUpperCase(), desc.toLowerCase());
	}
}
