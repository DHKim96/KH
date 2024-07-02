package com.kh.employy;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
		EmployeeMenu em = new EmployeeMenu();
		em.EmployeeMainMenu();
		
		
		/*
		Scanner sc = new Scanner(System.in); // 입력을 받기 위해서 Scanner객체 생성
		int number = 0;
		while(true) {
			//number라는 변수에 int형 값을 하나 입력받아 출력해라
			number = sc.nextInt();
			System.out.println(number); //출력문 -> console창에 보이는 정보	
			
			//입력받은 값 number가 100보다 작은 정수이면 "100이하" 출력
			// 100이면 "100" 100이상이면 "100을 초과하였습니다. 다시입력해주세요"를 출력한 후 
			// 100이하가 입력될 때 까지 반복한다.
			
			if (number < 100) {
				System.out.println("100이하");
				break;
			} else if(number == 100) {
				System.out.println(100);
			} else if(number >= 100) {
				System.out.println("100을 초과하였습니다. 다시입력해주세요");
			}
		}
		
		//1부터 입력받은 number까지의 값을 전부 더한 값을 구해라 => 두잇교재 조건문~반복문까지 학습
		//ex) number = 5  1+2+3+4+5 => 15출력
		// 1 2 3 4 5
		int sum = 0;
		for(int i= 1; i <= number; i++) {
			sum += i;
		}
		System.out.println( number + "까지의 총 합 : " + sum);
		
		//길이가 number인 int형 1차원배열 arr을 생성하고
		//1~number까지의 수를 순서대로 배열에 저장하고 출력해라
		
		int[] arr = new int[number]; // 5 
		//길이가 number인 배열에 1~number까지의 수를 대입
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		//배열에 있는 모든 값을 출력
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		//Employee클래스를 작성하라
		//empNo(int) name(String) gender(char) phone(String) 
		// getter/setter 및 toString 작성
		
		
		
		//Employee를 담을 수 있는 길이가 5인 객체배열을 생성하고 임의에 값으로 객체5개를 생서해 
		//각 배열의 인덱스값을 초기화해라
		
		Employee[] empArr = new Employee[5];
		empArr[0] = new Employee(1, "최지원", 'M', "010-0000-0000");
		empArr[1] = new Employee(2, "최지원", 'M', "010-0000-0000");
		empArr[2] = new Employee(3, "최지원", 'M', "010-0000-0000");
		empArr[3] = new Employee(4, "최지원", 'M', "010-0000-0000");
		empArr[4] = new Employee(5, "최지원", 'M', "010-0000-0000");
		*/
	}
}
