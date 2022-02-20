package com.ncs.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.model.Product;

@Service
public class ProductServiceFallBack implements ProductService {

	@Override
	public ResponseEntity<Product> findByInventoryId(Integer inventoryId) {
		// TODO Auto-generated method stub
		Product fallback = new Product(0, "Dummy Name", "Dummy Description", 0.0, "Dummy Type", 0);
		
		return ResponseEntity.ok(fallback);
	}

	@Override
	public ResponseEntity<Product> addProduct(Product product) {
		// TODO Auto-generated method stub
		Product fallback = new Product(0, "Dummy Name", "Dummy Description", 0.0, "Dummy Type", 0);
		
		return ResponseEntity.ok(fallback);
	}

}
