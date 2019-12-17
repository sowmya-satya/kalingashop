package com.mindtree.kalingashop.service;

import java.util.List;

import com.mindtree.kalingashop.dto.ProductDto;
import com.mindtree.kalingashop.dto.ShopDto;
import com.mindtree.kalingashop.exception.ServiceException;

public interface ProductService {

	public String addDetails(ShopDto shopdto);

	public List<ProductDto> getAllProductsOnBrand(int brandId) throws ServiceException;

}
