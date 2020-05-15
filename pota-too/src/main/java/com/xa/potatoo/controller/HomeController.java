package com.xa.potatoo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.potatoo.services.CategoryService;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	
	@GetMapping(value = "index")
	public ModelAndView index() {
	ModelAndView view = new ModelAndView("/index");
	return view;
	}
	
	@Autowired
	private CategoryService cateService;
	
	@GetMapping("/category/")
	public String categories(Model model) {
		model.addAttribute("categories",cateService.findCategories());
		return "category/category-rest";
	}
	
	@GetMapping("/rest/category")
	public String showRestCategory() {
		return "category/category-rest.html";
	}
	
	@GetMapping("/rest/category/add")
	public String showCategoryAdd() {
		return "category/addEdit.html";
	}
	
	
}
