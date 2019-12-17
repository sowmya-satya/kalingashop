package com.mindtree.kalingashop.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ProductDto {

private int productId;
	
	private String productName;
	
	private int price;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonBackReference
	private ShopDto shopDto;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonBackReference
	private BrandDto brandDto;

	public ProductDto() {
		super();
	}

	public ProductDto(int productId, String productName, int price, ShopDto shopDto, BrandDto brandDto) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.shopDto = shopDto;
		this.brandDto = brandDto;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	@JsonIgnore
	public ShopDto getShopDto() {
		return shopDto;
	}

	public void setShopDto(ShopDto shopDto) {
		this.shopDto = shopDto;
	}
	@JsonIgnore
	public BrandDto getBrandDto() {
		return brandDto;
	}

	public void setBrandDto(BrandDto brandDto) {
		this.brandDto = brandDto;
	}

	

	
	
}
