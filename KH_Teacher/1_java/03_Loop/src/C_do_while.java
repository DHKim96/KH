import java.util.Scanner;

public class C_do_while {
	/*
	 *  *do-while문
	 *  
	 *  do{
	 *  	반복적으로 실행할 코드
	 *  }while(조건식);
	 *  
	 *  처음에 무조건 실행코드 실행**
	 *  --> 조건식 검사 --> true일 경우 실행코드 실행
	 *  --> 조건식 검사 --> true일 경우 실행코드 실행
	 *  --> 조건식 검사 --> false일 경우 실행코드 실행x => 반복문 탈출
	 *  
	 *  *기존의 for/while문과의 차이점
	 *   for/while문 같은 경우 처음 수행될 때 조건검사 후 true일 경우 반복코드를 실행
	 *   하지만 do-while일 경우 첫실행은 조건검사 없이 무조건 실행한다.
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//1부터 사용자가 입력한 수까지의 총 합계
		int num, sum = 0;
		System.out.print("정수 입력 : ");
		num = scan.nextInt();
		
		int i = 1;
		do { //1 2 3 4 5
			sum += i;
			i++;
		} while(i <= num);
		
		System.out.println("1부터 " + num + "까지의 총 합계 : " + sum);
	}
}
