package com.kh.inherit02;

public class SmartPhone extends Product{
	private String mobileAgency; //통신사

	public SmartPhone(String brand, String pCode, String pName, int price, String mobileAgency) {
		super(brand, pCode, pName, price);
		this.mobileAgency = mobileAgency;
	}

	public String getMobileAgency() {
		return mobileAgency;
	}

	public void setMobileAgency(String mobileAgency) {
		this.mobileAgency = mobileAgency;
	}

	@Override
	public String information() {
		return super.information() + ", mobileAgency: " + this.mobileAgency;
	}
		
}
