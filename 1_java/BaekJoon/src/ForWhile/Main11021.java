package ForWhile;
import java.util.Scanner;
public class Main11021 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 1 ; i <= T ; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				int sum = A + B;
				System.out.print("Case #" + i + ": ");
				System.out.print(sum + "\n");
		}
		sc.close();
	}

}
