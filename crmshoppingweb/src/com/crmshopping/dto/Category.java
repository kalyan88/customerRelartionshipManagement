package com.crmshopping.dto;

public class Category {
	private String categoryId;

	private String categoryName;

	private String superCategoryId;

	private String superCategoryName;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSuperCategoryId() {
		return superCategoryId;
	}

	public void setSuperCategoryId(String superCategoryId) {
		this.superCategoryId = superCategoryId;
	}

	public String getSuperCategoryName() {
		return superCategoryName;
	}

	public void setSuperCategoryName(String superCategoryName) {
		this.superCategoryName = superCategoryName;
	}
}