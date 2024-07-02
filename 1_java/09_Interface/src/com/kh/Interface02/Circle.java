package com.kh.Interface02;

public class Circle implements Shape{
	
	private double radius;
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public double calcArea() {
		return Math.PI * this.radius * this.radius ;
	}
}
