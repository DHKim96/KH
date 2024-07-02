package com.kh.Test240125;

import java.util.Scanner;

public class LibraryMenu {
	LibraryController lc;
	Scanner sc;
	
	public LibraryMenu() {
		lc = new LibraryController();
		sc = new Scanner(System.in);
	}
	
	public void mainMenu() {
		String name;
		int age;
		char gender;
		
		System.out.print("이름 : ");
		name = sc.next();
		System.out.print("나이 : ");
		age = sc.nextInt();
		System.out.print("성별 : ");
		gender = sc.next().toLowerCase().charAt(0);
		
		Member m = new Member(name, age, gender);
		lc.insertMember(m);
		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			
			int menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1:
				System.out.println(lc.myInfo());
				break;
			case 2:
				this.selectAll();
				break;
			case 3:
				this.searchBook();
				break;
			case 4:
				this.rentBook();
				break;
			case 9:
				System.out.println("프로그램 종료합니다.");
				sc.close();
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
			
		}
	}
	
	public void selectAll() {
		// LibraryController의 selectAll()메소드 호출하여 결과 값 Book[] 자료형 bList에 담기
		Book[] bList = lc.selectAll();
		// for문 이용하여 bList의 모든 도서 목록 출력
		for (int i = 0; i < bList.length; i++) {
			if (bList[i] == null) {
				break;
			}
			// 단, i를 이용하여 인덱스도 같이 출력 → 대여할 때 도서번호를 알기 위해
			System.out.println(i + "번도서 : " + bList[i].toString());
		}
	}
	
	public void searchBook() {
		System.out.print("검색할 제목 키워드 : ");
		String keyword = sc.next();
		Book[] searchList = lc.searchBook(keyword);
		
		for (int i = 0; searchList[i] != null; i++) {
			
			// 단, i를 이용하여 인덱스도 같이 출력 → 대여할 때 도서번호를 알기 위해
			System.out.println(i + "번도서 : " + searchList[i].toString());
		}
	}
	
	public void rentBook() {
		this.selectAll();
		
		System.out.print("대여할 도서 번호 선택 : ");
		int index = sc.nextInt();
		int result = lc.rentBook(index);
		
		if (result == 0) {
			System.out.println("성공적으로 대여되었습니다.");
		} else if(result == 1) {
			System.out.println("나이제한으로 대여 불가능합니다.");
		} else if(result == 2) {
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니\n마이페이지에서 확인하세요");
		}
	}
}
