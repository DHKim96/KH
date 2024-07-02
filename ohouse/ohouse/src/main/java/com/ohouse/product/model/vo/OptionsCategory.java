package com.ohouse.product.model.vo;

public class OptionsCategory {
	private int optionsNo;
	private int productOptionsId;
	private String optionsCategory;
	
	public OptionsCategory() {}

	public OptionsCategory(int optionsNo, int productOptionsId, String optionsCategory) {
		super();
		this.optionsNo = optionsNo;
		this.productOptionsId = productOptionsId;
		this.optionsCategory = optionsCategory;
	}

	public int getOptionsNo() {
		return optionsNo;
	}

	public void setOptionsNo(int optionsNo) {
		this.optionsNo = optionsNo;
	}

	public int getProductOptionsId() {
		return productOptionsId;
	}

	public void setProductOptionsId(int productOptionsId) {
		this.productOptionsId = productOptionsId;
	}

	public String getOptionsCategory() {
		return optionsCategory;
	}

	public void setOptionsCategory(String optionsCategory) {
		this.optionsCategory = optionsCategory;
	}

	@Override
	public String toString() {
		return "optionsCategory [optionsNo=" + optionsNo + ", productOptionsId=" + productOptionsId
				+ ", optionsCategory=" + optionsCategory + "]";
	}
	
	
}
