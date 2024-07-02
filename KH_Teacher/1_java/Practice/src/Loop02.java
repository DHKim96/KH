import java.util.Scanner;

public class Loop02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1, num2, min, max;
		
		System.out.print("첫 번째 숫자 : ");
		num1 = sc.nextInt();
		
		//num1이 1보다 작다면 다시입력받기 반복
		while(num1 < 1) {
			System.out.print("1 이상의 숫자를 입력해 주세요 : ");
			num1 = sc.nextInt();
		}
		
		System.out.print("두 번째 숫자 : ");
		num2 = sc.nextInt();
		
		//num2가 1보다 작다면 다시 입력받기 반복
		while(num2 < 1) {
			System.out.print("1이상의 숫자를 입력해주세요 : ");
			num2 = sc.nextInt();
		}
		
		min = (num1 < num2 ? num1 : num2); // 작은 값 구하기
		max = (num1 > num2 ? num1 : num2); // 큰 값 구하기
		
		// i <- num1이 num2보다 작다면 num1이 들어가고 아니면 num2가 들어가
		for (int i = min; i <= max; i++) {
			System.out.print(i + " ");
		}

	}

}
