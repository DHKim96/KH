package ForWhile;
import java.util.Scanner;
public class Main25314 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		if ( N % 4 == 0) {
			int a = ( N / 4 ) ;
			for (int i = 0 ; i < a ; i++) {
				System.out.print("long ");
			}
			System.out.print("int");
		}
	}
}
