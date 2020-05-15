package com.xa.potatoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.potatoo.models.Category;
import com.xa.potatoo.services.CategoryService;

@RestController
@RequestMapping(path = "/api/category",produces = "application/json")
@CrossOrigin(origins = "*")
public class CategoryRestController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public ResponseEntity<?> findAllCategory(){
		return new ResponseEntity<>(categoryService.findCategories(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> saveCategory(@RequestBody Category category ){
		return new ResponseEntity<>(categoryService.save(category),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> putCategory(@RequestBody Category category ){
		return new ResponseEntity<>(categoryService.save(category),HttpStatus.OK);
	}
	
	@PatchMapping("/patch")
	public ResponseEntity<?> patchCategory(@RequestBody Category category ){
		return new ResponseEntity<>(categoryService.save(category),HttpStatus.OK);
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity<?> editCategory (@PathVariable(name = "id")Long id){
		return new ResponseEntity<>(categoryService.findCategoryById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") Long cateid){
		try {
			categoryService.deleteCategoryById(cateid);
		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("{delete failed}");
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/updateIsDelete/{id}")
	public ResponseEntity<?>  setIsDelete(@PathVariable(name = "id") Long id) {
		int rowDelete =0;
		try {
			 rowDelete=categoryService.setIsDelete(id);
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
					.body("{delete failed}");
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
		        .body("[{ \"message\": \"delete succeed "+rowDelete+" row\"}]");
		

	}
	
}
