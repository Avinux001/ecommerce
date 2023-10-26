package com.ecommerce.ecommerce.dto;

import javax.validation.constraints.NotBlank;

public class ProductDto {

	//for create- optional
	//for update - mandatory
	private Integer product_id;

	private @NotBlank String name;
	private @NotBlank String imageURL;
	private @NotBlank double price;
	private @NotBlank String description;
	private @NotBlank Integer cateogry_id;
	
	
	public Integer getCateogry_id() {
		return cateogry_id;
	}

	public void setCateogry_id(Integer cateogry_id) {
		this.cateogry_id = cateogry_id;
	}

	public ProductDto() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	
}
