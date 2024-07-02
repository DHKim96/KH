package com.kh.Test240123;
//import java.util.Scanner;
public class Run {
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		
//		System.out.print("이름 : ");
//		String name = sc.nextLine();
//		
//		System.out.print("수학 점수 : ");
//		int maScore = sc.nextInt();
//		
//		System.out.print("국어 점수 : ");
//		int koScore = sc.nextInt();
//		
//		System.out.print("영어 점수 : ");
//		int enScore = sc.nextInt();
//		
//		double average = (maScore + koScore + enScore) / 3 ;
//		System.out.println(average);
		
//		int index = 0;
//		int menu = 0;
//		Student stArr[] = new Student[100]; 
		
//		while(menu != 9) {
//			System.out.println("===========성적관리 프로그램============");
//			System.out.println("1. 성적 입력");
//			System.out.println("2. 모든 학생 성적 확인");
//			System.out.println("3. 학생 성적 검색");
//			System.out.println("9. 종료");
//			System.out.print("메뉴를 입력하세요 : ");
//			menu = sc.nextInt();
//			sc.nextLine();
//		
//			switch(menu) {
//			case 1 : {
//				System.out.print("이름 : ");
//				String name = sc.nextLine();
//				
//				System.out.print("수학 점수 : ");
//				int maScore = sc.nextInt();
//				
//				System.out.print("국어 점수 : ");
//				int koScore = sc.nextInt();
//				
//				System.out.print("영어 점수 : ");
//				int enScore = sc.nextInt();
//				
//				int i = 0;
//				boolean isTrue = false; // 중복이 존재하면 true / 아니면 false로 유지
//				while(stArr[i] != null) { // "!= null"은 이미 생성이 되어있다 
//					if(stArr[i++].getName().equals(name)) { // 배열에 저장된 객체의 이름과 입력받은 이름이 동일할때
//						System.out.println("해당 이름으로 저장된 성적이 존재합니다.");
//						isTrue = true;
//						break;
//					}
//				}
//				
//				if(!isTrue) {
//					stArr[index] = new Student(name, maScore, koScore, enScore);
//				System.out.println("성적 저장 완료 : " + stArr[index++].toString());
//				}
//			}break;
//			case 2 :{ // 모든 학생의 성적 확인
//				System.out.println("======================모든 학생 성적 확인==================");
//				for(int i = 0 ; stArr[i] != null ; i++ ) {
//					System.out.println(stArr[i].toString());
//				}
//			}break;
//			case 3 : { // 이름으로 학생 검색 후 정보 출력
//				System.out.println("===================검색 학생 정보===================");
//				String name;
//				System.out.println("이름 입력 : ");
//				name = sc.nextLine();
//				
//				boolean isTrue = false;
//				
//				int i = 0 ;
//				while(stArr[i] != null) {
//					if(stArr[i].getName().equals(name)) { // 배열에 저장된 객체의 이름과 입력받은 이름이 동일할때
//						System.out.println(stArr[i].toString());
//						break;
//					}
//					i++;
//				}
//				
//				if(!isTrue) {
//					System.out.println("해당 이름으로 검색되는 학생 없음");
//				}
//			}
//			case 9 :{
//				System.out.println("프로그램을 종료합니다");
//				return;
//			}
//		}
//		}
		
//		StudentManagement st1 = new StudentManagement();
//		st1.startProgram();
		
		// 또는
		
		new StudentManagement().startProgram(); // 한줄만 실행해도 되기에
		
	}
	//사용자로부터 이름 수학점수/국어점수/영어점수를 입력받아
	//평균을 실수로 구하세요.
	
	// 위에서 입력받은 정보로 객체를 생성할 수 있는 Student 클래스를 작성하세요
	// 평균을 구하는 메소드, 모든 필드 정보를 보여주는 메소드를 포함하여 작성합니다.
	
	// 해당 프로그램을 작성합니다.
	//===========성적 관리 프로그램===========
	// 1. 성적 입력
	// 2. 모든 학생 성적 확인
	// 3. 학생 성적 검색
	// 9. 종료
	// 메뉴를 입력하세요 : 
	// -> 1번 입력시 이름 수학점수/국어점수/영어점수를 입력받아 객체배열에 저장(이름 중복저장 안됨)
	// -> 2번 입력시 객체배열에 저장된 모든 학생 검색 후 정보출력
	// -> 9번 입력시 종료
}
