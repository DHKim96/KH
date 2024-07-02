package com.kh.api01;

public class A_Math {
	public void method01() {
		// java.lang.Math
		
		// 상수필드
		System.out.println("파이 : " + Math.PI);
		
		// 절대값을 알고자 할 때 : abs
		int num1 = -10;
		System.out.println("절대값 : " + Math.abs(num1));
		
		//올림 : ceil
		double num2 = 4.349;
		System.out.println("올림 : " + Math.ceil(num2));
		
		//반올림 : round
		System.out.println("반올림 : " + Math.round(num2));
		
		//버림 : floor
		System.out.println("버림 : " + Math.floor(num2));
		
		//가장 가까운 정수값을 알아낸 후 실수형 반환 : rint
		System.out.println("가장 가까운 정수값 : " + Math.rint(num2));
		
		
		//제곱근(루트) : sqrt
		System.out.println("16의 제곱근 : " + Math.sqrt(16));
		
		//제곱 : pow
		System.out.println("2의 10제곱근 : " + Math.pow(2, 10));
		
//		Math m = new Math(); // private으로 접근 제한
		// Math 클래스의 변수나 메서드 모두 static
		/*
		 * * Math 특징
		 * 		모든 필드가 상수필드, 모든 메소드가 static 메소드(all of)
		 * 		생성자는 private 으로 되어있음 => 생성을 못하게 제한해놓음
		 * 		
		 * 	** 싱클톤 패턴
		 * 		한 번만 메모리 영역에 올려놓고 재사용하는 개념(Math 클래스 처럼)
		 */
	}
}
