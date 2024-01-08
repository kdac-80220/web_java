package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ProductDao;
import com.app.entities.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		
		return productDao.save(product);		
	}

	@Override
	public String deleteProduct(Long productId) {
		productDao.deleteById(productId);
		return "Product Deleted";
	}

	@Override
	public Product findProduct(Long productId) {
		return productDao.findById(productId).orElseThrow();
	}

	@Override
	public Product updateProduct(Product product) {
		return productDao.save(product);
	}

//	@Override
//	public List<Product> findProductByType(String productType) {
//		return productDao.findByType(productType);
//	}

}
