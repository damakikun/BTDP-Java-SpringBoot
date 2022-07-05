package com.belajar.product.service;

import java.util.List;


import com.belajar.product.entity.Product;

public interface ProductService {
	List<Product> findAllProducts();

	List<Product> findAllProductsByName(String name);

	Product findProductById(Long id);

	Product saveProduct(Product product);

	void deleteProductById(Long id);
}