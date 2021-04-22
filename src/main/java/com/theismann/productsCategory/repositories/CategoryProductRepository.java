package com.theismann.productsCategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.theismann.productsCategory.models.CategoryProduct;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {
	List<CategoryProduct> findAll();
}
