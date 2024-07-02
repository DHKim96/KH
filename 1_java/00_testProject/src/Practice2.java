import java.util.Scanner;
public class Practice2 {
	/*
	 * 키보드로 정수 두 개를 입력받아 두 수의 합, 차, 곱, 나누기한 몫을 출력하세요.
	 */
	public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	int num1, num2;
	
	System.out.print("첫 번째 정수를 입력하세요 : ");
	num1 = scan.nextInt();
	scan.nextLine();
	
	System.out.print("두 번째 정수를 입력하세요 : ");
	num2 = scan.nextInt();
	scan.nextLine();

	System.out.println("더하기 결과 : " + (num1 + num2) + "입니다.");
	System.out.println("빼기 결과 : " + (num1 - num2) + "입니다.");
	System.out.println("곱하기 결과 : " + (num1 * num2) + "입니다.");
	System.out.println("나누기 결과 : " + (num1 / num2) + "입니다.");
	
	scan.close();
	}
}
