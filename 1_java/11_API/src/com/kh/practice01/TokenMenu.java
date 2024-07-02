package com.kh.practice01;
import java.util.Scanner;
public class TokenMenu {
	private Scanner sc;
	private TokenController tc;
	
	public TokenMenu() {
		this.sc = new Scanner(System.in);
		this.tc = new TokenController();
	}
	
	public void mainMenu() {
		while(true) {
			System.out.println("1. 지정 문자열");
			System.out.println("2. 입력 문자열");
			System.out.println("3. 프로그램 끝내기");
			int select = sc.nextInt();
			sc.nextLine(); //버퍼지워주기
		
			switch(select) {
			case 1 : this.tokenMenu();
				break;
			case 2 : this.inputMenu();
				break;
			case 3 :
				System.out.println("프로그램을 종료합니다");
				sc.close();
				return;
			default :
				System.out.println("잘못입력하셨습니다 다시 입력해주세요");
		
			}
		}
	}
	
	public void tokenMenu() {
		String str = "J a v a P r o g r a m";
		System.out.println("토큰 처리 전 글자 : " + str);
		System.out.println("토큰 처리 전 개수 : " + str.length());
		
		String strAfter = tc.afterToken(str);
		
		System.out.println("토큰 처리 후 글자 : " + strAfter);
		System.out.println("토큰 처리 후 개수 : " + strAfter.length());
	
		System.out.println("모두 대문자로 변환 : " + strAfter.toUpperCase());
		System.out.println();
	}
	
	public void inputMenu() {
			System.out.println("문자열을 입력하세요 : ");
			String str = sc.nextLine();
			System.out.println("첫 글자 대문자 : " + 	tc.firstCap(str));
			System.out.println("찾을 문자를 하나 입력하세요 : ");
			char ch = sc.next().charAt(0);
			System.out.printf("%c 문자가 들어간 개수 : %d\n", ch, tc.findChar(str, ch));
			System.err.println();
	}
}
