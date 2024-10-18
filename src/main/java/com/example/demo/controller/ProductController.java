package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Product;
import com.example.demo.service.productService;

@Controller
public class ProductController {
	
	@Autowired
	private productService prodsr;
	
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("listProduct",prodsr.getAllProducts());		
		return "index";	
	}
	@GetMapping("/newProduct")
	public String newProduct(Model md)
	{
		Product pd=new Product();
		md.addAttribute("pd",pd);
		return "new_Product";
	}
	
	@PostMapping("/saveProduct")
	public String addform(@ModelAttribute ("pd") Product pd)
	{		
		prodsr.saveProduct(pd);
		return "redirect:/";		
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") int id,Model md)
	{
		Product pd=prodsr.getProductId(id);
		md.addAttribute("pd",pd);
		return "update_product";
	}
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value="id") int id)
	{
		this.prodsr.deleteProductById(id);
		return "redirect:/";			
	}

	


	

	}
