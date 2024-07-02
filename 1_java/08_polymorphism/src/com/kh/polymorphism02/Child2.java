package com.kh.polymorphism02;

public class Child2 extends Parent{
	private int n;
	
	public Child2() {
		super();
	}

	public Child2(int x, int y, int n) {
		super(x, y);
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return super.toString() + "Child2 [n=" + n + "]";
	}
	
	public void printChild2() {
		System.out.println("나는 둘째 자식 객체야");
	}
}
