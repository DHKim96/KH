package com.kh.Test240125;
import java.util.Scanner;

public class LibraryMenu {
	private LibraryController lc;
	private Scanner sc;
	
	public LibraryMenu() {
		this.lc = new LibraryController();
		this.sc = new Scanner(System.in);
	}
	
	public void mainMenu() {
		Member mem = new Member();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		mem.setName(name);
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		mem.setAge(age);
		
		System.out.print("성별 : ");
		char gender = sc.next().toUpperCase().charAt(0);
		mem.setGender(gender);
		
		// 또는 Member m = new Member(name, age, gender);
		lc.insertMember(mem);
		
	
		int select = 0;
		while(select != 9) {
			
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("9. 프로그램 종료하기");
			System.out.print("메뉴 번호 : ");
			select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1 : System.out.println(lc.myInfo());
				break;
			case 2 : this.selectAll();
				break;
			case 3 : this.searchBook();
				break;
			case 4 : this.rentBook();
				break;
			case 9 :
				System.out.println("프로그램이 종료되었습니다");
				sc.close();
				return;
			default :
				System.out.println("잘못된 번호입니다 다시 입력해주세요");
				break;
			}
		}
	}
	
	public void selectAll() {
		Book[] bList = lc.selectAll();
		for(int i = 0 ; i < bList.length ; i++) {
			if (bList[i] == null) { // 예외처리를 해주는 코드를 항상 만들어줄것 . 사용자가 에러를 체험하지 않도록
				break;
			}
			System.out.println(i + "번 도서 : " + bList[i]);
		}
	}
	
	public void searchBook() {
		Book[] myList;
		System.out.print("검색할 제목 키워드 : ");
		String keyword = sc.nextLine();
		myList = lc.searchBook(keyword);
		for(int i = 0 ; myList[i] != null ; i++) {
			System.out.println(myList[i]);
		}
	}
	
	public void rentBook() {
		this.selectAll();
		
		System.out.print("대여할 도서 번호 선택 : ");
		int index = sc.nextInt();
		sc.nextLine();
		
		int result = lc.rentBook(index);
		
		switch(result) {
		case 0 :
			System.out.println("성공적으로 대여되었습니다");
			break;
		case 1 :
			System.out.println("나이 제한으로 대여 불가능입니다");
			break;
		case 2 :
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
			break;
		}
		
	}
}
