package com.theismann.productsCategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.theismann.productsCategory.models.Category;
import com.theismann.productsCategory.models.CategoryProduct;
import com.theismann.productsCategory.models.Product;
import com.theismann.productsCategory.repositories.CategoryProductRepository;
import com.theismann.productsCategory.repositories.CategoryRepository;
import com.theismann.productsCategory.repositories.ProductRepository;

@Service
public class AppService {
	
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	private CategoryProductRepository categoryProductRepository;
	

	public AppService(ProductRepository productRepository, CategoryRepository categoryRepository, CategoryProductRepository categoryProductRepository) {
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
		return this.productRepository.findById(id).orElse(null);
	}
		
		public Category getCategory(Long id) {
			Optional<Category> optionalCategory = this.categoryRepository.findById(id);
			if(optionalCategory.isPresent()) {
				return optionalCategory.get();
			} else {
				return null;
			}
		}
		
	public CategoryProduct createAssociation(CategoryProduct cp) {
		return this.categoryProductRepository.save(cp);
	}
	
	public List<Product> FindLeftoverProducts(Category category){
		return this.productRepository.findBycategorysNotContains(category);
	}
	
	public List<Category> FindLeftoverCategorys(Product product){
		return this.categoryRepository.findByproductsNotContains(product);
	}
	
//	public void addCatToProduct(CategoryProduct categoryProduct) {
//		categoryProductRepository.save(categoryProduct);
//	}
}
