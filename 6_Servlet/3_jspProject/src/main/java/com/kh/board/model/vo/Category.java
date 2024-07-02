package com.kh.board.model.vo;

public class Category {
	private int categoryNo;
	private String CategoryName;
	
	public Category() {
		super();
	}

	public Category(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		CategoryName = categoryName;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", CategoryName=" + CategoryName + "]";
	}
	
	
	
}
