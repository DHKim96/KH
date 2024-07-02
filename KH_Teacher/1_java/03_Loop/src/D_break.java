import java.util.Scanner;

public class D_break {
	/*
	 * break;  : 반복문 안에서 사용되는 분기문
	 * 			 break;가 실행되는 순간 현재 속해있는 반복문을 강제로 빠져나감
	 * 
	 * 유의사항 : switch문 안의 break;는 단지 switch문 만을 빠져나가는 구문이다.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//랜덤값(1~100) 발생시키고 그 랜덤값을 출력(이과정 계속 반복)
		// 단, 발생된 랜덤값이 3의 배수일 경우 (3으로 나누면 0) 반복문을 종료해라(탈출해라)
		
//		while(true) {
//			int random = (int)(Math.random() * 100 + 1);
//			
//			System.out.println(random);
//			
//			if (random % 3 == 0) {
//				break;
//			}
//		}
		/*
		int random = 1;
		while(random % 3 != 0) {
			random = (int)(Math.random() * 100 + 1);
			
			System.out.println(random);
		}
		*/
		
		
		//사용자에게 문자열을 입력받아 해당 그 문자열의 길이를 출력(이과정 반복)
		// 단, 사용자가 입력한 문자열이 "exit"일 경우 반복문을 탈출
		
		String str;
		
		while(true) {
			System.out.print("문자열 입력 : ");
			str = sc.next(); // 문자열 입력받기
			
			if (str.equals("exit")) { // 입력받은 문자열과 exit비교
				break; // 반복문 탈출
			} else {
				System.out.println("길이 : " + str.length()); // 입력받은 문자열의 길이 출력
			}
			
		}
		
	}
}
