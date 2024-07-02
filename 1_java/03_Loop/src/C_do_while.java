import java.util.Scanner;
public class C_do_while {
/*
 * *do-while문
 * 
 * do{
 * 		반복적으로 실행할 코드
 * }while(조건식);
 * 
 * 처음에 무조건 실행코드 실행**
 * --> 조건식 검사 --> true 일 경우 실행코드 실행
 * --> ... 
 * --> 조건식 검사 --> false 일 경우 실행코드 미수행 => 반복문 탈출
 * 
 * *기존의 for/while 문과의 차이점
 *  for/while 문은 처음 수행될 때 조건식 검사 후 true 일 경우 반복 코드 실행
 *  do-while 문은 첫 실행은 조건식 검사 없이 무조건 실행
 *
 */
	public static void main(String[] args) {
		//1부터 사용자가 입력한 수 까지의 총 합계
		int num, sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		int i = 1;
		do {
			sum += i++;
		}while(i <= num);
		
		System.out.println("1부터 " + num + "까지의 총 합계 : " + sum);
		
		
		
		
	}

}
