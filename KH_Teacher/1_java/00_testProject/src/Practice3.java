import java.util.Scanner;

public class Practice3 {
	/*
	 * 키보드로 가로, 세로 값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식)  면적 : 가로 * 세로
	 * 		 둘레 : (가로 + 세로) * 2
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float width, height;
		
		System.out.print("가로 : ");
		width = sc.nextFloat();
		sc.nextLine();
		
		System.out.print("세로 : ");
		height = sc.nextFloat();
		sc.nextLine();
		
//		System.out.println("면적 : " + (width * height));
//		System.out.println("둘레 : " + ((width + height) * 2));
		System.out.printf("면적 : %.2f\n", (width * height));
		System.out.printf("둘레 : %.2f", ((width + height) * 2));
	}
}
