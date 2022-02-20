package com.ncs.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ncs.model.Product;

@Service
@FeignClient(name = "PRODUCT-SERVICE", fallback = ProductServiceFallBack.class)
public interface ProductService {

	@GetMapping(value = "/products/inventoryid/{inventoryId}")
	public ResponseEntity<Product>  findByInventoryId(@PathVariable Integer inventoryId);

	@PostMapping(value = "/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product);
}
