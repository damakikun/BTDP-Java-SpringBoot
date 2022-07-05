package com.belajar.product.controller;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.belajar.product.entity.Product;
import com.belajar.product.repository.ProductRepository;
import com.belajar.product.service.ProductService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/sales")
public class ProductController {

	@Autowired
	private ProductRepository produkRepository;

	@Autowired
	private ProductService produkService;

	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return produkRepository.findAll();
	}

	@PostMapping("/products")
	public Product saveProducts(@RequestBody Product product) {
		return produkService.saveProduct(product);
	}

	@GetMapping("/products/id/{id}")
	public Product findProductById(@PathVariable Long id) {
		return produkService.findProductById(id);
	}

	@DeleteMapping("/products/id/{id}")
	public void deleteById(@PathVariable Long id) {
		produkService.deleteProductById(id);
	}
}
