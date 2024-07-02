package array;
import java.util.Scanner;
public class Main10813 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int ball;
		int[] emptyBasket = {0};
		// 공을 바꾸기 전에 잠시 넣어둘 배열을 하나 만들어줬음
		
		for (int i = 0 ; i < arr.length ; i++) {
			ball = i + 1 ;
			arr[i] = ball ;
		}
		
		int M = sc.nextInt();
		
		int i, j;
		
		for (int k = 0 ; k < M ; k++) {
			i = sc.nextInt(); // 1 3 1 2
			j = sc.nextInt(); // 2 4 4 2
			emptyBasket[0] = arr[i-1];
			arr[i-1] = arr[j-1];
			arr[j-1] = emptyBasket[0];
		}
		
		sc.close();
		
		for(int ar : arr) {
			System.out.print(ar + " ");
		}
	}

}
