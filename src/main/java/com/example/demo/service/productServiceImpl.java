package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Product;
import com.example.demo.repository.productRepository;

@Service
public class productServiceImpl implements productService {
	
	@Autowired
	private productRepository prorep;
	

	@Override
	public List<Product> getAllProducts() {
		
		return prorep.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		this.prorep.save(product);
		
	}

	@Override
	public Product getProductId(int id) {
		Optional<Product> optional= prorep.findById(id);
		Product product=null;
		if(optional.isPresent())
			{
			
			product=optional.get();
			
		}
		else
		{
			throw new RuntimeException("Person not found for id ::"+id);
		}
		return product;
	}

	@Override
	public void deleteProductById(int id) {
		
		this.prorep.deleteById(id);
		
	}

	
	
}
