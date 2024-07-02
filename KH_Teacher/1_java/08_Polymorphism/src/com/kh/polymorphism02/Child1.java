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
		return "Child1 [z=" + z + "]";
	}
	
	public void printChild1() {
		System.out.println("나는 1번 자식객체야");
	}
	
}
