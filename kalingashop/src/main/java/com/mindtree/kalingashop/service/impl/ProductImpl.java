package com.mindtree.kalingashop.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingashop.dto.ProductDto;
import com.mindtree.kalingashop.dto.ShopDto;
import com.mindtree.kalingashop.entity.Brand;
import com.mindtree.kalingashop.entity.Product;
import com.mindtree.kalingashop.entity.Shop;
import com.mindtree.kalingashop.exception.NoSuchBrandFound;
import com.mindtree.kalingashop.exception.ServiceException;
import com.mindtree.kalingashop.exception.util.ErrorConstants;
import com.mindtree.kalingashop.repository.BrandRepository;
import com.mindtree.kalingashop.repository.ProductRepository;
import com.mindtree.kalingashop.repository.ShopRepository;
import com.mindtree.kalingashop.service.ProductService;

@Service
public class ProductImpl implements ProductService {

	@Autowired
	private ShopRepository shopRepo;

	@Autowired
	private BrandRepository brandRepo;

	@Autowired
	private ProductRepository productRepo;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public String addDetails(ShopDto shopdto) {
		// TODO Auto-generated method stub
		Shop shop = modelMapper.map(shopdto, Shop.class);
		/*
		 * List<Product> product = shop.getProduct(); 
		 * for (Product p : product) { 
		 * Brand b = p.getBrand();
		 * p.setBrand(b);
		 * p.setShop(shop); 
		 * }
		 */
		shop.getProduct().forEach(p -> {
			Brand b = p.getBrand();

			p.setBrand(b);
			p.setShop(shop);

			productRepo.save(p);
		});
		shopRepo.save(shop);
		return "inserted Successfully";
	}

	@Override
	public List<ProductDto> getAllProductsOnBrand(int brandId) throws ServiceException {
		// TODO Auto-generated method stub
		Brand brand = brandRepo.findById(brandId)
				.orElseThrow(() -> new NoSuchBrandFound(ErrorConstants.NOSUCHBRANDFOUND));
		return brand.getProduct().stream().filter(i -> i.getPrice() > 100)
				.map(j -> modelMapper.map(j, ProductDto.class)).collect(Collectors.toList());
		
	}
		
		
	
	
		public List<Product> sort()
		{
			List<Product> productss = productRepo.findAll();
			List<Product> listProducts = new ArrayList<Product>();
			for (Product product : productss) {
				if(product.getPrice()>100)
				{
					listProducts.add(product);
				}
			}
			Collections.sort(listProducts, new Comparator<Product>() {

				@Override
				public int compare(Product p1, Product p2) {
					
					return p1.getPrice()-p2.getPrice();
				}
				
				
				
			});
			return null;
		}
		
	

		/*
		 * List<Product> productDetails = productRepo.findAll();
		 * List<ProductDto>productdto = new ArrayList<ProductDto>(); for (Product p : productDetails) {
		 * if(p.getBrand().getBrandId()==brandId) { if(p.getPrice()>100) { ProductDto
		 * productDto = modelMapper.map(p, ProductDto.class);
		 * productdto.add(productDto); }} else { throw new
		 * NOSUCHBRANDFOUND(ErrorConstants.NOSUCHBRANDFOUND); } } 
		 * return productRepo.findAll().stream().filter(i-> i.getPrice()>100).map(j ->
		 * modelMapper(j, ProductDto.class)) .collect(Collectors.toList()); }
		 */

		
		
		
		
		
		
	}
