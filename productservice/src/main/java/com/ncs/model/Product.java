package com.ncs.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="PRODUCTS")
@Entity
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5043784754953553501L;

	@Id
	@Column(name="PRODUCTID")
	@GeneratedValue
	private Integer productId;
	
	@Column(name="PRODUCTNAME")
	private String productName;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="PRODUCTTYPE")
	private String productType;
	
//	@Column(name="INVENTORYID")
//	private Integer inventoryId;
	
	public Product() {
		super();
	}

//	public Product(Integer productId, String productName, String description, Double price, String productType,
//			Integer inventoryId) {
//		super();
//		this.productId = productId;
//		this.productName = productName;
//		this.description = description;
//		this.price = price;
//		this.productType = productType;
//		this.inventoryId = inventoryId;
//	}

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getType() {
		return productType;
	}
	public void setType(String type) {
		this.productType = type;
	}

//	public Integer getInventoryId() {
//		return inventoryId;
//	}
//
//	public void setInventoryId(Integer inventoryId) {
//		this.inventoryId = inventoryId;
//	}

//	@Override
//	public String toString() {
//		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
//				+ ", price=" + price + ", productType=" + productType + ", inventoryId=" + inventoryId + "]";
//	}

}