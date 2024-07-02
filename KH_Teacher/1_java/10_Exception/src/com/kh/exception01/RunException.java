package com.kh.exception01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RunException {
	Scanner sc = new Scanner(System.in);
/*
 *  RuntimeException
 *  - 프로그램 실행시 발생되는 예외들
 *  
 *  * RuntimeException후손들
 *  - IndexOutOfBoundsException : 부적절한 인덱스를 가지고 접근시 발생되는 예외
 *  - NullPointerException : 참조변수가 null로 초기화된 상태에서 해당 참조변수에 특정 변수나 메소드로 접근을 시도하면 발생되는 예외
 *	- ClassCastException : 허용할 수 없는 형변환이 진행될때 발생되는 예외
 *  - ArithmeticException : 나누기 연산시 0으로 나눠질 때 발생되는 예외
 *  
 *  => RuntimeException 관련된 예외는 충분히 예측가능한 상황이 있다.
 *  
 */
	
	public void method01() {
		/* ArithmeticException : 나누기 연산시 0으로 나눠질 때 발생되는 예외 */
		
		int num1, num2;
		System.out.print("정수1 : ");
		num1 = sc.nextInt();
		
		System.out.print("정수2 : ");
		num2 = sc.nextInt();
		
		//int result = num1 / num2; // 사용자가 두번째 정수를 0으로 입력하는 순간 0으로 나누기가 진행되면서 예외 발생 => 프로그램 종료
		//애초에 예외 자체가 발생이 안되게끔 if문으로 조건 검사 -> 예외처리 아님!
//		int result = 0;
//		if (num2 != 0) {
//			result = num1 / num2;
//		}
//		System.out.println("나누기 결과 : " + result);
		
		/*
		 * 예외처리 : "예외"가 "발생"했을 경우에 대해서 "처리"하는 방법을 "예외처리"
		 * try {
		 * 		예외가 발생할 수 있는 구문;
		 * } catch(발생될 예외 클래스의 매개변수){
		 * 		해당 예외가 발생됐을 경우 실행할 구문;
		 * }
		 */
		try {
			int result = num1 / num2;
			System.out.println("나누기 결과 : " + result);
		} catch(ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
			e.printStackTrace(); // 강제로 오류난 이력보고자 할때 실행하는 구문
		}
		
		System.out.println("프로그램을 종료합니다.");	
	}
	
	public void method02(){
		// ArrayIndexOutOfBoundsException : 배열에 부적절한 인덱스로 제시하면서 접근했을 때 발생하는 에러
		// NegativeArraySizeException : 배열의 할당 과정에서 크기를 음수로 지정하면 발생하는 예외
		
		System.out.print("배열의 크기");
		int size = sc.nextInt();
		
		try {
			int[] arr = new int[size];
			System.out.println("100번째 인덱스값 : " + arr[100]);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("부적절한 인덱스로 접근했습니다.");
		} catch(NegativeArraySizeException e) {
			System.out.println("배열의 크기를 음수로 지정할 수 없습니다.");
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
	public void method03() throws IOException {
		/*
		 * CheckedException : 반드시 예외처리를 해야되는 예외들
		 * => 조건문을 미리 제시할 수 없음(왜? 예측이 불가한 곳에서 문제가 발생하기 때문에 예외처리가 필수이다.)
		 * => 외부 매개체와 입출력이 일어날 때 발생된다.
		 */
		
		//Scanner와 같이 키보드로 값을 입력받을 수 있는 객체(단, 문자열로 읽어들여인다.)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. try~catch문 : 여기 이자리에서 곧바로 예외를 처리하겠다.
		// try{} : 예외가 발생할 가능성이 있는 코드를 작성
		// catch(발생될 예외클래스 매개변수) {}: try구문내에서 예외가 발생했을 경우 어떻게 처리할지를 정의 
		//
		/*
		try {
			String str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		//2. throws : 지금 이자리에서 예외를 처리하지않고 현재 이 메소드를 호출한 곳으로 예외처리를 떠넘기겠다.
		String str = br.readLine();
	}
	
	public void method04() throws IOException {
		method05();
	}
	
	public void method05() throws IOException {
		method06();
	}
	
	public void method06() throws IOException {
		
		throw new IOException();
		
	}
}
