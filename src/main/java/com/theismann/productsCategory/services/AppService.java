package com.theismann.productsCategory.services;

import java.util.List;
import java.util.Optional;

import com.theismann.productsCategory.models.Category;
import com.theismann.productsCategory.models.Product;
import com.theismann.productsCategory.repositories.CategoryProductRepository;
import com.theismann.productsCategory.repositories.CategoryRepository;
import com.theismann.productsCategory.repositories.ProductRepository;

public class AppService {
	
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	private CategoryProductRepository categoryProductRepository;
	

	public AppService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.categoryProductRepository = categoryProductRepository;
		
	}

	//Create
	public Product create(Product product) {
		return productRepository.save(product);
	}
	
	public Category create(Category category) {
		return categoryRepository.save(category);
	}
	
	//display
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}
	public List<Category> getAllCategory() {
		return (List<Category>) categoryRepository.findAll();
	}
	
	//display one
	
		public Product getProduct(Long id) {
			Optional<Product> optionalProduct = this.productRepository.findById(id);
			if(optionalProduct.isPresent()) {
				return optionalProduct.get();
			} else {
				return null;
			}
		}
		
		public Category getCategory(Long id) {
			Optional<Category> optionalCategory = this.categoryRepository.findById(id);
			if(optionalCategory.isPresent()) {
				return optionalCategory.get();
			} else {
				return null;
			}
		}
	
}
