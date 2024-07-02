package array;
import java.util.Scanner;
public class Main10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size;
		size = sc.nextInt();
		
		int[] arr = new int[size];
		
		for(int i = 0 ; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		} // 정수 입력
		
		sc.close();
		
		int max = arr[0];
		
		for(int i = 1 ; i < arr.length ; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		int min = arr[0];
		
		for(int i = 1 ; i < arr.length ; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		
		System.out.print(min);
		System.out.print(" ");
		System.out.print(max);
	}

}
