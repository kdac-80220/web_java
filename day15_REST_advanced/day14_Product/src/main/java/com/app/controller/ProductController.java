package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Product;
import com.app.service.ProductService;


@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public ProductController() {
	System.out.println("in product controller"+getClass());
	}
	
	@GetMapping
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product)
	{
		return productService.addProduct(product);
	}
	
	@DeleteMapping("/{productId}")
	public String deleteProduct(@PathVariable Long productId)
	{
		return productService.deleteProduct(productId);
	}
	
	@GetMapping("/{productId}")
	public Product findProduct(@PathVariable Long productId)
	{
		return productService.findProduct(productId);
	}
	
//	@GetMapping("/{productType}")
//	public List<Product> findProductsByType(@PathVariable String productType)
//	{
//		return productService.findProductByType(productType);
//	}
	
	@PutMapping
	public Product updateProduct(@RequestBody Product product)
	{
		return productService.updateProduct(product);
	}
}
