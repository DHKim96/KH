package com.kh.polymorphism02;

public class Parent {
	private int x;
	private int y;
	
	
	public Parent() {
		super();
	}

	public Parent(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Parent [x=" + x + ", y=" + y + "]";
	}
	
	public void printParent() {
		System.out.println("나는 부모객체야");
	}
}
