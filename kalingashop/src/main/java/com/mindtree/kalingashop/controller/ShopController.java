package com.mindtree.kalingashop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingashop.dto.ProductDto;
import com.mindtree.kalingashop.dto.ShopDto;
import com.mindtree.kalingashop.exception.ServiceException;
import com.mindtree.kalingashop.service.BrandService;
import com.mindtree.kalingashop.service.ProductService;
import com.mindtree.kalingashop.service.ShopService;

@RestController
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(path ="/addDetails")
	public ResponseEntity<Map<String, Object>> addDetails(@RequestBody ShopDto shopdto){
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("Header", "Details of products with brands in shop");
		response.put("Error", false);
		response.put("Body", productService.addDetails(shopdto));
		response.put("HttpStatus",HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping(path="/getDetails/{brandId}")
	public ResponseEntity<Map<String, Object>> getAllProductsOnBrand(@PathVariable int brandId) throws ServiceException {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("Header", "Details of products with brands in shop");
		response.put("Error", false);
		response.put("Body", productService.getAllProductsOnBrand(brandId));
		response.put("HttpStatus",HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/write")
	public List<ProductDto> writeToText(){
		List<ProductDto> brands = new ArrayList<>();
		try {
			brands = brandService.writeToText();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brands;
	}
	
	
	
	//hello
	
}
