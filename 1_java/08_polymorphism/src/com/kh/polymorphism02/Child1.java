package com.kh.polymorphism02;

public class Child1 extends Parent {
	private int z;

	public Child1() {
		super();
	}

	public Child1(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public String toString() {
		return super.toString() + "Child1 [z=" + z + "]";
	}
	
	public void printChild1() {
		System.out.println("나는 첫째 자식 객체야");
	}
	
	
}
