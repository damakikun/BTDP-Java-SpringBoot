package com.belajar.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.belajar.product.entity.Product;
import com.belajar.product.repository.ProductRepository;
import com.belajar.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Product saveorUpdateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product findProductById(Long id) {
		Product product = productRepository.findById(id).orElse(new Product());
		return product;
	}

	@Override
	public void deleteProduct(Long id) {
		Product product = productRepository.findById(id).orElse(new Product());
		productRepository.delete(product);

	}

}