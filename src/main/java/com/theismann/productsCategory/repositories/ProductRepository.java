package com.theismann.productsCategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.theismann.productsCategory.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();

}
