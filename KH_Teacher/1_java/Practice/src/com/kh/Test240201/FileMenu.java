package com.kh.Test240201;

import java.util.Scanner;

public class FileMenu {
	Scanner sc = new Scanner(System.in);
	FileController fc = new FileController();

	public void mainMenu() {
		while(true) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기");
			System.out.println("2. 노트 열기");
			System.out.println("3. 노트 열어서 수정하기");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				fileSave();
				break;
			case 2:
				fileOpen();
				break;
			case 3:
				fileEdit();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void fileSave() {
		StringBuilder content = new StringBuilder();
		
		
		while(true) {
			System.out.println("파일에 저장할 내용을 입력하세요. ");
			System.out.println("ex끝it  이라고 입력하면 종료됩니다. ");
			System.out.print("내용 : ");
			String line = sc.nextLine();
			if (line.equals("ex끝it")) {
				break;
			} else {
				content.append(line).append("\n");	
			}
		}
		
		while(true) {
			System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
			String fileName = sc.nextLine();
			
			if (fc.checkName(fileName)) { // 파일명이 존재한다면
				System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) : ");
				boolean isTrue = sc.next().toLowerCase().charAt(0) == 'y';
				sc.nextLine();
				
				if(isTrue) { // y를 입력시 -> 덮어쓰기
					fc.fileSave(fileName, content);
					break;
				} 
			} else {
				fc.fileSave(fileName, content);
				break;
			}
		}
		
	}

	public void fileOpen() {
		System.out.print("열 파일 명 :");
		String file = sc.nextLine();
		
		if(fc.checkName(file)) {
			StringBuilder content = fc.fileOpen(file);
			System.out.println(content);
		} else {
			System.out.println("없는 파일입니다.");
		}
	}

	public void fileEdit() {
		System.out.print("수정할 파일 명 :");
		String file = sc.nextLine();
		
		if(fc.checkName(file)) {
			StringBuilder content = new StringBuilder();
			
			while(true) {
				System.out.println("파일에 저장할 내용을 입력하세요. ");
				System.out.println("ex끝it  이라고 입력하면 종료됩니다. ");
				System.out.print("내용 : ");
				String line = sc.nextLine();
				if (line.equals("ex끝it")) {
					break;
				} else {
					content.append(line).append("\n");	
				}
			}
			
			fc.fileEdit(file, content);
			
		} else {
			System.out.println("없는 파일입니다.");
		}
	}
}
