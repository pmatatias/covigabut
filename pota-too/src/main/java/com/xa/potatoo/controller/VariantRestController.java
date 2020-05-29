package com.xa.potatoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xa.potatoo.models.Variant;
import com.xa.potatoo.services.VariantService;

@RestController
@RequestMapping(path = "/api/variant", produces = "application/json")
@CrossOrigin(origins = "*")

public class VariantRestController {
	
	@Autowired
	private VariantService variantService;
	
	@GetMapping("/")
	public ResponseEntity<?>findAllVariants(){
		return new ResponseEntity<>(variantService.findVariants(),HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> addVariant(@RequestBody Variant variant){
		return new ResponseEntity<>(variantService.save(variant),HttpStatus.OK);
	}
	
	@PutMapping("/put")
	public ResponseEntity<?> putVariant(@RequestBody Variant variant){
		return new ResponseEntity<>(variantService.save(variant),HttpStatus.OK);
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity<?> editVariant(@PathVariable (name = "id")Long id){
		return new ResponseEntity<>(variantService.findVariantById(id),HttpStatus.OK);
	}
	
	@GetMapping("/fetchDto")
	public ResponseEntity<?> queryVariant(){
		return new ResponseEntity<>(variantService.queryVariant(),HttpStatus.OK);
	}
	
	@GetMapping("editDto/{id}")
	public ResponseEntity<?> editVariantDto(@PathVariable(name = "id")Long id){
		return new ResponseEntity<>(variantService.queryVariantByCateId(id),HttpStatus.OK);
	}
	
	@GetMapping("/searchVariantName")
	public ResponseEntity<?> queryVariantByName(@RequestParam("name")String name, @RequestParam("description")String desc){
		return new ResponseEntity<>(variantService.queryVariantByName(name, desc),HttpStatus.OK);
	}
	
	
	@GetMapping("/updateIsDelete/{id}")
	public ResponseEntity<?> setIsDelete(@PathVariable (name = "id")Long id){
		int rowDelete=0;
		try {
			rowDelete = variantService.setIsDelete(id);
		}catch(EmptyResultDataAccessException e) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("delete failesd");
		}
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("[{\"message\": \"delete succed "+rowDelete+"row\"}]");
	}

}
