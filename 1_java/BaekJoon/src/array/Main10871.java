package array;
import java.util.Scanner;
public class Main10871 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = 0, num;
		size = sc.nextInt();
		num = sc.nextInt();
		int[] arr = new int[size];
		for(int i = 0 ; i < arr.length ; i++) {
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		for(int i = 0 ; i < arr.length ; i++) {
			if(arr[i] < num) {
				System.out.print(arr[i]);
				System.out.print(" ");
			}
		}
	}

}
