import java.util.Scanner;
public class D_break {
/*
 * break; : 반복문 안에서 사용되는 분기문
 * 			break; 가 실행되는 순간, 현재 속해있는 반복문을 강제로 빠져나감.
 * 유의사항 : switch 문 안의 break; 는 단지 switch 문 만을 빠져나가는 구문임.
 * 
 */
	public static void main(String[] args) {
	// 랜덤값(1~100) 발생시키고 그 랜덤값을 출력(이 과정을 계속 반복)
	// 단, 발생된 랜덤값이 3의 배수일 경우는 반복문을 탈출해라
		
//		while(true) {
//			int random = (int)(Math.random() * 100 + 1);
//			System.out.println(random);
//			if (random % 3 == 0) {
//				break; // 해당 반복문을 탈출
//			}
//		}
		
		/*
		 * 사용자에게 문자열을 입력받아 해당 문자열의 길이를 출력(이 과정 반복)
		 * 단, 사용자가 입력한 문자열이 "exit"일 경우 반복문을 탈출
		 */
		
		String str;
		Scanner sc = new Scanner(System.in);
		
		while(true){
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();
			System.out.println("길이 : " + str.length());
			
			if(str.equals("exit")){
				break;
			}
		}
		
		sc.close();

		
		
	}
}
