import java.util.Scanner;
public class Casting01 {
	public static void main(String[] args) {
		//키보드로 문자 하나를 입력받아 그 문자의 유니코드를 출력하세요.
		// ex)
		// 문자 : A
		// unicode : 65
		
		Scanner sc = new Scanner(System.in);
		char ch;
		
		System.out.print("문자 : ");
		ch = sc.next().charAt(0);
		
		System.out.println((int)ch);
	}
}
