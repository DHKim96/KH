 //import java.util.Scanner;
public class Operator05 {
	/*
	 * 논리연산자
	 * 두 개의 논리값을 연산해주는 연산자
	 * 논리연산한 결과도 논리값이다.
	 * 
	 * 논리값 && 논리값 : 왼쪽, 오른쪽 두 논리값이 모두 true 일 때, 결과값이 true 이다.
	 * 논리값 || 논리값 : 왼쪽, 오른쪽 둘 중에 하나라도 true 값이 있을 경우, true 이다.
	 *  
	 * && : 두 개의 조건이 모두 true(AND == ~이고, 그리고, ~이면서, 뿐만아니라)
	 * true && true == true
	 * true && false == false
	 * false && true == false
	 * false && false == false
	 * => && 연산자를 기준으로 앞의 결과가 false 일 경우, 뒤의 조건은 굳이 실행하지 않는다.
	 * 
	 * || : 두 개의 조건 중 하나라도 true 이면 결과값이 true 이다. (OR == 또는, ~이거나)
	 * true || true == true
	 * true || false == true 
	 * false || true == true
	 * false || false == false
	 * => || 연산자를 기준으로 앞의 결과가 true 일 경우, 뒤의 조건은 굳이 실행하지 않는다.
	 */
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		//사용자에게 숫자를 입력 받아 해당 숫자가 1 ~ 100 사이의 값인지 확인하는 프로그램
//
//		System.out.print("정수 하나 입력 : ");
//		int num1 = sc.nextInt();
//	
//		boolean result = (0 < num1) && (num1 < 101);
//		
//		System.out.println("사용자가 입력한 값이 1 이상 100 이하입니다 : " + result);
//		
//		/*
//		 * && : 왼쪽, 오른쪽 모든 연산의 결과가 true
//		 * 		하나라도 false 가 나올시 false
//		 */
		
		//사용자에게 알파벳 하나를 입력 받아 대소문자를 확인하는 프로그램
		//출력
		//문자 하나 입력 : 
		//사용자가 입력한 값이 대문자 입니다 : (true/false)
		// 'A' = 65 / 'Z' = 90
		
//		System.out.print("문자 하나 입력 : ");
//		char ch = sc.next().charAt(0);
//		
//		boolean result = ( ch >= 65 ) && ( ch <= 90);
//		// (alphabet >= 'A') && (alphabet <= 'Z') 도 가능. 연산 처리하면서 int형으로 변환해서 계산
//	 	
//		boolean res1 = (ch >= 65) && (ch <= 90);
//		
//		boolean res2 
//		
//		boolean res3
//		
		
//		
//		System.out.println("사용자가 입력한 값이 대문자입니다 : " + result);
//		sc.close();
//		
		
		
		
		
		
		//사용자에게 성병을 입력 받은 후 여자인지 확인(* 소문자 f, 대문자 F 모두 가능)
		// 성별(M/F) : 
		// 사용자가 여자입니까 : (true/false)
		
//		System.out.print("성별(M/F) : ");
//		char g = sc.next().charAt(0);
//		
//		boolean result = ( g == 'f' ) || ( g == 'F' ); //'=' , '==' 주의 
//		
//		System.out.println("사용자가 여자입니까 : " + result);
		
//		int num = 10;
//		
//		boolean result1 = ( num < 5 ) && ( ++num > 0 ); // 앞에의 연산 결과가 거짓일 때
//		
//		System.out.println("result1 : " + result1);
//		System.out.println("&& 연산 후의 num : " + num);
//		
//		int num2 = 10;
//	//	boolean result2 = true || ( ++num2 > 0 ); // 앞이 참이기때문에 뒤를 처리할 필요가 없음
//		System.out.println("|| 연산 후의 num2 : " + num2);
//		
//		sc.close();
	}

}
