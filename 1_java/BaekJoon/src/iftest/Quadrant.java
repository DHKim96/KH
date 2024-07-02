package iftest;
import java.util.Scanner;
public class Quadrant {
/*
 * <사분면 고르기>
 * [문제 설명]
 * 점의 좌표를 입력받아 그 점이 어느 사분면에 속하는지 알아내는 프로그램을 작성하시오
 * 단, x좌표와 y좌표는 모두 양수나 음수라고 가정한다
 * [입력]
 * 첫 줄에는 정수 x가 주어진다. (−1000 ≤ x ≤ 1000; x ≠ 0)
 * 다음 줄에는 정수 y가 주어진다. (−1000 ≤ y ≤ 1000; y ≠ 0)
 * [출력]
 * 점 (x, y)의 사분면 번호(1, 2, 3, 4 중 하나)를 출력한다.
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y;
		x = sc.nextInt();
		y = sc.nextInt();
		sc.close();
		
		if (x > 0 ) {
			if ( y > 0) {
				System.out.println(1);
			} else {
				System.out.println(4);
			}
		} else if (y > 0) {
			System.out.println(2);
		} else {
			System.out.println(3);
		}
		
	}

}
