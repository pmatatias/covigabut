package com.xa.potatoo.services;

import java.util.List;
import java.util.Optional;

import com.xa.potatoo.models.Category;

public interface CategoryService {
	List<Category> findCategories();
	
	Category save(Category category);
	
	Optional<Category> findCategoryById(Long id);
	
	void deleteCategoryById(Long id);
	
	int setIsDelete(Long id);

}
