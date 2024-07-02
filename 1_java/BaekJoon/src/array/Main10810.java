package array;
import java.util.Scanner;
public class Main10810 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numOfBasket = sc.nextInt(); // 번호 N 입력
		int countOfBall = sc.nextInt();
		int[] basketArr = new int[numOfBasket+1]; // N번까지의 바구니 만들기
		basketArr[0] = 0; // 처음 바구니에는 공이 들어있지 않음
		// 바구니에는 공을 1개만 넣을 수 있음 == 배열이라는 의미?
		int count = 0;
		do {
			int i , j, k ;
			i = sc.nextInt();
			j = sc.nextInt();
			k = sc.nextInt();
			for ( ; i <= j ; i++ ) {
				basketArr[i] = k ;
			}
			count++;
		} while(count != countOfBall);
		
		sc.close();
		
		for (int i = 1 ; i < basketArr.length ; i++ ) {
			System.out.print(basketArr[i]);
			System.out.print(" ");
		}
		
	}

}
