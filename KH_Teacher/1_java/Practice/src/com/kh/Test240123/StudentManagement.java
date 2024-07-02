package com.kh.Test240123;

import java.util.Scanner;

public class StudentManagement { // 학생관리프로그램
	Scanner sc; 
	Student[] stArr; // 학생목록
	
	public StudentManagement() {
		super();
		this.sc = new Scanner(System.in);
		this.stArr = new Student[100];
	}
	
	public void startProgram() {
		int select = 0;
		while(select != 9) {
			select = this.printMenu();
			
			switch(select) {
			case 1: // 성적입력
				this.insertGrade();
				break;
			case 2: // 모든학생 성적확인
				this.printAllGrade();
				break;
			case 3: //이름으로 학생 검색후 정보 출력
				this.searchGradeByName();
				break;
			case 4: // 마지막으로 저장된 정보 삭제
				this.lastGradeDelete();
				break;
			case 5:
				this.searchGradeByCondition();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
			}
		}
	}
	
	public int printMenu() {
		System.out.println("=========== 성적관리 프로그램 =================");
		System.out.println("1. 성적입력");
		System.out.println("2. 모든학생 성적확인");
		System.out.println("3. 학생성적검색");
		System.out.println("4. 마지막저장정보 삭제");
		System.out.println("5. 조건검색");
		System.out.println("9. 종료");
		System.out.print("메뉴를 입력하세요 : ");
		int select = sc.nextInt();
		sc.nextLine();
		return select;
	}
	
	public void insertGrade() {
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
			stArr[i] = new Student(name, math, korean, english);
			System.out.println("성적 저장 완료 : " + stArr[i].toString());
		}
	}
	
	public void printAllGrade() {
		System.out.println("==================모든학생 성적 확인 =================");
		for (int i = 0; stArr[i] != null; i++) {
			System.out.println(stArr[i].toString()); 
		}
		
		if (stArr[0] == null) {
			System.out.println("입력된 성적이 없습니다.");
		}
	}
	
	public void searchGradeByName() { 
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
	}
	
	public void searchGradeByCondition() {
		// 1. 평균 2. 수학 3. 국어 4. 영어
		// (다른번호 입력시 잘못입력하셨습니다. 출력하고 성적관리프로그램으로 돌아가기)
		// 조회할 조건 입력 : 1
		// 기준점수(이상) : 30
		// 기존점수(이하) : 50
		
		//30이상 50이하의 평균학생
		// ---------
		int select, min, max;
		
		System.out.println("=========== 조건 검색 ===========");
		System.out.println("1.평균 2.수학 3.국어 4.영어");
		System.out.print("조건 입력 : ");
		select = sc.nextInt();
		
		System.out.print("기준점수(이상) : ");
		min = sc.nextInt();
		
		System.out.print("기준점수(이하) : ");
		max = sc.nextInt();
		
		switch(select) {
		case 1: // 평균
			for (int i = 0; stArr[i] != null; i++) { // 생성된 것까지만 배열을 반복해서 탐색
				double avg = stArr[i].getAvg();
				if (min <= avg && max >= avg) {
					System.out.println(stArr[i].toString());
				}
			}
			break;
		case 2:
			for (int i = 0; stArr[i] != null; i++) { // 생성된 것까지만 배열을 반복해서 탐색
				int math = stArr[i].getMath();
				if (min <= math && max >= math) {
					System.out.println(stArr[i].toString());
				}
			}
			break;
		case 3:
			for (int i = 0; stArr[i] != null; i++) { // 생성된 것까지만 배열을 반복해서 탐색
				int korean = stArr[i].getKorean();
				if (min <= korean && max >= korean) {
					System.out.println(stArr[i].toString());
				}
			}
			break;
		case 4:
			for (int i = 0; stArr[i] != null; i++) { // 생성된 것까지만 배열을 반복해서 탐색
				int english = stArr[i].getEnglish();
				if (min <= english && max >= english) {
					System.out.println(stArr[i].toString());
				}
			}
			break;
		default:
			System.out.println("잘못입력하셨습니다.");
		}
		
		
	}
	
	public void lastGradeDelete() {
		if (stArr[0] == null) {
			System.out.println("삭제할 성적이 없습니다.");
			return;
		}
		
		for(int i = 0; i < stArr.length; i++) {
			if(stArr[i] == null) {
				System.out.println("삭제정보 : " + stArr[i - 1].toString());
				stArr[i - 1] = null;
				System.out.println("삭제를 완료하였습니다.");
				break;
			}
		}
	}
}
