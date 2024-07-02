package com.ohouse.product.model.vo;

public class OptionsName {
	private int optionsNameNo;
	private int optionsCategoryNo;
	private String optionsName;
	private int price;
	private int stock;
	
	public OptionsName() {}

	public OptionsName(int optionsNameNo, int optionsCategoryNo, String optionsName, int price, int stock) {
		super();
		this.optionsNameNo = optionsNameNo;
		this.optionsCategoryNo = optionsCategoryNo;
		this.optionsName = optionsName;
		this.price = price;
		this.stock = stock;
	}

	public int getOptionsNameNo() {
		return optionsNameNo;
	}

	public void setOptionsNameNo(int optionsNameNo) {
		this.optionsNameNo = optionsNameNo;
	}

	public int getOptionsCategoryNo() {
		return optionsCategoryNo;
	}

	public void setOptionsCategoryNo(int optionsCategoryNo) {
		this.optionsCategoryNo = optionsCategoryNo;
	}

	public String getOptionsName() {
		return optionsName;
	}

	public void setOptionsName(String optionsName) {
		this.optionsName = optionsName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "optionsName [optionsNameNo=" + optionsNameNo + ", optionsCategoryNo=" + optionsCategoryNo
				+ ", optionsName=" + optionsName + ", price=" + price + ", stock=" + stock + "]";
	}
	
	
}
