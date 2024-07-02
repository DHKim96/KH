package com.kh.Test240207;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MemberMenu {
	private Scanner sc;
	private MemberController mc;
	
	public MemberMenu() {
		sc = new Scanner(System.in);
		mc = new MemberController();
	}
	
	public void mainMenu() {
		System.out.println("========== KH 사이트 ==========");
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1 : this.joinMembership();
				break;
			case 2 :
				this.logIn();
				this.memberMenu();
				break;
			case 3 : this.sameName();
				break;
			case 9 : System.out.println("프로그램 종료.");
				return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
	}
	
	public void memberMenu() {
		while(true) {
			System.out.println("******* 회원 메뉴 *******");
			System.out.println("1. 비밀번호 바꾸기");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃 ");
			System.out.print("메뉴 번호 선택 : ");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {
			case 1 : this.changePassword();
				break;
			case 2 : this.changeName();
				break;
			case 3 : System.out.println("로그아웃 되었습니다.");
				return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
		
	}
	
	public void joinMembership() {
		System.out.println("***** 회원 가입 *****");
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			if( mc.joinMembership( id, new Member(password, name) ) ) {
				System.out.println("성공적으로 회원가입 완료하였습니다.");
				return;
			}
			else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void logIn() {
		while(true) {
		System.out.println("***** 로그인 *****");
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
			if ( mc.login(id, password) != null ) {
				System.out.println( mc.login(id, password) + "님 환영합니다!");
				return;
			}
			else {
				System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요");
			}
		}
	}
	
	public void changePassword() {
		while(true) {
			System.out.println("**** 비밀번호 바꾸기 ****");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String oldPw = sc.nextLine();
			System.out.print("변경할 비밀번호 : ");
			String newPw = sc.nextLine();
			if ( mc.changePassword(id, oldPw, newPw) ) {
				System.out.println("비밀번호 변경에 성공했습니다.");
				return;
			}
			else {
				System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void changeName() {
		while(true) {
			System.out.println("**** 이름 바꾸기 ****");
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String password = sc.nextLine();
			String name = mc.login(id, password);
			if (name != null) {
				System.out.println( name );
				mc.changeName(id, name );
				return;
			}
			else {
				System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요");
			}
		}
		
	}
	
	public void sameName() {
		System.out.println("**** 같은 이름 회원 찾기 ****");
//		System.out.print("검색할 이름 : ");
//		String searchName = sc.nextLine();
//		
//		TreeMap sameName = mc.sameName(searchName);
//		Set entrySet = sameName.entrySet();
//		Iterator itEntry = entrySet.iterator();
//		while(itEntry.hasNext()) {
//			Entry entry = (Entry)itEntry.next();
//			System.out.println( entry.getKey() + "-" + entry.getValue() );
//		}
		System.out.print("검색할 이름 : ");
		String name = sc.nextLine();
		
		TreeMap result = mc.sameName(name);
		if (result.isEmpty()) {
			System.out.println("회원을 찾지 못하였습니다.");
		} else {
			
			for (Object entry : result.entrySet()) {
				Entry<String, String> en = (Entry)entry;
				System.out.println(en.getValue() + "-" + en.getKey());
			}
		}
	}

	
}
