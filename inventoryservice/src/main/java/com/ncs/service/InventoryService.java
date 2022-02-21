package com.ncs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.exception.InventoryIDNotFoundException;
import com.ncs.model.Inventory;
import com.ncs.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	InventoryRepository invRepo;
	
	@Autowired
	ProductService prodServ;

	public List<Inventory> getInventory() {
		List<Inventory> inventory = invRepo.findAll();
		
		for (Inventory inv : inventory) {
			inv.setProduct(prodServ.findByInventoryId(inv.getInventoryId()).getBody());
		}
		
		return inventory;
	}

	public Inventory findByInventoryId(Integer inventoryId) {
		Inventory found = invRepo.findById(inventoryId).orElseThrow(InventoryIDNotFoundException::new);
		
		found.setProduct(prodServ.findByInventoryId(found.getInventoryId()).getBody());
		
		return found;
	}

//	public Inventory findByProductId(Integer productId) {
//		return invRepo.findAllByProductId(productId);
//	}

	public Inventory addInventory(Inventory inventory) {
		return invRepo.saveAndFlush(inventory);
	}
	
	public Inventory updateBuyingPrice(Integer inventoryId, Double buyingPrice) {
		Inventory inv = invRepo.findById(inventoryId).orElseThrow(InventoryIDNotFoundException::new);
		inv.setBuyingPrice(buyingPrice);
		inv.setProduct(prodServ.findByInventoryId(inv.getInventoryId()).getBody());
		return invRepo.saveAndFlush(inv);
	}
	
	public Inventory updateQuantity(Integer inventoryId, Integer quantity) {
		Inventory inv = invRepo.findById(inventoryId).orElseThrow(InventoryIDNotFoundException::new);
		inv.setQuantity(quantity);
		inv.setProduct(prodServ.findByInventoryId(inv.getInventoryId()).getBody());
		return invRepo.saveAndFlush(inv);
	}
	
	public Inventory updateAll(Integer inventoryId, Double buyingPrice, Integer quantity) {
		Inventory inv = invRepo.findById(inventoryId).orElseThrow(InventoryIDNotFoundException::new);
		inv.setBuyingPrice(buyingPrice);
		inv.setQuantity(quantity);
		inv.setProduct(prodServ.findByInventoryId(inv.getInventoryId()).getBody());
		return invRepo.saveAndFlush(inv);
	}

	public Inventory updateInventory(Inventory inventory) {
		Inventory found = findByInventoryId(inventory.getInventoryId());
		
		inventory.setProduct(prodServ.findByInventoryId(inventory.getInventoryId()).getBody());
		
		if(found == null)
			return null;
		else
			return invRepo.saveAndFlush(inventory);
	}

	public boolean deleteInventory(Integer inventoryId) {
		Inventory found = findByInventoryId(inventoryId);
		invRepo.delete(found);
		return true;
	}
}