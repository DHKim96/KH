package test6;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int data = sc.nextInt();
		
		try {
			System.out.println("결과값 : " + new Calculator().getSum(data));
		} catch (InvalidException e) {
			e.printStackTrace();
			// 메세지만 출력하려면
			System.out.println(e.getMessage()); 
		}
		
	}

}
