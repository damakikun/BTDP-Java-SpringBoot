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
		return produkService.saveorUpdateProduct(product);
	}

//	@GetMapping("/products/name/{name}")
//	public List<Product> findAllProductsByName(@PathVariable String name) {
//		return produkService.findAllProductsByName(name);
//	}

	@DeleteMapping("/products/id/{id}")
	public void deleteById(@PathVariable Long id) {
		produkService.deleteProduct(id);
	}

	@CrossOrigin
	@PutMapping("/products")
	public ResponseEntity<?> updateProductById(@RequestBody Product product, @RequestParam Long id) {

		try {
			Product checkProduct = produkService.findProductById(id);
			if (checkProduct.getId() != id) {
				return new ResponseEntity<>("ID Data produk tidak sesuai", HttpStatus.OK);
			}
			product.setId(id);
			produkService.saveorUpdateProduct(product);

			// update from tb_product set name="Acer", hargaBeli=500, hargaJual=501
			// where id=?1

			return new ResponseEntity<>("Berhasil simpan produk", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("Terjadi kesalahan" + e.getMessage(), HttpStatus.OK);
		}
	}

}
