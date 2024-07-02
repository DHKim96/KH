package com.kh.interface02;

public class Circle implements Shape{
	private double radius;
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI * this.radius * this.radius;
	}
}
