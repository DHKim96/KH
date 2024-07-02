import java.util.Scanner;

public class Controll02 {
	public static void main(String[] args) {
		// 실수형으로 국어, 영어, 수학 세과목의 점수를 입력받아 총점과 평균을 계산하고
		// 합격인지 불합격인지 나타내는 프로그램을 작성하세요.
		// (합격 조건 : 세과목 점수가 각각 40점 이상 그리고 평균이 60점이상일 경우)
			
		Scanner sc = new Scanner(System.in);
		int ko, ma, en, total;
		double evg;
		
		System.out.print("국어 : ");
		ko = sc.nextInt();
		
		System.out.print("수학 : ");
		ma = sc.nextInt();
		
		System.out.print("영어 : ");
		en = sc.nextInt();
		
		total = ko + ma + en;
		evg = total / 3.0;
		
		if (ko >= 40 && ma >= 40 && en >= 40 && evg >= 60) {
			
			System.out.println("국어 : " + ko);
			System.out.println("수학 : " + ma);
			System.out.println("영어 : " + en);
			System.out.println("합계 : " + total);
			System.out.println("평균 : " + evg);
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다.");
		}
	}
}
