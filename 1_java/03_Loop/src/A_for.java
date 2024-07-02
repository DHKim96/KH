import java.util.Scanner;
//import java.lang.Math;
public class A_for {
/*
 * <반복문>
 * 프로그램 흐름을 제어하는 제어문 중 하나
 * 어떤 실행코드를 반복적으로 수행시켜준다.
 * 
 * 크게 두 종류로 나뉨(for 문 / while 문(do-while 문) )
 * 
 *  * for문
 *  
 *  for(초기식;조건식;증감식){ //괄호 내의 식들은 반복 횟수를 지정하기 위해 제시하는 것들
 *  	반복적으로 실행시키고자 하는 구문
 *  }
 *  
 *  - 초기식 : 반복문이 수행될 때 "처음에 단 한 번만 실행하는 구문"
 *  		(보통 반복문 안에서 사용될 변수를 선언 및 초기화하는 구문)
 *  
 *  - 조건식 : "반복문이 수행될 조건"을 작성하는 구문
 *  		조건식이 true 일 경우 해당 구문을 실행
 *  		조건식이 false 가 되는 순간 반복을 멈추고 빠져나옴
 *  		(보통 초기식에 제시된 변수를 가지고 조건식을 정함)
 *  
 *  - 증감식 : 반복문을 제어하는 변수 값을 증감시키는 구문.
 *  		(보통 초기식에 제시된 변수를 가지고 증감연산자를 사용함)
 *  
 *  * for 문을 만나는 순간
 *  초기식 -> 조건식 검사 -> true 일 경우 실행구문 실행 -> 증감식 적용
 *  		조건식 검사 -> true 일 경우 실행구문 실행 -> 증감식 적용
 *  		...
 *  		조건식 검사 -> false 일 경우 실행구문 실행하지 않음, 반복문 탈출.
 *  
 *  tip. 알아둘 점
 *   for 문 안에 초기식, 조건식, 증감식 각각 생략 가능(단, ;은 반드시 입력)
 * 
 */
	public static void main(String[] args) {
		
		/*
		//"안녕하세요"를 다섯 번 출력하세요
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		
		for( int i = 0 ; i < 5 ; i++ ) { //i 값이 0~4까지 매번 1씩 증가하는 동안 반복 수행
			System.out.println("안녕하세요");
		}
		*/
		
		// 1 ~ 5 까지 순차적으로 출력하세요.(1 2 3 4 5)
//		for (int i = 1 ; i < 6 ; i++) {
//			System.out.print(i + " ");
//		}
//		
//		System.out.println("");
//		
//		// 5 ~ 1 까지 순차적으로 출력
//		for ( int i = 5 ; i > 0 ; i-- ) {
//			System.out.print(i + " ");
//		}
//		
//		System.out.println("");
//		
		// 정수 n을 입력받아 1부터 n까지 1씩 증가시키면서 출력하세요
//		Scanner sc = new Scanner(System.in);
//		System.out.print("정수 입력 : ");
//		int n = sc.nextInt();
//		sc.close();
		
//		for (int i = 1 ; i <= n ; i++ ) {
//			System.out.print(i + " ");
//		}
//		
//		System.out.println(" ");
		
		// 1 ~ 10 사이의 홀수만 출력하세요
//		for (int i = 1 ; i <= n ; i+=2 ) {
//			System.out.print(i + " ");
//		}
//		
//		System.out.println("");
		// 1 ~ 100 까지의 총 합계를 구하라
		/*
		 * int sum = 0
		 * sum += 1;
		 * sum += 2;
		 * ...
		 * sum += 10;
		 */
		// 규칙을 찾자! sum 변수에 누적해서 합산하는 것 반복적으로 진행됨
		// 단, 누적해서 더하고자 하는 값이 1에서부터 10까지 1씩 증가한다.
//		int sum = 0 ;
//		for ( int i = 0 ; i <= 100 ; i++ ) {
//			sum += i ;
//		}
//		System.out.println(sum);
		
		// 정수 n을 입력받아 1부터 n까지 1씩 증가하며 모든 수를 더해서 출력해라
		// "정수 입력 : 10"
		// "1부터 10까지의 합 : 55"
//		int sum = 0 ;
//		for ( int i = 0 ; i <= n ; i++ ) {
//			sum += i ;
//		}
//		System.out.println("1부터 10까지의 합 : " + sum);
//		
		/*
		 * java.lang.Math 클래스에서 제공하는 random 메소드 호출해서 매번 다른 값을 얻어낼 수 있다.
		 * 
		 * [사용법]
		 *  import java.lang.Math;
		 *  
		 * Math.random(); 호출시 => 0.0 ~ 0.9999999 사이( 0.0 <=  < 1.0 )의 랜덤값을 반환
		 * 
		 * int random = Math.random(); // 대입 값이 double 형이라 안됨.
		 * 
		 * int random = Math.random() * 10; 같은 이유로 안됨.
		 * 
		 * int random = (int)(Math.random() * 10 + 1) ; // 가능. 1 ~ 10 
		 * 
		 */
		
		// random한 숫자 n(정수. 1 ~ 10)을 생성해서 1 ~ n 까지 모두 더한 값을 출력하세요
		// random 수 : 
		// 1 ~ 5까지의 합 : 
		
//		int random = (int)(Math.random() * 10 + 1);
//		int sum = 0;
//		for (int i = 0 ; i <= random ; i++ ) {
//			sum += i ;
//		}
//		System.out.println("random 수 : " + random);
//		System.out.println("1 ~ " + random + "까지의 합 : " + sum);
//	
		//random(5~50)한 숫자 n을 생성해서 1부터 n까지의 숫자 중 짝수만 출력해라
		//random 수 : 10
		//2 4 6 8
		
//		int random;
//		random = (int)(Math.random() * 46 + 5);
//		System.out.println("random 수 : " + random);
//		for (int i = 2 ; i <= random ; i+=2 ) {
//			System.out.print(i + " ");
//		}
		
		/*
		String str = "HelloWorld" ;
		str.length();
		
		/*
		 * 각 인덱스별 문자 뽑아서 출력
		 * 'H' => str.CharAt(0);
		 * 'e' => str.CharAt(1);
		 * 'l' => str.CharAt(2);
		 * ...
		 * 'o' => str.CharAt(4);
		 * 0번 인덱스에서부터 4번 인덱스까지 매번 1씩 증가하면서 반복 수행
		 * 
		 * 문자열.length(); : 문자열의 길이를 구할 수 있다.
		 
		
		for (int i = 0 ; i < str.length() ; i++) {
			System.out.print(str.charAt(i) + " ");
		}
		*/
		
		/*
		 * 사용자에게 문자열을 입력받아
		 * 해당 문자열의 짝수 자리 글자만 출력
		 * 문자열을 입력 : hello
		 * el
		 */
		
	/*	Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		sc.close();
		
		str.length();
		
		for (int i = 1 ; i < str.length() ; i+=2 ) {
			System.out.print(str.charAt(i));
		} //짝수 자리 글자  = i 가 홀수일 때
		*/
		
		/*
		 * 사용자로부터 단을 입력받아 출력해보자
		 * 단 수(2~9) 입력 :
		 */
		Scanner sc = new Scanner(System.in) ;
//		System.out.print("단 수(2~9)를 입력 : ");
//		int dan = sc.nextInt();
		sc.close();
//		
//		System.out.println(dan + "단은");
//		
//	
//		if(dan>=2 && dan <= 9) {
//			for (int i = 1 ; i < 10 ; i++) {
//				System.out.printf("%d * %d = %d\n", dan, i, (dan * i));
//			}
//		} else {
//			System.out.print("잘못 입력하였습니다.");
//			
//		}
		
		// 1 2 3 4 5
		// 1 2 3 4 5
		// 1 2 3 4 5
		
		//이중 for 문 이용한 구구단 출력
		for (int dan = 2 ; dan < 10 ; dan++) {
			for (int num = 1 ; num < 10; num++) {
				System.out.printf("%d * %d = %d\n", dan, num, (dan * num) );
			} 
			System.out.println();
		}
		
	}

}
