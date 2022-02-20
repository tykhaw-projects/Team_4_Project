package com.ncs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncs.model.Product;
import com.ncs.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productServ;
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		logger.info("Find all products");
		return new ResponseEntity<List<Product>>(productServ.getProducts(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/price/{price}")
	public ResponseEntity<List<Product>> findAllByPrice(@PathVariable Double price) {
		logger.info("Find products by price: " + price);
		return new ResponseEntity<List<Product>>(productServ.findAllByPrice(price), HttpStatus.OK);
	}
	
	@GetMapping(value = "/type/{type}")
	public ResponseEntity<List<Product>> findAllByType(@PathVariable String type) {
		logger.info("Find products by type: " + type);
		return new ResponseEntity<List<Product>>(productServ.findAllByType(type), HttpStatus.OK);
	}
	
	@GetMapping(value = "/id/{productId}")
	public ResponseEntity<Product> findByProductId(@PathVariable Integer productId) {
		logger.info("Find product by productId: " + productId);
		return new ResponseEntity<Product>(productServ.findByProductId(productId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/name/{productName}")
	public ResponseEntity<Product> findByProductName(@PathVariable String productName) {
		logger.info("Find product by productName: " + productName);
		return new ResponseEntity<Product>(productServ.findByProductName(productName), HttpStatus.OK);
	}
	
	@GetMapping(value = "/inventoryid/{inventoryId}")
	public ResponseEntity<Product> findByInventoryId(@PathVariable Integer inventoryId) {
		logger.info("Find product by inventoryId: " + inventoryId);
		return new ResponseEntity<Product>(productServ.findByInventoryId(inventoryId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		logger.info("Add product: " + product);
		return new ResponseEntity<Product>(productServ.addProduct(product), HttpStatus.CREATED);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteProduct(@RequestBody Integer productId) {
		logger.info("delete by Account id:"+productId);
		if(productServ.deleteProduct(productId))
			return  ResponseEntity.noContent().build();
		else
			return ResponseEntity.badRequest().body("Something unexpdected");
	}
	
	@PutMapping
	public ResponseEntity<Product> update(@RequestBody Product product) {
		logger.info("Update product: " + product);
		return new ResponseEntity<Product>(productServ.updateProduct(product), HttpStatus.OK);
	}
}
