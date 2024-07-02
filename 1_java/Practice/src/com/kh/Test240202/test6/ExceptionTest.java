package com.kh.Test240202.test6;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculator cal = new Calculator();
		
		System.out.print("정수 입력 : ");
		int data = sc.nextInt();
		
		try {
			System.out.println("결과값 : " + cal.getSum(data));
		} catch (InvalidException e) {
			System.out.println(e.getMessage());
		}

	}

}
