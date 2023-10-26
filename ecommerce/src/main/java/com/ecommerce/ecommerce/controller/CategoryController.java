package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.ecommerce.config.ApiResponse;
import com.ecommerce.ecommerce.model.Category;
import com.ecommerce.ecommerce.service.CategoryService;

@RestController("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;

	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> CreateCategory(@RequestBody Category category) {
		categoryService.createCateogry(category);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Created New Cateogry"), HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public List<Category> GetCategory() {
		return categoryService.getCategory();
	}
		
	@PostMapping("/update/{categoryId}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int id , @RequestBody Category category) {
		System.out.println("Category ID : "+ id);
		if(!categoryService.findById(id)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category Not Found"),HttpStatus.NOT_FOUND);

		}
		categoryService.updateCategory(id , category );
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Category has been updated"),HttpStatus.OK );
	}
	
}
