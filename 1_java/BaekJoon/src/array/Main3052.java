package array;
import java.util.Scanner;
public class Main3052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] isTrue = new boolean[42];
		
		// 굳이 수학적으로 풀 필요는 없다 프로그램의 시각으로 생각해보자
		// 숫자의 중복을 제거할 때 유용한 방법
		
		int count = 0;
		
		for (int i = 0 ; i < 10 ; i++) {
			 int num = sc.nextInt();
			 isTrue[num % 42] = true;
		}
		
		sc.close();
		
		for (int i = 0 ; i < isTrue.length ; i++) {
			if (isTrue[i] == true) {
				count++;
			}
		}
		
		System.out.println(count);
	
		
	}

}
