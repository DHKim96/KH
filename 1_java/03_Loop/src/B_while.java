//import java.lang.Math;
import java.util.Scanner;
public class B_while {
	/*
	 * while 문
	 * 
	 * [초기식;](생략 가능)
	 * while(조건식){
	 * 		반복적으로 실행할 코드;
	 * 		[증감식;]
	 * }
	 * 
	 * 조건식의 결과가 true 일 경우 해당 코드를 실행한다.
	 * 
	 * 조건식 검사 --> true 일 경우 실행코드 실행
	 * 조건식 검사 --> true 일 경우 실행코드 실행
	 * ...
	 * 조건식 검사 --> false 일 경우 실행코드 미수행 및 반복문 탈출
	 */
	public static void main(String[] args) {
		/*
		for (int i = 0 ; i < 5 ; i++) {
			System.out.println("안녕하세요.");
		}
		*/
		
		/*
		int i = 0;
		while( i < 5 ) {
			System.out.println("안녕하세요.");
			i++;
		}
		*/
		/*
		// while 문을 이용해서 1 ~ 10000 의 홀수만을 출력
		int i = 1;
		while (i < 10001) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
			i++;
			
			//if 문 대신 증감식에 i+=2 넣는 것으로 대체 가능
			
		*/
		
		/* 1부터 랜덤값(1~100)의 합계를 출력
		 * 
		 * 1에서부터 xx까지의 총 합계 : xxx
		 */
		/*
		int random, i, sum ;
		
		random = (int)(Math.random() * 100 + 1);
		
		i = 1 ;
		sum = 0;
		
		while(i <= random) { //조건식이 true 일 때 실행 코드 진행함에 유의!!!
			sum += i ;
			i++;
		}
		System.out.println("1에서부터 " + random + "까지의 총 합계 : " + sum);
		*/
		
		/*
		 * 사용자에게 문자열을 입력받아
		 * 해당 문자열의 짝수 자리 글자만 출력
		 * 문자열 입력 : hello
		 * el
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		sc.close();
		
		for (int i = 1 ; i < str.length(); i++) {
			if(i % 2 == 1) {
			System.out.print(str.charAt(i));
			}
		}
		
		System.out.println();
		
		
		int j = 1;
		while (j < str.length()) {
			System.out.print(str.charAt(j)); //j+=2 바로 넣는거 왜안됨? 출력후에 더해주는 i++과 달리 출력 전에 실행하는 i+=2는 반복 중에 인덱스 값을 넘어서며 오버플로우 되기에 에러 발생.
			j+=2;
		}
		
	}	

}
