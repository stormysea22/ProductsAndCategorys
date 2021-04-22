package com.theismann.productsCategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.theismann.productsCategory.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	List<Category> findAll();

}
