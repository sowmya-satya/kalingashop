package com.mindtree.kalingashop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shopId;
	
	private String shopName;
	
	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
	private List<Product> product;
	
	

	public Shop() {
		super();
	}

	public Shop(int shopId, String shopName, List<Product> product) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.product = product;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", product=" + product + "]";
	}
	
	

}
