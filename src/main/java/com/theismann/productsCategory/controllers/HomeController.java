package com.theismann.productsCategory.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.theismann.productsCategory.models.Category;
import com.theismann.productsCategory.models.Product;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}
	
	@RequestMapping("/categorys/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		}
		return "redirect:/";
	}
	
	@PostMapping("/categorys/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		}
		return "redirect:/";
	}
}
