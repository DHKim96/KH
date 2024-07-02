package com.kh.test240124;

public class RectangleController {
	private Rectangle r = new Rectangle();
	
	public String calcArea(int x, int y, int height, int width) {
		r.setY(y);
		r.setX(x);
		r.setHeight(height);
		r.setWidth(width);
		
		int area = r.getWidth() * r.getHeight();
		return "면적 : " + r.toString() + "/" + area;
		
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r.setY(y);
		r.setX(x);
		r.setHeight(height);
		r.setWidth(width);
		
		int perimeter = 2 * (r.getHeight() + r.getWidth());
		return "둘레 : " + r.toString() + "/" + perimeter;
	}
}
