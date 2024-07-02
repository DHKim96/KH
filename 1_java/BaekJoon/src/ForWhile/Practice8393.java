package ForWhile;
import java.util.Scanner;
public class Practice8393 {
/*<합>
 * [문제 설명]
 * n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
 * [입력]
 * 첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
 * [출력]
 * 1부터 n까지 합을 출력한다.
 */
	public static void main(String[] args) {
		int num, sum = 0;
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		sc.close();
		
		if (num >= 1 && num <= 10000) {
			for (int i = 0 ; i <= num ; i ++) {
				sum += i;
			}
			System.out.print(sum);
		}
		

	}

}
