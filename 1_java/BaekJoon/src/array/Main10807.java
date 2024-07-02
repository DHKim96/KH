package array;
import java.util.Scanner;
public class Main10807 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 0, a, b, count = 0;
		
		size = sc.nextInt();
		
		int[] arr = new int[size];
	
		for(int i = 0 ; i < arr.length ; i++) {
			a = sc.nextInt();
			arr[i] = a;
			
		}
		
		b = sc.nextInt();
		
		sc.close();
		
		for(int i = 0 ; i < arr.length ; i++) {
			if (arr[i] == b) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
