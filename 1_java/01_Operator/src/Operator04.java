import java.util.Scanner;
public class Operator04 {
	/*
	 * 비교연산자/관계연산자(이항연산자)
	 * 두 값을 비교하는 연산자
	 * 비교연산자는 조건을 만족하면 true(참), 만족하지 않으면 false(거짓)을 반환
	 * 즉, 비교연산의 결과는 '논리값'!!
	 * 
	 * 대소비교연산자 : < > <= >=
	 * 동등비교 연산자 : == !=
	 * 
	 * String(문자열)은 단순하게 ==로 동등비교할 수 없음.
	 * 참조변수이기 때문. 
	 * String을 동등비교할 때,
	 * st1 == str2 해버리면 객체의 내용이 아니라 객체에 담긴 참조변수의 주소값을 비교하기 때문에
	 * 문자열1.equals(문자열2); equals라는 메소드를 사용해야 함.
	 */
	
	public static void main(String[] args) {
//		int a = 10;
//		int b = 25;
//		
//		System.out.println("a == b : " + ( a == b ) );
//		System.out.println("a <= b : " + ( a <= b ) );
//		
//		boolean result = ( a > b);
//		System.out.println("result : " + result );
//		
//		//산술연산 + 비교연산
//		System.out.println(( a * 2) > ( b / 5 ) );
//		
//		System.out.println("a가 짝수인가: " + ( a % 2 == 0 ) );
//		System.out.println("a가 홀수인가: " + ( a % 2 != 0 ) );
//		System.out.println("a가 홀수인가: " + !( a % 2 == 0 ) );
		
		//두 수를 입력 받아 어떤 숫자가 더 큰지를 출력하는 프로그램
		//출력 :
		// 첫 번째 정수 : 
		// 두 번째 정수 : 
		// 첫 번째가 두 번째보다 큽니다 : (true/false)
		// 첫 번째 정수는 짝수입니다 : (true/false)
		
		Scanner scan = new Scanner(System.in);
		int a;
		int b;
		
		System.out.print("첫 번째 정수 : ");
		a = scan.nextInt();
		scan.nextLine();
		
		System.out.print("두 번째 정수 : ");
		b = scan.nextInt();
		scan.nextLine();
		
		System.out.println("첫 번째가 두 번째보다 큽니다 : " + ( a > b));
		
		System.out.println("첫 번째 정수는 짝수입니다 : " + ( ( a % 2 ) == 0 ) );
		
		scan.close();
		
		//특이케이스: 문자와 숫자간의 대소비교 가능
		System.out.println('A' > 60);
		System.out.println('A' > 70);
		// 'A' ~ 'Z' 65 ~ 90까지의 숫자로 나열되어 있다.
		
		//String(문자열)을 비교할 땐
		//비교대상1.equals(비교대상2);
		
		
		
		
		
		
	}
}
