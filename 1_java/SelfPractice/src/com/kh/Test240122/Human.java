package com.kh.Test240122;

public class Human {
	String name;
	int money;
	static int count=0;
	
	public Human(String name, int money) {
		this.money = money;
		this.name = name;
		this.count++;
	}
	
	//buy라는 메소드 작성
	//TV객체를 넘겨받아 구매가 가능하다면 구매가 가능합니다.
	//money가 부족하다면 예산초과입니다 출력
	
	public void buy(TV tv) { 
		if (tv.getPrice() > this.money) {
			System.out.println("예산초과입니다.");
		} else {
			System.out.println("구매가 가능합니다.");
		}
	}
}
