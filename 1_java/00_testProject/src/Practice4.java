import java.util.Scanner;
public class Practice4 {
	/*
	 * 영어 문자열 값을 키보드로 입력 받아 문자에서 앞으로부터 3개를 출력하세요.
	 * 문자열을 입력하세요 : apple
	 * 첫 번째 문자 : a
	 * 두 번째 문자 : b
	 * 세 번째 문자 : c
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str;
		
		System.out.println("영어 문자열 값을 키보드로 입력 받아 문자에서 앞으로부터 3개를 출력하세요.");
		
		System.out.print("문자열을 입력하세요 : ");
		str = scan.nextLine();
		
		System.out.println("첫 번째 문자 : " + str.charAt(0) );
		System.out.println("두 번째 문자 : " + str.charAt(1) );
		System.out.println("세 번째 문자 : " + str.charAt(2) );
		
		scan.close();
		
		
	}

}
