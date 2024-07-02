import java.util.Scanner;

public class Loop03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 : ");
		int dan = sc.nextInt();
		// dan = 4
		
		// 잘못된값이 입력되었을 때 반복해서 다시 입력
		while(dan > 9 || dan < 1) {
			System.out.print("1이상 9이하의 숫자만 입력해주세요 : ");
			dan = sc.nextInt();
		}
		
		for (int i = dan; i <= 9; i++) {   // i = 4, 5
			System.out.println("======="+i+"단=======");
			for(int j = 1; j <= 9; j++) { //j = 1, 2, 3, 4 ... 9
				System.out.println(i + " * " + j + " = " + (i*j));
			}
		}
		
		/*
		 * ==========4단==========
		 * 4 * 1 = 4
		 * 4 * 2 = 8
		 * ...
		 * 4 * 9 = 36
		 * ==========5단==========
		 */
	}

}
