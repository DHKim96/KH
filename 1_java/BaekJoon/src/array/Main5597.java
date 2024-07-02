package array;
import java.util.Scanner;
public class Main5597 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[30];
		
		for (int i = 0 ; i < 28 ; i++) {
			int num = sc.nextInt();
			arr[num-1] = 1;
		}
		
		sc.close();
		// int형 배열의 디폴트값은 0 인 점을 이용해서
		// 출석 번호에 해당하는 배열에는 1을 넣고
		// for 문을 통해 1이 아닌 배열의 번호를 출력하여
		// 출석 번호를 제외한 배열의 번호를 알 수 있음
		for (int i = 0 ; i < arr.length ; i++) {
			if (arr[i] == 0) {
				System.out.println( i + 1 );
			}
		}
		
	}
}
