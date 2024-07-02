import java.util.Scanner;
public class LoopTest {
	public static void main(String[] args) {
		/*
		System.out.println("반복문 시작전");
		// for (초기식; 조건식; 증감식)
		
		for (int i = 0; i < 10; i++) {
			System.out.println("반복문 실행 : " + i);
		}
		
		
		System.out.println("반복문 종료");
		
		
		int i = 0; //for =>초기식
		while(i < 10) {
			System.out.println("반복문 실행 : " + i);
			i++;
		}
		*/
		
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		do {
			System.out.println("1. 입력");
			System.out.println("2. 수정");
			System.out.println("3. 조회");
			System.out.println("4. 삭제");
			System.out.println("7. 종료");
			System.out.print("메뉴번호를 입력하세요 : ");
			num = sc.nextInt();
			
			if (num == 1) {
				System.out.println("입력메뉴입니다.");
			} else if(num == 2) {
				System.out.println("수정메뉴입니다.");
			} else if(num == 3) {
				System.out.println("조회메뉴입니다.");
			} else if(num == 4) {
				System.out.println("삭제메뉴입니다.");
			} else if(num == 7) {
				System.out.println("프로그램이 종료됩니다");
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		} while(num != 7);
	}
}
