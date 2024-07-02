package com.kh.Inherit02;

public class Desktop extends Product {
	private boolean allinOne; // 일체형인지 여부

	public Desktop(String brand, String pCode, String pName, int price, boolean allinOne) {
		super(brand, pCode, pName, price);
		this.allinOne = allinOne;
	}

	public boolean isAllinOne() {
		return allinOne;
	}

	public void setAllinOne(boolean allinOne) {
		this.allinOne = allinOne;
	}

	@Override
	public String information() {
		return super.information() + ", allinOne : " + allinOne;
	}
	
	
	
}
