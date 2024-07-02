package com.kh.Test2401232;
import java.util.Scanner;
public class Library {
	// 도서 관리 프로그램
	Book[] bookArr;
	Scanner sc;
	
	public Library() {
		this.bookArr = new Book[100]; 
		// 생성자에서 bookArr는 Book 참조 변수 100개를 가지고 있는 배열
		this.sc = new Scanner(System.in);
	}
	
	
	public void startLibrary() {
		int choice = 0 ;
		while(choice != 9) {
			System.out.println("=============== 도서 관리 프로그램 ==============");
			System.out.println("1. 도서 등록");
			System.out.println("2. 모든 도서 출력");
			System.out.println("9. 종료");
			System.out.print("메뉴 입력 : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 : // 도서 등록
				this.insertBook();
				break;
			case 2 : // 모든 도서 출력
				this.printAllBooks();
				break;
			}
		}
	}
	
	public void insertBook() {
		System.out.println("=============== 도서 등록 ==============");
		String title, author, date;
		int number;
		System.out.print("제목 : ");
		title = sc.nextLine();
		
		System.out.print("작가 : ");
		author = sc.nextLine();
		
		System.out.print("발행일 : ");
		date = sc.nextLine();
		
		System.out.print("책 번호 : ");
		number = sc.nextInt();
		
		
		// 제목이 똑같은 책이 있다면 생성하지말고 "이미 등록된 도서입니다." 출력 후 넘어가기
//		if(bookArr[0] != null) {
//			System.out.println("이미 등록된 도서입니다");
//			break;
//		}
		boolean isEquals = false; // 중복 유무를 저장하기 위한 변수. false : 중복 없음 
		int i = 0; // bookArr를 0부터 끝까지 탐색하기 위한 index
		while(bookArr[i] != null) { // bookArr[i] = null 은 객체 생성이 안되어있음을 의미
			if(bookArr[i].getTitle().equals(title)) { // 제목이 같다
				isEquals = true;
				System.out.println("해당 도서는 이미 존재합니다");
				break;
			}
			i++; // 다음 인덱스의 값도 검사하기 위한 증감식
		} // 인덱스의 값이 null 이면 탈출
		
		if(!isEquals) { // 중복이 없다면 추가해주는 조건문 - 
			// 제목이 같은 조건에 대한 선행 조건문을 통해서 isEquals가 true 면 실행되지 않음.
			// while 문을 빠져나오고 비어있는 인덱스 i 에 값들을 넣어주면 됨
			bookArr[i] = new Book(title, author, date, number);
			System.out.println("도서 등록 완료");
			System.out.println(bookArr[i].toString());
		}
	}
	
	public void printAllBooks() {
		System.out.println("=============== 모든 도서 출력 ==============");
		for(int i = 0 ; bookArr[i] != null ; i++) {
			System.out.println((i + 1) + " 번째 도서 정보 : " + bookArr[i].toString());
		}
	}
}
