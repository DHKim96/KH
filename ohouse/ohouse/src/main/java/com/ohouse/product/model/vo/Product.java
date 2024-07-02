package com.ohouse.product.model.vo;

import java.sql.Date;

public class Product{
	private int productId;
	private String productName;
	private String productPrice;
	private String productSales;
	private String stock;
	private String deliveryDate;
	private int sale;
	private String productThumbnail;
	private String productContent;
	private Date productCreateTime;
	private Date productModifyTime;
	private String companyName;
	private int membersNo;
	private int productDeliveryPrice;
	private int productCategory;
	private String productStatus;
	private int ratingAvg;
	private int reviewCount;
	
	public Product() {}
	
	public Product(int productId, String productName, String productPrice, String productSales, String stock,
			String deliveryDate, int sale, String productThumbnail, String productContent, Date productCreateTime,
			Date productModifyTime, String companyName, int membersNo, int productDeliveryPrice, int productCategory,
			String productStatus, int ratingAvg, int reviewCount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productSales = productSales;
		this.stock = stock;
		this.deliveryDate = deliveryDate;
		this.sale = sale;
		this.productThumbnail = productThumbnail;
		this.productContent = productContent;
		this.productCreateTime = productCreateTime;
		this.productModifyTime = productModifyTime;
		this.companyName = companyName;
		this.membersNo = membersNo;
		this.productDeliveryPrice = productDeliveryPrice;
		this.productCategory = productCategory;
		this.productStatus = productStatus;
		this.ratingAvg = ratingAvg;
		this.reviewCount = reviewCount;
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductSales() {
		return productSales;
	}

	public void setProductSales(String productSales) {
		this.productSales = productSales;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public String getProductThumbnail() {
		return productThumbnail;
	}

	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public Date getProductCreateTime() {
		return productCreateTime;
	}

	public void setProductCreateTime(Date productCreateTime) {
		this.productCreateTime = productCreateTime;
	}

	public Date getProductModifyTime() {
		return productModifyTime;
	}

	public void setProductModifyTime(Date productModifyTime) {
		this.productModifyTime = productModifyTime;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getProductDeliveryPrice() {
		return productDeliveryPrice;
	}

	public void setProductDeliveryPrice(int productDeliveryPrice) {
		this.productDeliveryPrice = productDeliveryPrice;
	}

	public int getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public int getRatingAvg() {
		return ratingAvg;
	}

	public void setRatingAvg(int ratingAvg) {
		this.ratingAvg = ratingAvg;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getMembersNo() {
		return membersNo;
	}


	public void setMembersNo(int membersNo) {
		this.membersNo = membersNo;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productSales=" + productSales + ", stock=" + stock + ", deliveryDate=" + deliveryDate + ", sale="
				+ sale + ", productThumbnail=" + productThumbnail + ", productContent=" + productContent
				+ ", productCreateTime=" + productCreateTime + ", productModifyTime=" + productModifyTime
				+ ", companyName=" + companyName + ", membersNo=" + membersNo + ", productDeliveryPrice="
				+ productDeliveryPrice + ", productCategory=" + productCategory + ", productStatus=" + productStatus
				+ ", ratingAvg=" + ratingAvg + ", reviewCount=" + reviewCount + "]";
	}

	
	
	
	
}

	