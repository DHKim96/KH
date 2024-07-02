package com.kh.override;

public class CircleController {
	Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		double area = Math.PI * c.getRadius() * c.getRadius();
		return "면적 : " + c.toString() + " / " + area; 
	}
	
	public String calcCircum(int x, int y, int radius) {
		c.setX(x);
		c.setY(y);
		c.setRadius(radius);
		double perimeter = Math.PI * c.getRadius() * 2;
		return "둘레 : " + c.toString() + " / " + perimeter;
	}
}
