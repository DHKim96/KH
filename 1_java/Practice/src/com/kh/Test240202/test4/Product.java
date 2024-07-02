package com.kh.Test240202.test4;

public class Product {
	private String name;
	private int price;
	private int quantity;
	
	public Product() {
		super();
	}
	public Product(String name, int price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String information() {
		return "상품명 : " + this.getName() + "\n가격 : " + 
				this.getPrice() + " 원\n수량 : " + this.quantity + " 개";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
