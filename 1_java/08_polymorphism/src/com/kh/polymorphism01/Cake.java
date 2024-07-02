package com.kh.polymorphism01;

class Cake {
	public void yummy() {
		System.out.println("yummy Cake");
	}
}

class CheeseCake extends Cake{
	public void yummy() { //Cake 의 yummy 를 오버라이딩
		super.yummy();
		System.out.println("yummy CheeseCake");
	}
}

class StrawberryCheeseCake extends CheeseCake{
	public void yummy() { // CheeseCake 의 yummy를 오버라이딩
		super.yummy(); // 인스턴스 내부에서 super. 을 통해 오버라이딩 되기 전 메소드 호출 가능
		System.out.println("yummy StrawbeeyCheeseCake");
	}
}
