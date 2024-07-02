package com.kh.api01;

public class A_Math {
	
	public void method01() {
		// java.lang.Math
		
		//상수필드
		System.out.println("파이 : " + Math.PI);
		
		//절대값을 알고자 할 때 : abs
		int num1 = -10;
		System.out.println("절대값 : " + Math.abs(num1));
		
		//올림 : ceil
		double num2 = 4.449;
		System.out.println("올림 : " + Math.ceil(num2));
		
		//반올림 : round
		System.out.println("반올림 : " + Math.round(num2));
		
		//버림 : floor
		System.out.println("버림 : " + Math.floor(num2));
		
		//가장 가까운 정수값을 알아낸 후 실수형 반환 : rint
		System.out.println("가장 가까운 정수값 : " + Math.rint(num2));
		
		// 제곱근(루트) : sqrt
		System.out.println("4의 제곱근 : " + Math.sqrt(4));
		
		//제곱 : pow
		System.out.println("2의 10제곱 : " + Math.pow(3, 122));
		
		//Math m = new Math();
		/*
		 * * Math 특징
		 * - 모든 필드 상수필드, 모든 메소드 static 메소드(전부다 static이다!)
		 * - 생성자는 private으로 되어있다 => 생성을 못하게 막아뒀다.
		 * 
		 * ** 한번만 메모리 영역에 올려놓고 재사용하는 개념 => 싱글톤 패턴
		 */
		
	}
}
