package ForWhile;
import java.util.Scanner;
public class Main10950 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int size = sc.nextInt();
		 sc.close();
		 for (int i = 0; i < size ; i++) {
			 int num1 = sc.nextInt();
			 int num2 = sc.nextInt();
			 int total = num1 + num2;
			 System.out.println(total);
		 }
	}

}
