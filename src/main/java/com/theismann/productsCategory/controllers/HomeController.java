package com.theismann.productsCategory.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.theismann.productsCategory.models.Category;
import com.theismann.productsCategory.models.CategoryProduct;
import com.theismann.productsCategory.models.Product;
import com.theismann.productsCategory.services.AppService;

@Controller
public class HomeController {
	private final AppService appService;
	
	public HomeController(AppService appService) {
		this.appService = appService;
	}
	
	
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("allProducts", this.appService.getAllProducts());
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
		System.out.println(result);
		if(result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			appService.create(product);
		}
		return "redirect:/";
	}
	
	@PostMapping("/categorys/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			appService.create(category);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/categorys/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("categoryShow", this.appService.getCategory(id));
		model.addAttribute("allProducts", this.appService.FindLeftoverProducts(this.appService.getCategory(id)));
		return "showCategory.jsp";
	}
	
	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long  id, Model model) {
		model.addAttribute("productShow", this.appService.getProduct(id)); 
		model.addAttribute("allCategorys", this.appService.FindLeftoverCategorys(this.appService.getProduct(id)));
		return "showProduct.jsp";
	}
	
	@PostMapping("/addProductToCategory")
	public String addToCategory(@RequestParam(value="hiddenCategoryId") Long categoryId, @RequestParam(value="selectedProduct") Long productId) {
		
		Category categoryToGet = this.appService.getCategory(categoryId);
		Product prod = this.appService.getProduct(productId);
		
		CategoryProduct association = new CategoryProduct(prod, categoryToGet);
		if(!categoryToGet.getProducts().contains(prod)) {
		
			this.appService.createAssociation(association);
		}
		return String.format("redirect:/categorys/%d", categoryId);
	}
	
	@PostMapping("/addCategoryToProduct")
	public String addToProduct(@RequestParam(value="hiddenProductId") Long productId, @RequestParam(value="selectedCategory") Long categoryId) {
		
		Product productToGet = this.appService.getProduct(productId);
		Category cat = this.appService.getCategory(categoryId);
		
		CategoryProduct association = new CategoryProduct(productToGet, cat);
		if(!productToGet.getCategorys().contains(cat)) {
		
			this.appService.createAssociation(association);
		}
		return String.format("redirect:/products/%d", productId);
	}
	
	
}
