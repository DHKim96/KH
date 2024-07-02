package array;
import java.util.Scanner;
public class Main2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max;
		
		int[] arr = new int[9];
		
		max = arr[0];
		
		for (int i = 0 ; i < 9 ; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max ) {
				max = arr[i];
			}
		}
		
		sc.close();
		
		for (int i = 0 ; i < 9 ; i++) {
			int index = (i + 1);
			if (max == arr[i]) {
				System.out.println(max);
				System.out.println((index));
			}
		}
	}
}
