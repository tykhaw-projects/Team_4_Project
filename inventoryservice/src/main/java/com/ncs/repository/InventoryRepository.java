package com.ncs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	Inventory findAllByProductId(Integer productId);

}