package ForWhile;
import java.util.Scanner;
public class Main25304 {

	public static void main(String[] args) {
		int X, N, a, b, total = 0;
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		N = sc.nextInt();
		for (int i = 0 ; i < N ; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			total += a * b;
		}
		sc.close();
		String yesOrNo = ( X == total ) ? "Yes" : "No" ;
		System.out.println(yesOrNo);
	}

}
