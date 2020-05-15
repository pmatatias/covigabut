package com.xa.potatoo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.potatoo.models.Category;
import com.xa.potatoo.repository.CategoryRepo;

@Service

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryRepo cateRepo;

	@Override
	public List<Category> findCategories() {
		// TODO Auto-generated method stub
		return cateRepo.findAll();
	}

	@Override
	public Category save(Category category) {
		// TODO Auto-generated method stub
		return cateRepo.save(category);
	}

	@Override
	public Optional<Category> findCategoryById(Long id) {
		// TODO Auto-generated method stub
		return cateRepo.findById(id);
	}

	@Override
	public void deleteCategoryById(Long id) {
		// TODO Auto-generated method stub
		cateRepo.deleteById(id);
		
	}

	@Override
	public int setIsDelete(Long id) {
		// TODO Auto-generated method stub
		return cateRepo.setIsDelete(id);
	}

}
