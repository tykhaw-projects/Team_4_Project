package com.ncs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAllByPrice(Double price);
	
	List<Product> findAllByProductType(String type);
	
	Product findByProductId(Integer productId);
	
	Product findByProductName(String productName);
	
//	Product findByInventoryId(Integer inventoryId);
}
