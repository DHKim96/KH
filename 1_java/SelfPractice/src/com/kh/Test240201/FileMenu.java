package com.kh.Test240201;

import java.util.Scanner;

public class FileMenu {
	private Scanner sc;
	private FileController fc;
	
	public FileMenu() {
		this.sc = new Scanner(System.in);
		this.fc = new FileController(); 
	}
	
	public void mainMenu() {
		
			while(true) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int select = sc.nextInt();
			sc.nextLine(); // 혹시라도 이후에 nextLine 나올 경우 버퍼에 남은 개행문자로 인해 의도하지 않은 결과가 나오는 것을 방지하기 위함
			
			switch(select) {
			case 1 : this.fileSave();
				break;
			case 2 : this.fileOpen();
				break;
			case 3 : this.fileEdit();
				break;
			case 9 : System.out.println("프로그램을 종료합니다");
				return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
		}
		
		}
	}
	
	public void fileSave() {
		StringBuilder sb = new StringBuilder();
		String str = "";
		
		while(true) {
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			str = sc.nextLine();
			if(str.equals("ex끝it")) {
				System.out.println("종료합니다.");
				break;
			} else {
				sb.append(str).append("\n");
			}
		}
		while(true) {
			System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) :");
			String str2 = sc.nextLine();
			if ( fc.checkName(str2) ) {
				System.out.println("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) :");
				char ch = sc.next().charAt(0);
				if (ch == 'y') {
					fc.fileSave(str2, sb);
					break;
				} else {
					System.out.println("잘못입력하셨습니다 다시 입력해주세요");
				}
			}
			else {
				fc.fileSave(str2, sb);
				break;
			}
		}
	}
	
	public void fileOpen() {
		System.out.println("열 파일 명 : ");
		String st = sc.nextLine();
		if ( fc.checkName(st) ) {
			System.out.println(fc.fileOpen(st)); //StringBuilder도 toString 오버라이딩되어있기에 출력 문제없음
		}
		else {
			System.out.println("없는 파일입니다.");
			return;
		}
	}
	
	public void fileEdit() {
		System.out.println("수정할 파일 명 : ");
		String st = sc.nextLine();
		
		if (fc.checkName(st)) {
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				System.out.println("파일에 저장할 내용을 입력하세요.");
				System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
				System.out.print("내용 : ");
				String str = sc.nextLine();
				if(str.equals("ex끝it")) {
					System.out.println("종료합니다.");
					fc.fileEdit(st, sb);
					return;
				} else {
					sb.append(str).append("\n");
				}
			}
		}
		else {
			System.out.println("없는 파일입니다.");
			return;
		}
		
	}
}
