package com.mindtree.kalingashop.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class BrandDto {

private int brandId;
	
	private String brandName;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonManagedReference
	private List<ProductDto> productDto;

	public BrandDto() {
		super();
	}

	public BrandDto(int brandId, String brandName, List<ProductDto> productDto) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.productDto = productDto;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public List<ProductDto> getProductDto() {
		return productDto;
	}

	public void setProductDto(List<ProductDto> productDto) {
		this.productDto = productDto;
	}

	
}
