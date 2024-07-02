import java.util.Scanner;
public class Practice3 {
	/*
	 * 키보드로 가로, 세로 값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 면적 : 가로 * 세로
	 * 둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 :
	 * 둘레 :
	 */
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	float width, length;
	
	System.out.println("키보드로 가로, 세로 값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력하세요.");	
	
	System.out.print("가로 : ");
	width = sc.nextFloat();
	sc.nextLine();
	
	System.out.print("세로 : ");
	length = sc.nextFloat();
	sc.nextLine();
	
	
	
	System.out.println("면적 : " + (width * length));
	System.out.println("둘레 : " + (width + length) * 2);
	// printf로 표현하기
//	System.out.printf("면적 : %.2f\n", (width * length));
//	System.out.printf("둘레 : %.2f", (width + length) * 2);
	sc.close();
	}
	
}