package com.mindtree.kalingashop.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingashop.dto.ProductDto;
import com.mindtree.kalingashop.entity.Brand;
import com.mindtree.kalingashop.entity.Product;
import com.mindtree.kalingashop.repository.BrandRepository;
import com.mindtree.kalingashop.repository.ProductRepository;
import com.mindtree.kalingashop.service.BrandService;

@Service
public class BrandImpl implements BrandService {

	@Autowired
	private static Workbook wb;
	@Autowired
	private static Sheet sh;
	@Autowired
	private static FileOutputStream fis;
	@Autowired
	private static FileOutputStream fos;
	@Autowired
	private static Row row;
	@Autowired
	private static Cell cell;

	@Autowired
	BrandRepository brandRepo;
	@Autowired
	ProductRepository productRepository;

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ProductDto> writeToText() throws IOException {
		// TODO Auto-generated method stub

		List<Product> brands = new ArrayList<Product>();
		brands = productRepository.findAll();
		List<ProductDto> brandsDto = new ArrayList<>();
		/*
		 * FileWriter writer; try { writer = new FileWriter("Brand.txt");
		 * writer.write("\tID\t" + "Name\t" + "Price" + System.lineSeparator());
		 * writer.write("\t=====================================================\n");
		 * for (Product brand : brands) { brandsDto.add(modelMapper.map(brand,
		 * ProductDto.class)); writer.write("\t" + brand.getProductId() + "\t" +
		 * brand.getProductName() + "\t" + brand.getPrice() + System.lineSeparator()); }
		 * writer.close(); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * return brandsDto; }
		 */

		fis = new FileOutputStream("C:\\Users\\m1056314\\Documents\\BrandSheet.xlsx");
		// wb = WorkbookFactory.create(fis);
		Workbook workbook = new XSSFWorkbook();
		sh = workbook.createSheet("Sheet1");
		int rownum = 0;
		Row row = sh.createRow(rownum);
		/*
		 * int rowNumber = 0; for (Department d : dept) {
		 */

		for (Product brand : brands) {
			brandsDto.add(modelMapper.map(brand, ProductDto.class));
			row = sh.createRow(rownum++);
			row.createCell(0).setCellValue(brand.getProductId());
			row.createCell(1).setCellValue(brand.getProductName());
			row.createCell(2).setCellValue(brand.getPrice());
		}
		workbook.write(fis);
		workbook.close();

		return brandsDto;

	}

	// row.createCell(2).setCellValue(d.getEmployee().g);
	// }

}
