package com.mindtree.kalingashop.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ShopDto {
	
private int shopId;
	
	private String shopName;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonManagedReference
	private List<ProductDto> productDto;
	
	

	public ShopDto() {
		super();
	}



	public ShopDto(int shopId, String shopName, List<ProductDto> productDto) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.productDto = productDto;
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



	public List<ProductDto> getProductDto() {
		return productDto;
	}



	public void setProductDto(List<ProductDto> productDto) {
		this.productDto = productDto;
	}

	

}
