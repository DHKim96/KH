import java.util.Scanner;
public class Practice5 {
	/*
	 * 원화를 입력 받아 달러로 바꾼 다음 출력
	 * 1$ = 1000이라고 가정
	 * 환전하고 싶은 원화를 입력하시오 : 5500
	 * 5500원 환전 액수 = $5.5
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("원화를 입력 받아 달러로 바꾼 다음 출력해보자.");
		
		int won;
		float dol;
		
		System.out.print("환전하고 싶은 원화를 입력하시오. : ");
		won = sc.nextInt();
		sc.nextLine();
		
		dol = (float)won / 1000;
		
		System.out.print(won + "원 환전 액수 = " + "$" + dol + "\n");
		System.out.printf("%d원 환전 액수 = $%.1f", won, dol);
		
		sc.close();
	}

}
