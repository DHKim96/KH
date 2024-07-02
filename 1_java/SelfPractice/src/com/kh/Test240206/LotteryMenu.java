package com.kh.Test240206;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class LotteryMenu {
	private Scanner sc;
	private LotteryController lc;
	
	public LotteryMenu() {
		sc = new Scanner(System.in);
		lc = new LotteryController();
	}
	
	public void mainMenu() {
		System.out.println("========== KH 추첨 프로그램 ==========");
		
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 추첨 대상 추가");
			System.out.println("2. 추첨 대상 삭제");
			System.out.println("3. 당첨 대상 확인");
			System.out.println("4. 정렬된 당첨 대상 확인");
			System.out.println("5. 당첨 대상 검색");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1 : this.insertObject();
				break;
			case 2 : this.deleteObject();
				break;
			case 3 : this.winObject();
				break;
			case 4 : this.sortedWinObject();
				break;
			case 5 : this.searchWinner();
				break;
			case 9 : System.out.println("프로그램 종료.");
				return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			}
		}
	}
	
	public void insertObject() {
		// 1. 추첨 대상 추가용 view 메소드
		System.out.println("******* 추첨 대상 추가 *******");
		System.out.print("추가할 추첨 대상 수 : ");
		int num = sc.nextInt();
		sc.nextLine();
		for (int i = 0 ; i < num ; i++) {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("핸드폰 번호('-'빼고) : ");
			String phone = sc.nextLine();
			Lottery l = new Lottery(name, phone);
			if ( !lc.insertObject(l) ){
				System.out.println("중복된 대상입니다. 다시 입력하세요.");
				i--; // 다시 받겠다
			}
		}
		System.out.println(num + "명 추가 완료되었습니다.");
		lc.showLotteryObject();
//		추가할 추첨 대상 수를 입력 받아 입력한 수만큼
//		추첨자 이름(String name)과 추첨자 핸드폰 번호(String phone)를 받고,
//		매개변수 생성자를 이용해 Lottery 객체에 추첨자 정보 저장.
//		Lottery 객체를 lc(LotteryController)의 insertObject로 전달하는데
//		단, 중복된 추첨 대상 입력했거나 또는 이미 추첨 Set에 대상이 있는 경우
//		“중복된 대상입니다. 다시 입력하세요.” 출력 후 이어서 다시 객체 입력.
//		모든 입력이 완료되면 “추가 완료되었습니다” 출력.
	}
	
	public void deleteObject() {
		// 2. 추첨 대상 삭제용 view 메소드
		System.out.println("***** 추첨 대상 삭제 *****");
		System.out.println("삭제할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone = sc.nextLine();
		if ( lc.deleteObject(new Lottery(name, phone) ) ) {
			System.out.println("삭제 완료 되었습니다.");
		}
		else {
			System.out.println("존재하지 않는 대상입니다.");
		}
		lc.showLotteryObject();
//		삭제할 대상의 이름과 핸드폰 번호를 받고 매개변수 있는 Lottery 생성자를 이용해
//		객체에 정보를 담아 lc에 객체를 보냄.
//		받은 결과에 따라 true면 “삭제 완료 되었습니다.”,
//		false면 “존재하지 않는 대상입니다.” 출력

	}
	
	public void winObject() {
		// 3. 당첨 대상 확인용 view 메소드
		System.out.println("***** 당첨 대상 확인 *****");
		HashSet<Lottery> winSet = lc.winObject();
		if(winSet != null) {
			System.out.println(winSet);
		}
		else {
			System.out.println("당첨 결과가 없습니다.");
		}
		lc.showWinObject();
//		lc에서 받아온 Set객체를 println()메소드를 통해 출력
	}
	
	public void sortedWinObject() {
		// 4. 정렬된 당첨 대상 확인
		System.out.println("***** 정렬된 당첨 대상 확인 *****");
		TreeSet<Lottery> sortedList = lc.sortedWinObject();
		if(sortedList.isEmpty()) {
			System.out.println("당첨 결과가 없습니다");
		}
		else {
			Iterator<Lottery> it = sortedList.iterator();
			while(it.hasNext()) {
				Lottery l = (Lottery)it.next();
				System.out.println(l);
			}
		}
////		lc에서 받아온 Set객체를 Iterator를 통해 출력
//Iterator it = hs2.iterator();
		
//		while(it.hasNext()) { // 다음에 가져올 값이 있을까?
//			Student s = (Student)it.next(); // 이터레이터의 반환값은 오브젝트
//			System.out.println(s);
	}
	
	public void searchWinner() {
		// 5. 당첨 대상 검색용 view 메소드
		System.out.println("***** 당첨 대상 검색 *****");
		System.out.println("검색할 대상의 이름과 핸드폰 번호를 입력하세요.");
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("핸드폰 번호('-'빼고) : ");
		String phone = sc.nextLine();
		if(lc.searchWinner(new Lottery(name, phone))) {
			System.out.println("축하합니다. 당첨 목록에 존재합니다.");
		}
		else {
			System.out.println("안타깝지만 당첨 목록에 존재하지 않습니다.");
		}
		
//		검색할 대상의 이름과 핸드폰 번호를 받고 매개변수 있는 Lottery 생성자를 이용해
//		객체에 정보를 담아 lc에 객체를 보냄.
//		받은 결과에 따라 true면 “축하합니다. 당첨 목록에 존재합니다.”,
//		false면 “안타깝지만 당첨 목록에 존재하지 않습니다.” 출력
	}
	
	
}
