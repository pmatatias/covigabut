package com.xa.potatoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.xa.potatoo.models.Category;

public interface CategoryRepo  extends JpaRepository<Category, Long>{
	@Transactional
	@Modifying
	@Query("update Category c set c.isDelete=true where c.id=?1" )
	int setIsDelete(Long id);

}
