package fourBasicOperations;
import java.util.Scanner;
public class addition {
	/*
	 * [문제] A + B + C
	 * 단, 1 <= A, B, C <= 10^12 => long 형 사용해야함.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		sc.close();
		
		long sum = a + b + c;
		
		System.out.println(sum);
	
	}

}
