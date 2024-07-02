package com.kh.Test240122;

public class TV {
	//필드
	String brand;
	int year;
	public int inch;
	private int price;
	
	//생성자
	public TV(String brand, int year, int inch, int price) {
		this.brand = brand;
		this.year = year;
		this.inch = inch;
		this.price = price;
	}
	
	//메소드
	
	public void show() {
		System.out.println(this.brand + "에서 만든 "+ this.year 
				+ "년형 "+ this.inch +"인치 TV : " + this.price);
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
}
