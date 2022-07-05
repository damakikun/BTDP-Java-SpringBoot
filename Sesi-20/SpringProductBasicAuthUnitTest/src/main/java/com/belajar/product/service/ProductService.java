package com.belajar.product.service;

import java.util.List;

import com.belajar.product.entity.Product;

public interface ProductService {
	List<Product> findAllProduct();

	Product findProductById(Long id);

	Product saveorUpdateProduct(Product product);

	void deleteProduct(Long id);
}