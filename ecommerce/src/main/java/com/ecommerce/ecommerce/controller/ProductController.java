package com.ecommerce.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.config.ApiResponse;
import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.model.Category;
import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.repository.CategoryRepo;
import com.ecommerce.ecommerce.service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryRepo categoryRepo;
	
	@PostMapping("/addProduct")
	public ResponseEntity<ApiResponse> create(@RequestBody ProductDto productDto) {
		Optional<Category> optionalCategory= categoryRepo.findById(productDto.getCateogry_id());
		if(!optionalCategory.isPresent()) {
			return	new ResponseEntity<ApiResponse>(new ApiResponse(false, "ERROR"), HttpStatus.BAD_REQUEST);
			//return	new ResponseEntity<ApiResponse>(new ApiResponse(false, "Created New Cateogry"));
		}else {
		productService.createProduct(productDto ,optionalCategory.get());
		return	new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
		}
	}
	
@GetMapping("/")
public ResponseEntity<List<ProductDto>> getAllProducts() throws Exception{
	
	List<ProductDto> allProduct = productService.getProduct();
	if(allProduct.isEmpty()){
	return new ResponseEntity<List<ProductDto>>(allProduct, HttpStatus.NO_CONTENT);

	}
	else
		return new ResponseEntity<List<ProductDto>>(allProduct, HttpStatus.ACCEPTED);
}



@PostMapping("/update/{productId}")
public ResponseEntity<ApiResponse> updateProduct(@PathVariable int productId, @RequestBody ProductDto productDto) throws Exception {
	Optional<Category> optionalCategory= categoryRepo.findById(productDto.getCateogry_id());
	
	if(!optionalCategory.isPresent()) {
		return	new ResponseEntity<ApiResponse>(new ApiResponse(false, "ERROR"), HttpStatus.BAD_REQUEST);
		//return	new ResponseEntity<ApiResponse>(new ApiResponse(false, "Created New Cateogry"));
	}else {
	productService.updateProduct(productDto ,productId);
	return	new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.OK);
}

}}
