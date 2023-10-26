package com.ecommerce.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.model.Category;
import com.ecommerce.ecommerce.model.Product; 
import com.ecommerce.ecommerce.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	
	public void createProduct(ProductDto productDto, Category category) {

		Product product= new Product();
		product.setDescription(productDto.getDescription());
		product.setImageURL(productDto.getImageURL());
		product.setName(productDto.getName());
		product.setCategory(category);
		product.setPrice(productDto.getPrice());
		productRepo.save(product);
	}



	public List<ProductDto> getProduct() {
  List<ProductDto> allProductDto = new ArrayList<ProductDto>();
List<Product> allProducts =productRepo.findAll();

for(Product product:allProducts) {
	allProductDto.add(convetToDto(product));
}
		return allProductDto;
	}



	public ProductDto convetToDto(Product product) {
	ProductDto productDto = new ProductDto();
	productDto.setCateogry_id(product.getCategory().getId());
	productDto.setProduct_id(product.getId());
	productDto.setImageURL(product.getImageURL());
	productDto.setName(product.getName());
	productDto.setPrice(product.getPrice());
	
		return productDto;
	}



	public void updateProduct(ProductDto productDto, int productId) throws Exception {

		
		Optional<Product> Optionalproduct= productRepo.findById(productId);
if(!Optionalproduct.isPresent()) {

	throw new Exception("Product is invalid");
}
else {
	 Product product =Optionalproduct.get();
	product.setDescription(productDto.getDescription());
	product.setImageURL(productDto.getImageURL());
	product.setName(productDto.getName());
	product.setId(productDto.getCateogry_id());;
	product.setPrice(productDto.getPrice());
	productRepo.save(product);
}
		
	}
	
	/*
	 * public ProductService(@Qualifier("products") ProductRepo productRepo) { //
	 * TODO Auto-generated constructor stub this.productRepo=productRepo; }
	 */
	
	

}
