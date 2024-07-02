import java.util.Scanner;

public class Loop01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		num = sc.nextInt();
		
		while(num < 1) {
			System.out.println("1 이상의 숫자를 입력해주세요 : ");
			num = sc.nextInt();
		}
		
		for (int i = 1; i <= num; i++) {
			System.out.print(i + " ");	
		}
		

	}

}
