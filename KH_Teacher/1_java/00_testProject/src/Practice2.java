import java.util.Scanner;

public class Practice2 {
	/*
	 * 키보드로 정수 두개를 입력받아 두 수의 합, 차, 곱, 나누기한 몫을 출력하세요.
	 */
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		int num1 = s.nextInt();
		s.nextLine();
		
		System.out.print("두 번째 정수 : ");
		int num2 = s.nextInt();
		s.nextLine();
		
		System.out.println("더하기 결과 : " + (num1 + num2));
		System.out.println("빼기 결과 : " + (num1 - num2));
		System.out.println("곱하기 결과 : " + (num1 * num2));
		System.out.println("나누기 결과 : " + (num1 / num2));
	}
}
