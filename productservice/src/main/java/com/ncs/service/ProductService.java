package com.ncs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.model.Product;
import com.ncs.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> findAllByPrice(Double price) {
		return productRepo.findAllByPrice(price);
	}
	
	public List<Product> findAllByType(String type) {
		return productRepo.findAllByProductType(type);
	}
	
	public Product findByProductId(Integer productId) {
		return productRepo.findByProductId(productId);
	}
	
	public Product findByProductName(String productName) {
		return productRepo.findByProductName(productName);
	}
	
	public Product findByInventoryId(Integer inventoryId) {
		return productRepo.findByInventoryId(inventoryId);
	}
	
	public List<Product> getProducts() {
		return productRepo.findAll();
	}
	
	public Product addProduct(Product product) {
		return productRepo.saveAndFlush(product);
	}
	
	public Product updateProduct(Product product) {
		Product found = findByProductId(product.getProductId());
		
		if(found == null)
			return null;
		else
			return productRepo.saveAndFlush(product);
	}
	
	public boolean deleteProduct(Integer productId) {
		Product found = findByProductId(productId);
		
		if(found == null)
			return false;
		else {
			productRepo.delete(found);
			
			return true;
		}
	}
}
