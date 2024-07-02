import java.util.Scanner;
public class Casting02 {

	public static void main(String[] args) {
		// 실수형으로 국어, 영어, 수학 세과목의 점수를 입력받아 총점과 평균을 출력하세요.
		//이 때 총점과 평균은 정수형으로 처리하세요.
		
		/*
		 * ex.
		 * 국어 : 90.0
		 * 수학 : 90.0
		 * 영어 : 90.0
		 * 
		 * 총점 : 270
		 * 평균 : 90
		 */
		
		Scanner sc = new Scanner(System.in);
		double ko, ma, en;
		int total;
		
		System.out.print("국어 : ");
		ko = sc.nextDouble();
		
		System.out.print("수학 : ");
		ma = sc.nextDouble();
		
		System.out.print("영어 : ");
		en = sc.nextDouble();
		
		total = (int)(ko + ma + en);
		
		System.out.println("\n총점 : " + total);
		System.out.println("평균 : " + ( total / 3 ));
	}

}
