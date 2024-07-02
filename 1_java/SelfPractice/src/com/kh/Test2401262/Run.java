package com.kh.Test2401262;
import java.util.Scanner;
public class Run {

	public static void main(String[] args) {
		/*
		 * number라는 변수에 int형 값을 하나 입력받아 출력해라
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int number = sc.nextInt();
		
		/*
		 * 입력받은 값 number 가 
		 * 100 보다 작은 정수이면 "100 이하" 출력
		 * 100 이면 "100
		 * 100 이상이면 "100을 초과하였습니다. 다시 입력해주세요"를 출력한 후 100 이하가 입력될 때까지 반복
		 */
		while(true) {
			if (number < 100) {
				System.out.println("100 이하");
				sc.close();
				break;
			} else if (number > 100) {
				System.out.println("100을 초과하였습니다 다시 입력해주세요");
				System.out.print("정수 입력 : ");
				number = sc.nextInt();
			} else {
				System.out.println("100");
				sc.close();
				break;
			}
		}
		
		/*
		 * 1부터 입력받은 number까지의 값을 전부 더한 값을 구해라
		 * ex) number = 5 1+2+3+4+5 => 15 출력
		 */
			int sum = 0;
		for (int i = 0 ; i <= number ; i++) {
			sum += i;
		}
		System.out.printf("%d까지의 총합 : %d\n\n", number, sum);
		
		
		/*
		 * Employee클래슬르 작성해라
		 * empNo(int) name(String) gender(char) phone(String)
		 * getter/setter 및 toString 작성
		 */
		
		/*
		 * Employee를 담을 수 있는 길이 5인 객체 배열 생성하고 임의의 값으로 객체 5개 생성해
		 * 각 배열의 인덱스 값을 초기화해라
		 */
		Employee[] eparr = new Employee[5];
		eparr[0] = new Employee(01, "김동현", 'M', "갤럭시 S23");
		eparr[1] = new Employee(02, "김개똥", 'M', "갤럭시 S9");
		eparr[2] = new Employee(03, "김도연", 'F', "아이폰 13+");
		eparr[3] = new Employee(04, "김민경", 'F', "아이폰 11");
		eparr[4] = new Employee(05, "김땡땡", 'M', "고아라폰");
		
		for (Employee ep : eparr) {
			System.out.println(ep);
		}
	}

}
