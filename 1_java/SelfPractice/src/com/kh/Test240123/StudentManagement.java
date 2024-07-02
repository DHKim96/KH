package com.kh.Test240123;
import java.util.Scanner;
public class StudentManagement {
	Scanner sc;
	Student[] stArr; // 학생 목록

	public StudentManagement() {
	super();
	this.sc = new Scanner(System.in);
	this.stArr = new Student[100];
	}
	
	public int printMenu() {
		System.out.println();
		System.out.println("===========성적관리 프로그램============");
		System.out.println("1. 성적 입력");
		System.out.println("2. 모든 학생 성적 확인");
		System.out.println("3. 학생 성적 검색");
		System.out.println("4. 마지막 저장 정보 삭제");
		System.out.println("5. 조건 검색");
		System.out.println("9. 종료");
		System.out.print("메뉴를 입력하세요 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		return menu;
	}
	
	public void startProgram() {
		int menu = 0;		
		while(menu != 9) {
			menu = this.printMenu();
			
			switch(menu) {
			case 1 : //성적 입력
				this.insertGrade();
				break;
			case 2 :
				this.showAll();
				break;
			case 3 :
				this.showInfo();
				break;
			case 4 : // 마지막으로 저장된 정보 삭제
				this.lastGradeDelete();
				break;
			case 5 : 
				this.searchGradeByCondition();
				break;
			case 9 :
				System.out.println("=============프로그램을 종료합니다=================");
				sc.close();
				return;
			}
		}
	}
	
	public void insertGrade() {
		System.out.println("======================학생 성적 입력==================");

		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("수학 점수 : ");
		int maScore = sc.nextInt();
		
		System.out.print("국어 점수 : ");
		int koScore = sc.nextInt();
		
		System.out.print("영어 점수 : ");
		int enScore = sc.nextInt();
		
		int i = 0;
		boolean isTrue = false; // 중복이 존재하면 true / 아니면 false로 유지
		while(stArr[i] != null) { // "!= null"은 이미 생성이 되어있다 
			if(stArr[i++].getName().equals(name)) { // 배열에 저장된 객체의 이름과 입력받은 이름이 동일할때
				System.out.println("해당 이름으로 저장된 성적이 존재합니다.");
				isTrue = true;
				break;
			}
		}
		
		if(!isTrue) {
			stArr[i] = new Student(name, maScore, koScore, enScore);
		System.out.println("성적 저장 완료 : " + stArr[i++].toString());
		}
	}
	
	public void showAll() { // 모든 학생 성적 확인
		System.out.println("======================모든 학생 성적 확인==================");
		for(int i = 0 ; stArr[i] != null ; i++ ) { // 학생이 입력되지 않은 객체 배열을 만날 때까지
			System.out.println(stArr[i].toString());
		}
	}
	
	public void showInfo() {
		System.out.println("===================검색 학생 정보===================");
		String name;
		System.out.println("이름 입력 : ");
		name = sc.nextLine();
		
		boolean isTrue = false;
		
		int i = 0 ;
		while(stArr[i] != null) {
			if(stArr[i].getName().equals(name)) { // 배열에 저장된 객체의 이름과 입력받은 이름이 동일할때
				System.out.println(stArr[i].toString());
				isTrue = true;
				break;
			}
			i++;
		}
		
		if(!isTrue) {
			System.out.println("해당 이름으로 검색되는 학생 없음");
		}
	}
	
	public void lastGradeDelete() {
		if(stArr[0] == null) {
			System.out.println("삭제할 성적이 없습니다.");
			return;
		}
		
		for (int i = 0 ; i < stArr.length ; i++) {
			if(stArr[i] == null ) { // 마지막으로 입력된 정보까지 도달
				System.out.print("삭제 정보 : " + stArr[i - 1].toString());
				stArr[i - 1] = null;
				System.out.print("삭제를 완료했습니다.");
				break;
			}
		
		}
		
	}
	
	public void searchGradeByCondition() {
		//1. 평균 2. 수학 3. 국어 4. 영어
		// (다른 번호 입력시 잘못입력하셨습니다. 출력하고 성적관리프로그램으로 돌아가기)
		// 조회할 조건 입력 : 1
		// 기준점수(이상) : 30
		// 기준점수(이하) : 50
		// 30 이상 50 이하의 평균 학생
		// --------------
		System.out.println("1. 평균");
		System.out.println("2. 수학");
		System.out.println("3. 국어");
		System.out.println("4. 영어");
		System.out.print("조회할 조건 입력: ");
		int select = sc.nextInt();
		System.out.print("기준 점수(이상): ");
		int num1 = sc.nextInt();
		System.out.print("기준 점수(이하): ");
		int num2 = sc.nextInt();
		
		
		switch(select) {
		case 1 :
			System.out.printf("%d 이상 %d 이하의 평균 학생\n", num1, num2);
			for(int i = 0; stArr[i] != null ; i++) {
				if ( stArr[i].getAverage() > num1 && stArr[i].getAverage() < num2) {
					System.out.println(stArr[i].name);	
				}
			}
			break;
		case 2 :
			System.out.printf("%d 이상 %d 이하의 수학 학생\n", num1, num2);
			for(int i = 0; stArr[i] != null ; i++) {
				if ( stArr[i].getMaScore() > num1 && stArr[i].getMaScore() < num2) {
					System.out.println(stArr[i].name);	
				}
			}
			break;
		case 3 : 
			System.out.printf("%d 이상 %d 이하의 국어 학생\n", num1, num2);
			for(int i = 0; stArr[i] != null ; i++) {
				if ( stArr[i].getKoScore() > num1 && stArr[i].getKoScore() < num2) {
					System.out.println(stArr[i].name);	
				}
			}
			break;
		case 4 :
			System.out.printf("%d 이상 %d 이하의 영어 학생\n", num1, num2);
			for(int i = 0; stArr[i] != null ; i++) {
				if ( stArr[i].getEnScore() > num1 && stArr[i].getEnScore() < num2) {
					System.out.println(stArr[i].name);	
				}
			}
			break;
		default :
			System.out.println("잘못 입력하셨습니다");
			this.printMenu();
		}
		
	}
	
	
}


