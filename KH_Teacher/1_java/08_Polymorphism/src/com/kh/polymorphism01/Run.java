package com.kh.polymorphism01;

public class Run {
	public static void main(String[] args) {
		/*
		 *      클래스 참조변수      =       new 클래스 생성자;
		 * (부모클래스가 올 수 있다)   /    (자식클래스라면 위치할 수 있다)
		 * 실제로 어디까지 접근이 가능한가/   (실제로 어떤 형태로 메모리가 생성이 되는가)
		 */
	   Cake c1 = new StrawberryCheeseCake();
	   CheeseCake c2 = new StrawberryCheeseCake();
	   StrawberryCheeseCake c3 = new StrawberryCheeseCake();
	   
	   
	   c1.yummy();   
//	   c2.yummy();
	}
}
