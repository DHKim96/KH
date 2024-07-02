package com.kh.Test240208.list;

import java.util.Scanner;

public class MusicView {
	private Scanner sc;
	private MusicController mc;
	
	public MusicView() {
		sc = new Scanner(System.in);
		mc = new MusicController();
	}
	
	public void mainMenu() {
		System.out.println("******* 메인 메뉴 *******");
		while(true) {
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 :");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {
			case 1 : this.addList();
			System.out.println();
				break;
			case 2 :
				this.addAtZero();
				System.out.println();
				break;
			case 3 :
				this.printAll();
				System.out.println();
				break;
			case 4 :
				this.searchMusic();
				System.out.println();
				break;
			case 5 :
				this.removeMusic();
				System.out.println();
				break;
			case 6 :
				this.setMusic();
				System.out.println();
				break;	
			case 7 :
				this.ascTitle();
				System.out.println();
				break;	
			case 8 :
				this.descSinger();
				System.out.println();
				break;
			case 9 : System.out.println("프로그램 종료.");
				return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			System.out.println();
			}
		}
	}
	
	public void addList() {
		System.out.println("******* 마지막 위치에 곡 추가 *******");	
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		System.out.print("가수명 : ");
		String singer = sc.nextLine();
		if ( mc.addList(new Music(title, singer)) == 1 ) {
			System.out.println("곡을 추가했습니다.");
		}
		else {
			System.out.println("이미 존재하는 곡입니다.");
		}
	}
	
	public void addAtZero() {
		System.out.println("******* 첫 위치에 곡 추가 *******");
		System.out.print("곡명 : ");
		String title = sc.nextLine();
		System.out.print("가수명 : ");
		String singer = sc.nextLine();
		if ( mc.addAtZero(new Music(title, singer)) == 1 ) {
			System.out.println("곡을 추가했습니다.");
		}
		else {
			System.out.println("이미 존재하는 곡입니다.");
		}
	}
	
	public void printAll() {
		System.out.println("******* 전체 곡 목록 출력 *******");
		for (Music m : mc.printAll()) {
			System.out.println(m.toString());
		}
	}
	
	public void searchMusic() {
		System.out.println("******* 특정 곡 검색 *******");
		System.out.println("곡명 : ");
		String title = sc.nextLine();
		Music music = mc.searchMusic(title);
		if ( music.equals(null) ) {
			System.out.println("검색한 곡은 " + music + "입니다");
		}
		else {
			System.out.println("검색한 곡이 없습니다.");
		}
	}
	
	public void removeMusic() {
		System.out.println("******* 특정 곡 삭제 *******");
		System.out.println("곡명 : ");
		String title = sc.nextLine();
		
		Music music = mc.removeMusic(title);
		if ( music.equals(null) ) {
			System.out.println("삭제할 곡이 없습니다.");
		}
		else {
			System.out.println(music + "을 삭제했습니다.");
		}
	}
	
	public void setMusic() {
		System.out.println("******* 특정 곡 정보 수정 *******");
		System.out.println("곡명 : ");
		String title = sc.nextLine();
		System.out.println("가수명 : ");
		String singer = sc.nextLine();
		Music music = mc.setMusic(title, new Music(title, singer));
		if ( music.equals(null) ) {
			System.out.println("수정할 곡이 없습니다.");
		}
		else {
			System.out.println(music + "의 값이 변경 되었습니다");
		}
	}
	
	public void ascTitle() {
		System.out.println("******* 곡명 오름차순 정렬 *******");
		if ( mc.ascTitle() == 1 ) {
			System.out.println("정렬 성공");
		}
		else {
			System.out.println("정렬 실패");
		}
	}
	
	public void descSinger(){
		System.out.println("******* 가수명 내림차순 정렬 *******");
		if ( mc.descSinger() == 1 ) {
			System.out.println("정렬 성공");
		}
		else {
			System.out.println("정렬 실패");
		}
	}

}
