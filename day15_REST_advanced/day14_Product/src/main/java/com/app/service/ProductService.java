package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entities.Product;


public interface ProductService {

	List<Product> getAllProducts();

	Product addProduct(Product product);

	String deleteProduct(Long productId);

	Product findProduct(Long productId);

	Product updateProduct(Product product);

	//List<Product> findProductByType(String productType);

}
