import java.util.Scanner;

public class B_while {
	/*
	 * while문
	 * 
	 * [초기식;]
	 * while(조건식) {
	 * 		반복적으로 실행할 코드;
	 * 		[증감식;]
	 * }
	 * 
	 * 조건식의 결과가 true일 경우 해당 코드를 실행한다.
	 * 
	 * 조건식 검사 --> true일 경우 실행코드 실행
	 * 조건식 검사 --> true일 경우 실행코드 실행
	 * 조건식 검사 --> false일 경우 실행코드 실행x => 반복문 탈출
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("안녕하세요."); 5번 출력
		/*
		for (int i = 0; i < 5; i++) { // 0 1 2 3 4
			System.out.println("안녕하세요.");
		}
		*/
		
		/*
		int i = 0;
		while(i < 5) {
			System.out.println("안녕하세요.");
			i++;
		}
		*/
		
		
		//1에서부터 10000사이의 홀수만을 출력
		// 1 3 5 7 9 11 
		
		//i라는 변수를 만들고 1로 초기화
		// 만약 i가 10000보다 작서나 같으면 반복을 계속 진행
		// 만약 i가 홀수라면 출력 <- 반복
		
		/*
		int i = 1; // 2 3
		while(i <= 10000) {
			if (i % 2 == 1) { //홀수일때
				System.out.print(i + " ");	// 1 3 5 7 9 11 13 15 .... 
			}
			
			i++;
		}
		*/
		
		/*
		System.out.println();
		
		i = 1;
		while(i <= 10000) {
			System.out.print(i + " ");	
			i += 2;
		}
		*/
		
		/*
		// 1부터 랜덤값(1~100사이) 까지의 합계를 출력
		// 1에서부터 xx까지의 총 합계 : xxxx
		int random = (int)(Math.random() * 100 + 1);
		int sum = 0;
		
		
		for (int i = 1; i <= random; i++) {
			sum += i;
		}
		
		System.out.println("1에서부터 " + random + "까지의 총 합계 : " + sum);
		
		
		int i = 1;
		while(i <= random) {
			sum += i;
			i++;
		}
		System.out.println("1에서부터 " + random + "까지의 총 합계 : " + sum);
		*/
		
		/*
		//사용자에게 문자열을 입력받아
		//해당 문자열의 짝수자리 글자만 출력
		//문자열 입력 : hello
		//el
		 * 
		 * 1. 문자열입력받기
		 * 2. 입력받은 문자열 반복문으로 하나씩 전부 출력해보기
		 * 3. 짝수자리만 출력하기
		*/
		
		String str;
		
		System.out.print("문자열 입력 : ");
		str = sc.next(); // hello : 5 -> 01234
		
		int i = 1;
		while(i < str.length()) {		
			System.out.println(str.charAt(i+=2)); // 0 1 2 3 4	
			i += 2;
		}
		
		
	}
}
