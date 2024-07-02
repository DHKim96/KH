package ForWhile;
import java.util.Scanner;
public class Main10951 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, sum;
		while(sc.hasNext()) {
			a = sc.nextInt();
			b = sc.nextInt();
			sum = a + b;
			System.out.println(sum);
		}
		sc.close();
	}

}
