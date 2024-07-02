import java.util.Scanner;
import java.lang.Math;

public class A_for {
	/*
	 * <반복문>
	 * 프로그램 흐름을 제어하는 제어문 중 하나
	 * 어떤 실행코드를 반복적으로 수행시켜준다.
	 * 
	 * 크게 두 종류로 나뉨( for문 / while문(do-while문) )
	 * 
	 * * for문
	 * 
	 *  for(초기식; 조건식; 증감식){ // 반복 횟수를 지정하기 위해 제시하는 것들
	 *  	반복적으로 실행시키고자하는 구몬
	 *  }
	 *  
	 *  - 초기식 : 반복문이 수행될 때 "처음에 단 한번만 실행하는 구문"
	 *  		 (보통 반복문 안에서 사용될 변수를 선언 및 초기화하는 구문)
	 *  
	 *  - 조건식 : "반복문이 수행될 조건"을 작성하는 구문
	 *  		 조건식이 true일 경우 해당 구문을 실행
	 *  		 조건식이 false가 되는 순간 반복을 멈추고 빠져나옴
	 *  		 (보통 초기식에 제시된 변수를 가지고 조건식을 정함)
	 *  
	 *  -증감식 : 반복문을 제어하는 변수 값을 증감 시키는 구문
	 *  		(보통 초기식에 제시된 변수를 가지고 증감연산자를 사용함)
	 * 
	 * *for문을 만나는 순간
	 * 초기식 -> 조건식 검사 -> true일 경우 실행구문 실행 -> 증감식
	 * 		   조건식 검사 -> true일 경우 실행구문 실행 -> 증감식
	 * 		   -------------------해당 내용을 반복 ------------
	 *         조건식 검사 -> false일 경우 실행구문 실행x ==> 반복문 빠져나옴
	 *         
	 * tip. 알아둘점
	 * 	for문 안에 초기식, 조건식, 증감식 각각 생략 가능하긴하다(단, ;은 반드시 입력)
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		//"안녕하세요"를 5번 출력하세요.
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		System.out.println("안녕하세요");
		
		
		for(int i = 0; i < 5; i++) { // i값이 0에서부터 4까지 매번 1씩 증가하는 동안 반복수행(0 1 2 3 4)
			System.out.println("안녕하세요");
		}
		
		for(int i = 11; i < 16; i++) { // i값이 11에서부터 15까지 매번 1씩 증가하는 동안 반복수행(11 12 13 14 15)
			System.out.println("안녕하세요");
		}
		
		for(int i = 1; i <= 9; i+=2) { // i값이 1에서부터 8까지 매번 2씩 증가하는 동안 반복수행(1 3 5 7 9)
			System.out.println("안녕하세요");
		}
		*/
		
		/*
		// 1~5까지 순차적으로 출력하세요(1 2 3 4 5)
		for (int i = 1; i < 6; i++) { // 1 2 3 4 5
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//5~1까지 순차적으로 출력
		for (int i = 5; i > 0; i--) {
			System.out.print(i + " ");
		}
		*/
		
		
		/*
		//정수 n을 입력받아 1부터 n까지 1씩 증가시키면서 출력해라
		// 정수입력 : 3
		// 1 2 3
		
		int n;
		
		System.out.print("정수입력 : ");
		n = sc.nextInt(); //3
		
		for (int i = 1; i <= n; i++) { // 1, 2, 3 ... n
			System.out.print(i + " ");
		}
		*/
		
		/*
		// 1부터 10사이의 홀수만 출력
		// 1 3 5 7 9
		
		for (int i = 1; i < 11; i++) { // 1 2 3 4 5 6 7 8 9 10 
			if(i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
		*/
		
		/*
		// 1에서부터 100까지 총 합계를 구해라
		// 방법1. 1+2+3+4+...10;
		
		// 방법2.
		
//		  int sum = 0;
//		  sum += 1;
//		  sum += 2;
//		  sum += 3;
//		  ...
//		  sum += 10;
//		  
//		  규칙을 찾자! sum변수에 누적해서 합산하는 것 반복적으로 진행됨
//		  단, 누적해서 더하고자하는 값이 1에서부터 10까지 1씩 증가한다.
		 
		
		int sum = 0;
		
		for (int i = 1; i < 11; i++) { // 1 2 3 4 5 6 7 8 9 10
			sum += i;
		}
		System.out.println("1부터 10까지의 모든 수의 합 : " + sum);
		*/
		
		/*
		//정수 n을 입력받아 1부터 n까지 1씩증가하며 모든 수를 더해서 출력해라
		//정수 입력 : 5
		// 1부터 5까지의 합 : 15
		int n, sum = 0;
		System.out.print("정수입력 : ");
		n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.print(sum + " ");
		*/
		
		/*
		 * java.lang.Math 클래스에서 제공하는 random()메소드 호출해서 매번 다른 랜덤값을 얻어낼 수 있다.
		 * 
		 * Math.random() 호출시 ==> 0.0 ~ 0.99999999사이의 랜덤값을 반환
		 * 						  (0.0 <=     < 1.0) 
		 * 
		 * int random = Math.random(); // double형이라서 안됨
		 * 				(0.0 <=     < 1.0)
		 * 
		 * int random = Math.random() * 10;
		 * 				(0.0 <=     < 10.0); => 0.0 ~ 9.9999999
		 * 
		 * int random = Math.random() * 10 + 1;
		 * 				(1.0 <=     < 11.0); => 1.0 ~ 10.99999999
		 * 
		 * int random = (int)(Math.random() * 10 + 1);
		 * 				1 ~ 10
		 */
 		/*
		int random = (int)(Math.random() * 10 + 1);
		System.out.println(random);
		*/
		
		
		// random(1~10)한 숫자 n을 생성해서 1부터 n까지 모두 더한 값을 출력하세요
		// random 수  : 5
		// 1~5까지의 합 : 15
		
