package com.ecommerce.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Category;
import com.ecommerce.ecommerce.repository.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepo categoryRepo;
	
	public void createCateogry(Category category) {
		categoryRepo.save(category);
	}
	
	public List<Category>getCategory() {
	return	categoryRepo.findAll();
		
		
	}

	public void updateCategory(int categoryId , Category updCategory) {
		Category category = categoryRepo.getById(categoryId);
		category.setCateogryName(updCategory.getCateogryName());
		category.setCategoryDescription(updCategory.getCategoryDescription());
		category.setCategoryUrl(updCategory.getCategoryUrl());
		categoryRepo.save(category);
		
	}

	public boolean findById(int id) {
		// TODO Auto-generated method stub
		return categoryRepo.findById(id).isPresent();
	}

}
