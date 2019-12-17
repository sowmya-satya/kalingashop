package com.mindtree.kalingashop.service;

import java.io.IOException;
import java.util.List;

import com.mindtree.kalingashop.dto.ProductDto;

public interface BrandService {

	public List<ProductDto> writeToText() throws IOException;

	
}
