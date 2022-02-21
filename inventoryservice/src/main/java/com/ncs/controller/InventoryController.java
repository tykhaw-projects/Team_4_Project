package com.ncs.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ncs.exception.InventoryIDNotFoundException;
//import com.ncs.exception.ProductIDNotFoundException;
import com.ncs.model.Inventory;
import com.ncs.service.InventoryService;

@CrossOrigin
@RestController
public class InventoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);
	
	@Autowired
	InventoryService invService;

	@GetMapping(value = "/inventory")
	public ResponseEntity<List<Inventory>> getInventory() {
		logger.info("Find all inventory information");
		return new ResponseEntity<List<Inventory>>(invService.getInventory(), HttpStatus.OK);
	}

	@GetMapping(value = "/inventory/{inventoryId}")
	public ResponseEntity<Inventory> findByInventoryId(@PathVariable Integer inventoryId) {
		logger.info("Find by inventory ID :" + inventoryId);
		
		if(invService.findByInventoryId(inventoryId) == null)
			throw new InventoryIDNotFoundException();
			
		return new ResponseEntity<Inventory>(invService.findByInventoryId(inventoryId), HttpStatus.OK);
	}

//	@GetMapping(value = "/inventory/product/{productId}")
//	public ResponseEntity<Inventory> findByProductId(@PathVariable Integer productId) {
//		Inventory result = invService.findByProductId(productId);
//		logger.info("Find by product ID :" + productId);
//		if (result == null)
//			throw new ProductIDNotFoundException();
//
//		return new ResponseEntity<Inventory>(result, HttpStatus.OK);
//	}

	@PostMapping(value = "/inventory")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
		Inventory result = invService.addInventory(inventory);
		logger.info("Add Inventory :" + inventory);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/inventoryId")
				.buildAndExpand(result.getInventoryId()).toUri();
		return ResponseEntity.created(location).body(inventory);
	}
	
	@PutMapping(value = "/inventory")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory) {
		Inventory result = invService.updateInventory(inventory);
		logger.info("Update Inventory :" + inventory);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/inventoryId")
				.buildAndExpand(result.getInventoryId()).toUri();
		return ResponseEntity.created(location).body(inventory);
	}
	
	@PutMapping(value = "/inventory/{inventoryId}/buyingPrice/{buyingPrice}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Inventory> updateBuyingPrice(@PathVariable Integer inventoryId, @PathVariable Double buyingPrice) {
		Inventory found = invService.updateBuyingPrice(inventoryId, buyingPrice);
		logger.info("Update BuyingPrice in Inventory :" + found);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/inventoryId")
				.buildAndExpand(found.getInventoryId()).toUri();
		return ResponseEntity.created(location).body(found);
	}
	
	@PutMapping(value = "/inventory/{inventoryId}/quantity/{quantity}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Inventory> updateQuantity(@PathVariable Integer inventoryId, @PathVariable Integer quantity) {
		Inventory found = invService.updateQuantity(inventoryId, quantity);
		logger.info("Update Quantity in Inventory :" + found);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/inventoryId")
				.buildAndExpand(found.getInventoryId()).toUri();
		return ResponseEntity.created(location).body(found);
	}
	
	@PutMapping(value = "/inventory/{inventoryId}/buyingPrice/{buyingPrice}/quantity/{quantity}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Inventory> updateAll(@PathVariable Integer inventoryId, @PathVariable Double buyingPrice, @PathVariable Integer quantity) {
		Inventory found = invService.updateAll(inventoryId, buyingPrice, quantity);
		logger.info("Update BuyingPrice and Quantity in Inventory :" + found);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/inventoryId")
				.buildAndExpand(found.getInventoryId()).toUri();
		return ResponseEntity.created(location).body(found);
	}
	
	@DeleteMapping(value = "inventory/{inventoryId}")
	public ResponseEntity<?> deleteInventory(@PathVariable Integer inventoryId) {
		if(invService.deleteInventory(inventoryId)) {
			logger.info("delete by inventory id:" + inventoryId);
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.badRequest().body("Something unexpected happened!");
		}
	}
}