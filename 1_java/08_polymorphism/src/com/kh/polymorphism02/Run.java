package com.kh.polymorphism02;

public class Run {
	public static void main(String[] args) {
		
		System.out.println("1. 부모 타입 레퍼런스(참조변수)로 부모 객체를 다루는 경우");
		Parent p1 = new Parent();
		p1.printParent();
		// p1 참조변수로 Parent에만 접근이 가능
		
		System.out.println("2. 자식 타입 레퍼런스로 자식 객체를 다루는 경우");
		Child1 c1 = new Child1();
		c1.printParent();
		c1.printChild1();
		// 첫 번째 메서드는 자동으로 ((Parent)c1).printParent();가 된 것
		// c1 참조변수로 Child1, Parent 둘 다 접근 가능
		// Parent 접근 시 자동으로 형변환 된 채로 진행(업캐스팅)
		
		System.out.println("3. 부모 타입 레퍼런스로 자식 객체를 다루는 경우(다형성)");
		Parent p2 = /*(Parent)*/new Child1(); // 자동 형 변환 됨(upcasting)
		p2.printParent();
		((Child1)p2).printChild1(); // 강제 형 변환 시 호출 가능 (downcasting)
		// p2 레퍼런스로 지금 당장은 Parent에만 접근 가능하나
		// Child1에 접근하고자 한다면 강제 형 변환 통해 가능
		
		/*
		 * "상속 구조"의 클래스들 간에 형 변환 가능
		 * 
		 * 1. Upcasting
		 * 		:자식 타입 -> 부모 타입으로 형 변환
		 * 		 자동 형 변환 진행됨
		 * 		 ex) 자식.부모메소드();
		 * 			 부모 = 자식객체;
		 * 
		 * 2. Downcasting
		 * 		:부모 타입 -> 자식 타입으로 형 변환
		 * 		 강제 형 변환 해야됨
		 * 		 ex) ((자식)부모).자식메소드();
		 */
		
		// * 다형성의 정의
		//		부모 타입으로부터 파생된 여러가지 타입의 자식 객체들을 부모클래스 타입 하나로 다룰 수 있는 기술
		
		// * 다형성을 쓰는 목적(장점)
		
		// 		다형성 사용전
		//		Child1 객체 2개 Child2 객체 2개 관리해야할 때
		Child1[] arr1 = new Child1[2];
		arr1[0] = new Child1(1, 2, 3);
		arr1[1] = new Child1(4, 5, 6);
		
		Child2[] arr2 = new Child2[2];
		arr2[0] = new Child2(1, 2, 3);
		arr2[1] = new Child2(4, 5, 6);
		
		// ============================================
		//		다형성 사용 후
		Parent[] arr = new Parent[4];
		arr[0] = new Child1(1, 2, 3);
		arr[1] = new Child2(1, 2, 3);
		arr[2] = new Child1(4, 5, 6);
		arr[3] = new Child2(4, 5, 6);
		//		하나의 부모 타입만으로 여러 자식 객체들을 받을 수 있음 => 편리함, 코드 길이 감소
		
		((Child1)arr[0]).printChild1();
		((Child2)arr[1]).printChild2();
		((Child1)arr[2]).printChild1();
		((Child2)arr[3]).printChild2();
		
		/*
		 * instanceof 연산자 => 연산 결과 true/false로 반환
		 * 현재 레퍼런스가 실질적으로 어떤 클래스 타입을 참조하는지 확인할 때 사용
		 */
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] instanceof Child1) { // 해당 참조변수가 실제 Child1을 참조하고 있니?(arr[i]가 Child1 메모리 공간 사용 가능해?)
				((Child1)arr[i]).printChild1();
			}
			else {
				((Child2)arr[i]).printChild2();
			}
		}
	}
}
