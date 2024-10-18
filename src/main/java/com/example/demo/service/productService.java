package com.example.demo.service;

import java.util.List;

import com.example.demo.Product;

public interface productService {
	
	List<Product> getAllProducts();
	void saveProduct(Product product);
	Product getProductId(int id);
	void deleteProductById(int id);
	

}
