package com.kh.Interface02;

public class Rectangle implements Shape{
	
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double calcArea() {
		return this.width * this.height;
	}
	
}
