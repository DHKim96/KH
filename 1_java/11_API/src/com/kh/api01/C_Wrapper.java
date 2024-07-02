package com.kh.api01;

public class C_Wrapper {

	/*
	 *  * Wrapper 클래스
	 *  => 기본 자료형을 객체로 포장해줄 수 있는 클래스
	 *  
	 *  	기본 자료형	<-->	Wrapper클래스
	 *  	boolean				Boolean
	 *  	char				Character
	 *  	byte				Byte
	 *  	short				Short
	 *  	int					Integer
	 *  	long				Long
	 *  	float				Float
	 *  	double				Double
	 *  
	 *  => 기본자료형을 객체로 표현해야 할 경우
	 * 		메소드 호출해야될 때
	 *  	=>	메소드의 매개변수로 기본자료형이 아닌 객체타입만 요구될 때
	 *  	다형성을 적용시키고 싶을 때	
	 */
	
	public void method01() {
		//Boxing : 기본자료형 => Wrapper클래스 자료형
		int num1 = 10;
		int num2 = 15;
		
//		System.out.println(num1.equals(num2)); // 안됨
		
		// 1. 객체 생성 구문을 통한 방법
		Integer i1 = new Integer(num1); // num1 => i1
		Integer i2 = new Integer(num2); // num2 => i2
		
		System.out.println(i1);
		System.out.println(i2);
		
		System.out.println(i1 == i2); //false
		System.out.println(i1.equals(i2));
		System.out.println(i1.compareTo(i2)); 
		// 두 값을 비교해서 호출하는 쪽이 크면 1 반환, 뒤쪽이 크면 -1 반환, 같으면 0 반환
	
		// 2. 객체 생성하지 않고 곧바로 대입하는 방법(AutoBoxing)
		Integer i3 = num1;
		System.out.println(i3);
		
		/* 
		 * 객체 생성을 통해서 반드시 변환해야하는 경우
		 * 	문자열을 Interger타입으로 변환하고 싶을 대
		 */
		Integer i4 = new Integer("123"); // 문자열 "123"을 숫자로 바꿈
		System.out.println(i4);
		
		
		//UnBoxing : Wrapper클래스 자료형 => 기본자료형
		
		// 1. 해당 그 Wrapper클래스에서 제공하는 xxxValue() 메소드를 통해서 가능
		int num3 = i3.intValue(); // i3의 정수값이 -> num3에 대입
		int num4 = i4.intValue();
		
		// 2. 메소드 사용하지 않고 바로 대입하는 방법(AutoUnBoxing)
		int num5 = i1;
		
		System.out.println("=============================");
		
		// 기본자료형 <--> String 변환
		String str1 = "10";
		String str2 = "15.5";
		
		System.out.println(str1 + str2);// "1015.5" 즉 문자열로 작업이 됨
		
		// 1. String	 => 	기본자료형
		//		"10"	 => 	10
		//		"15.5"	 =>		15.5
		// 해당Wrapper클래스.parsexxx() 사용
		int i = Integer.parseInt(str1); // parsing : 문장의 분석을 뜻함
		double d = Double.parseDouble(str2);
		System.out.println(i + d);
		
		// 2. 기본자료형		=>		String
		//		10			=>		"10"
		//		15.5		=>		"15.5"
		String strI = String.valueOf(i);
		String strD = String.valueOf(d); 
	}
}
