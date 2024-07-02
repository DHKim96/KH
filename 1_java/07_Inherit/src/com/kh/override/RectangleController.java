package com.kh.override;

public class RectangleController {
	private Rectangle r = new Rectangle();
	public String calcArea(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setHeight(width);
		int area = r.getWidth() * r.getWidth();
		return "면적 : " + r.toString() + " / " + area;//to.String 이용
	}
	
	public String calcPerimeter(int x, int y, int height, int width) {
		r.setX(x);
		r.setY(y);
		r.setHeight(height);
		r.setWidth(width);
		int perimeter = 2 * (r.getWidth() + r.getHeight()); 
		return "둘레 : " + r.toString() + " / " + perimeter;
	}
}
