package com.kh.Inherit02;

public class Tv extends Product{
	private int inch;  // 크기

	public Tv(String brand, String pCode, String pName, int price, int inch) {
		super(brand, pCode, pName, price);
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String information() {
		return super.information() + ", inch : " + inch;
	}
	//super. 으로 부모에 접근이 가능
	// 오버라이딩 : 부모클래스에 있는 메소드를 자식 클래스에서 재정의하는 것
	
	
}
