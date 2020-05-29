package com.xa.potatoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xa.potatoo.model.dto.ProductDto;
import com.xa.potatoo.models.Product;
import com.xa.potatoo.services.ProductService;

@RestController
@RequestMapping(path = "/api/product",produces = "application/json")
@CrossOrigin(origins = "*")


public class ProductRestController {
	@Autowired
	private ProductService prodService;
	
	@GetMapping("/")
	public ResponseEntity<?>findAllProduct(){
		return new ResponseEntity<>(prodService.findAllProduct(),HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveProduct(@RequestBody Product product){
		return new ResponseEntity<> (prodService.save(product),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Long productId){
		try {
			prodService.delete(productId);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("{delete failed}");
		}
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/put")
	public ResponseEntity<?> putProduct(@RequestBody Product product){
		return new ResponseEntity<>(prodService.save(product),HttpStatus.OK);
	}
	
	// dto implementation
	@GetMapping("/fetchDto")
	public ResponseEntity<?> queryProduct(@RequestParam Integer pageNo, @RequestParam Integer pageSize,
			@RequestParam String sortBy, @RequestParam String sortType ){
		return new ResponseEntity<>(prodService.queryProduct(pageNo, pageSize, sortBy, sortType),HttpStatus.OK);
	}
	
	@GetMapping("/findProductByDto/{id}")
	public ResponseEntity<?> findProductById(@PathVariable("id") Long id){
		return new ResponseEntity<>(prodService.findProductById(id),HttpStatus.OK);
	}
	
	@PostMapping("/saveDto")
	public ResponseEntity<?> saveProductDto(@RequestBody ProductDto productDto){
		return new ResponseEntity<>(prodService.saveProductDto(productDto),HttpStatus.OK);
	}
	
	@GetMapping("/searchBy")
	public ResponseEntity<?> searcProductBy(@RequestParam Integer pageNo,@RequestParam Integer pageSize,
			@RequestParam String sortBy,@RequestParam String sortType, @RequestParam String name, @RequestParam String description){
		return new ResponseEntity<>(prodService.searchProductBy(pageNo, pageSize, sortBy, sortType, name, description),HttpStatus.OK);
	}
	
	
	@GetMapping("updateIsDelete/{id}")
	public ResponseEntity<?> setIsDelete (@PathVariable(name = "id")Long id){
		int rowDelete =0;
		try {
			rowDelete = prodService.setProductIsDelete(id);
		} catch (EmptyResultDataAccessException e) {
			// TODO: handle exception
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("{delete failed}");
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("[{\"message\":\"delete succeed "+rowDelete+"row\"}]");
	}	

}
