package com.kh.Interface01;

public class Dog implements Animal, Baby{

	public void move() {
		System.out.println("촐랑촐랑 뜁니다.");
	}

	public void eat() {
		System.out.println("촵촵촵 먹습니다. ");
	}

	public void makesound() {
		System.out.println("멍멍 소리를 냅니다.");
	}
	
}