		/*
		int n, sum = 0;
		
		n = (int)(Math.random() * 10 + 1);
		for (int i = 1; i <= n; i++) { // 1 2 3 4 5 6 7
			sum += i;
		}
	
		System.out.println("random 수 : " + n);
		System.out.print("1~" + n + "까지의 합 : " + sum);
		*/
		
		
		/*
		// random(5~50)한 숫자 n을 생성해서 1부터 n까지의 숫자중 짝수만 출력해라
		// random 수 : 10
		// 2 4 6 8
		
		
		int n;
		n = (int)(Math.random() * 46 + 5);
		
		System.out.println("random 수 :" + n);
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		*/
		
		/*
		String str = "Hello";
		
		
//		 * 각 인덱스별 문자 뽑아서 출력
//		 * 
//		 * H  => str.charAt(0) 출력
//		 * e  => str.charAt(1) 출력
//		 * l  => str.charAt(2) 출력
//		 * l  => str.charAt(3) 출력
//		 * o  => str.charAt(4) 출력
//		 * 
//		 * 0번인덱스에서부터 4번인덱스(마지막인덱스)까지 매번 1씩 증가하면서 반복 수행
//		 * 
//		 * 문자열.length() : 문자열의 길이를 구할 수 있다.
		 
		
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
		}
		*/
		
		
		/*
		//사용자에게 문자열을 입력받아
		//해당 문자열의 짝수자리 글자만 출력
		//문자열 입력 : hello
		//el
		String str;
		
		System.out.println("문자열 입력 :");
		str = sc.next();
		
		//각 인덱스별 문자를 뽑아서 출력
		
		//apple 길이 : 5글자
		//01234
		
		//strawberry 길이 : 10글자
		//0123456789
		
		//kiwi 길이 : 4글자
		//0123
		
		//마지막 인덱스는 항상 (문자열 길이 - 1)이구나
		//추출하고자하는 익덱스값이 0~(문자열길이-1)까지 매번 1씩 증가
		
		for (int i = 0; i < str.length(); i++) {
			if (i % 2 == 1) { // 출력하고자하는 것은 짝수자리 글자(다만 작수자리 글자의 인덱스는 모두 홀수이다)
				System.out.print(str.charAt(i));
			}
		}
		*/
		
		
		// 구구단 2단을 출력해보자
		/*
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * 2 * 4 = 8
		 * 2 * 5 = 10
		 * 2 * 6 = 12
		 * 2 * 7 = 14
		 * 2 * 8 = 16
		 * 2 * 9 = 18
		 * 
		/*
		for (int i = 1; i < 10; i++) {// 1 2 3 4 5 6 7 8 9
			System.out.println("2 * " + i + " = " + (2*i));
		}*/
		
		/*
		//사용자로부터 단을 입력받아
		//사용자가 입력한 단을 출력하기
		//단 수(2~9)를 입력 : 3
		int dan;
		
		System.out.print("단 수(2~9)를 입력 : ");
		dan = sc.nextInt();
		
		if(dan >= 2 && dan <= 9) {
			for (int su = 1; su <= 9; su++) {
				System.out.printf("%d * %d = %d\n", dan, su, (dan * su));
			}
		} else {
			System.out.println("잘못 입력했습니다.");
		}
		*/
		
		
		// 1 2 3 4 5
		// 1 2 3 4 5
		// 1 2 3 4 5
		
//		System.out.println("1 2 3 4 5");
//		System.out.println("1 2 3 4 5");
//		System.out.println("1 2 3 4 5");
		/*
		for (int i = 0; i < 3; i++) { // 0 1 2
			//1
			for (int j = 1; j < 6; j++) { // 1 2 3 4 5
				//2
				System.out.print(j + " ");
				//3
			}
			System.out.println();
		}
		*/
		
		
		/*
		 * 2 * 1 = 2      
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * 2 * 4 = 8
		 * 2 * 5 = 10
		 * 2 * 6 = 12
		 * 2 * 7 = 14
		 * 2 * 8 = 16
		 * 2 * 9 = 18
		 * 
		 * 3 * 1 = 2      
		 * 3 * 2 = 4
		 * 3 * 3 = 6
		 * 3 * 4 = 8
		 * 3 * 5 = 10
		 * 3 * 6 = 12
		 * 3 * 7 = 14
		 * 3 * 8 = 16
		 * 3 * 9 = 18
		 * 
		*/
		//위처럼 구구단을 출력해라 단 2~9단 모두를 출력해라
		
		/*
		// 2~9까지 순차적으로 1씩 증가하면서 반복
		for (int i = 2; i <= 9; i++) {
			
			for (int su = 1; su < 10; su++) { // 1 2 3 4 5 6 7 8 9
				System.out.printf("%d * %d = %d\n", i, su, (i * su));
			}

		}
		*/
		
	}

}
