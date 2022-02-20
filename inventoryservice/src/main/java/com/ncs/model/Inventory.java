package com.ncs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

@Table(name = "INVENTORY")
@Entity
public class Inventory implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "INVENTORYID")
	private Integer inventoryId;
	
//	@Column(name = "PRODUCTID")
//	private Integer productId;
	
	@Column(name = "QUANTITY")
	@Min(value = 0, message = "Quantity should not be less than 0")
	private Integer quantity;
	
	@Transient
	Product product;
	
	public Inventory() {
		super();
	}

//	public Inventory(Integer inventoryId, Integer productId,
//			@Min(value = 0, message = "Quantity should not be less than 0") Integer quantity) {
//		super();
//		this.inventoryId = inventoryId;
//		this.productId = productId;
//		this.quantity = quantity;
//	}
	
//	public Inventory(Integer inventoryId,
//			@Min(value = 0, message = "Quantity should not be less than 0") Integer quantity, Product product) {
//		super();
//		this.inventoryId = inventoryId;
//		this.quantity = quantity;
//		this.product = product;
//	}	

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

//	public Integer getProductId() {
//		return productId;
//	}
//
//	public void setProductId(Integer productId) {
//		this.productId = productId;
//	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", quantity=" + quantity + ", product=" + product + "]";
	}

//	@Override
//	public String toString() {
//		return "Inventory [inventoryId=" + inventoryId + ", productId=" + productId + ", quantity=" + quantity + "]";
//	}
}