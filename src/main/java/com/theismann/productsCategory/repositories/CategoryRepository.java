package com.theismann.productsCategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.theismann.productsCategory.models.Category;
import com.theismann.productsCategory.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List<Category> findAll();

	List<Category> findByproductsNotContains(Product product);
	

}
