package fourBasicOperations;
import java.util.Scanner;
public class Multiple {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			int b = sc.nextInt();
			sc.close();
			
			int res1 = ( b % 10 ) * a ; // 5 * a
			int res2 = ( ( ( b % 100 ) - ( b % 10 ) ) * a ) / 10;
			// ( 85 - 5 ) * a
			int res3 = ( ( ( b % 1000 ) - ( b % 100 ) ) * a ) / 100;
			
			System.out.println(res1);
			System.out.println(res2);
			System.out.println(res3);
			System.out.println(a * b);
		}
}
			

