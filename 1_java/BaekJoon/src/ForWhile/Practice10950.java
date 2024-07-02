package ForWhile;
/*
 * <A+B-3>
 * [문제 설명]
 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * [입력]
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
 * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
 * [출력]
 * 각 테스트 케이스마다 A+B를 출력한다.
 */
import java.util.Scanner;
public class Practice10950 {
	public static void main(String[] args) {
		int dan, a, b, sum = 0;
		Scanner sc = new Scanner(System.in);
		dan = sc.nextInt();

		for (int i = 0 ; i < dan ; i++ ) {
			a = sc.nextInt();
			b = sc.nextInt();
			sum = a + b;
			System.out.print(sum);
		}
	}
}
	
