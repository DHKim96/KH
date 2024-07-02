package com.kh.Test2401232;

import java.util.Scanner;

public class Library {
	//도서관리프로그램
	Book[] bookArr;
	Scanner sc;
	
	public Library() {
		this.bookArr = new Book[100]; // bookArr는 Book참조변수 100개를 가지고있는 배열
		this.sc = new Scanner(System.in);
	}
	
	public void startLibrary() {
		int choice = 0;
		while(choice != 9){
			System.out.println("=================== 도서관리프로그램 ==============");
			System.out.println("1. 도서등록");
			System.out.println("2. 모든도서출력");
			System.out.println("9. 종료");
			System.out.print("메뉴 입력 : ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: // 도서등록
				this.insertBook();
				break;
			case 2: //모든 도서출력
				this.allPrintBook();
				break;
			}
		}
		
	}
	
	public void insertBook() {
		String title, author, date;
		int number;
		
		System.out.print("제목 : ");
		title = sc.next();
		
		System.out.print("작가 : ");
		author = sc.next();
		
		System.out.print("발행일 : ");
		date = sc.next();
		
		System.out.print("책 번호 : ");
		number = sc.nextInt();
		
		//제목이 똑같은 책이 있다면 생성하지말고 "이미 등록된 도서입니다."출력후 넘어가기
		boolean isEquals = false; // -> 중복이 있냐 없냐를 저장하기위한 변수 flase -> 중복없음
		int i = 0; // bookArr을 0부터 끝까지 탐색하기위한 index
		while(bookArr[i] != null) { // bookArr[i] == null => bookArr[i]가 가르키는 메모리가 존재하지 않는다. -> 객체생성이 안되어있다.
			if (bookArr[i].getTitle().equals(title)) { // 사용자가 입력한 title과 bookArr[i]객체에 들어있는 title이 같다면
				isEquals = true; // 중복찾았다라는 정보를 저장
				break;
			}
			i++; // 다음인덱스 값을 검사하기위해 i -> 1증가
		}
		// isEquals : false -> 중복이 없다 -> 생성해야한다.
		// isEquals : true -> 중복이 있다.
		if (!isEquals) { // 중복이 없다면 객체 추가생성
			bookArr[i] = new Book(title, author, date, number);
			System.out.println("도서 등록 완료");
			System.out.println("도서 정보 : " + bookArr[i].toString());
			//bookArr[0] -> bookArr[1] -> bookArr[2]
		} else {
			System.out.println("해당 도서는 이미 존재합니다.");
		}
	}
	public void allPrintBook() {
		System.out.println("==============모든 도서 목록============");
		for (int i = 0; i < bookArr.length; i++) {
			if (bookArr[i] == null) {
				break;
			}
			System.out.println(bookArr[i].toString());
		}
	}
}
