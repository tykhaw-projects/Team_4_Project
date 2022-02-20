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
		return invRepo.findById(inventoryId).orElseThrow(InventoryIDNotFoundException::new);
	}

//	public Inventory findByProductId(Integer productId) {
//		return invRepo.findAllByProductId(productId);
//	}

	public Inventory addInventory(Inventory inventory) {
		return invRepo.saveAndFlush(inventory);
	}

	public Inventory updateInventory(Inventory inventory) {
		findByInventoryId(inventory.getInventoryId());
		return invRepo.saveAndFlush(inventory);
	}

	public boolean deleteInventory(Integer inventoryId) {
		Inventory found = findByInventoryId(inventoryId);
		invRepo.delete(found);
		return true;
	}
}