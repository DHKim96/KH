package com.kh.Test240123;

import java.util.Scanner;

public class Run {
	public static void main(String[] args) {
	
		
		StudentManagement stm = new StudentManagement();
		stm.startProgram();
		
//		new StudentManagement().startProgram();
		/*
		//사용자로부터 이름 수학점수/국어점수/영어점수를 입력받아
		String name;
		int math, korean, english;
		
		System.out.print("이름 : ");
		name = sc.next();
		
		System.out.print("수학점수 : ");
		math = sc.nextInt();
		
		System.out.print("국어점수 : ");
		korean = sc.nextInt();
		
		System.out.print("영어점수 : ");
		english = sc.nextInt();
		
		System.out.println("평균 : " + (math + korean + english) / 3.0);
		// 평균을 실수로 구하세요.
		*/
		/*
		// 위에서 입력받은 정보로 객체를 생성할 수 있는 Student클래스를 작성하세요.
		//평균을 구하는 메소드, 모든 필드정보를 보여주는 메소드를 포함하여 작성합니다.
		
		//해당프로그램을 작성합니다.
		// ===========성적관리 프로그램=================
		// 1. 성적입력
		// 2. 모든학생 성적확인
		// 3. 학생성적검색
		// 9. 종료
		// 메뉴를 입력하세요 : 
		// -> 1번입력시  이름 수학점수/국어점수/영어점수를 입력받아 객체배열에 저장(이름 중복저장 안됨)
		// -> 2번입력시 객체배열에 저장된 모든 객체정보 표시
		// -> 3번입릭시 이름을 입력받아 해당 이름의 학생 검색 후 정보출력
		// -> 9번입력시 종료
		Student[] stArr = new Student[100];
		int select = 0, index=0;
		
		while(select != 9) {
			System.out.println("=========== 성적관리 프로그램 =================");
			System.out.println("1. 성적입력");
			System.out.println("2. 모든학생 성적확인");
			System.out.println("3. 학생성적검색");
			System.out.println("9. 종료");
			System.out.print("메뉴를 입력하세요 : ");
			select = sc.nextInt();
			
			switch(select) {
			case 1: { //성적저장
				System.out.println("============ 성적입력 =============");
				String name;
				int math, korean, english;
				
				System.out.print("이름 : ");
				name = sc.next();
				
				System.out.print("수학점수 : ");
				math = sc.nextInt();
				
				System.out.print("국어점수 : ");
				korean = sc.nextInt();
				
				System.out.print("영어점수 : ");
				english = sc.nextInt();
				
				int i = 0;
				boolean isTrue = false; // 중복이 존재하면 true/존재하지 않으면 false로 유지
				while(stArr[i] != null) {
					if(stArr[i++].getName().equals(name)) { // 배열에 저장된 객체의 이름과 입력받은 이름이 동일 할 때
						System.out.println("해당 이름으로 저장된 성적이 존재합니다.");
						isTrue = true;
						break;
					}
				}
				
				if (!isTrue) {
					stArr[index] = new Student(name, math, korean, english);
					System.out.println("성적 저장 완료 : " + stArr[index++].toString());
				}
			}break;
			case 2:{//모든학생의 성적확인
				System.out.println("==================모든학생 성적 확인 =================");
				for (int i = 0; stArr[i] != null; i++) {
					System.out.println(stArr[i].toString()); 
				}
			}break;
			case 3:{ //이름으로 학생 검색후 정보 출력
				System.out.println("========== 검색 학생 정보 ============");
				
				String name;
				System.out.println("이름 입력 : ");
				name = sc.next();
				
				int i = 0;
				boolean isTrue = false;
				while(stArr[i] != null) {
					if(stArr[i].getName().equals(name)) {
						System.out.println(stArr[i].toString());
						isTrue = true;
						break;
					}
					i++;
				}
				
				if (!isTrue) {
					System.out.println("해당 이름으로 검색되는 학생 없음");
				}
			}break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
		*/
		
		
		
	}
}
