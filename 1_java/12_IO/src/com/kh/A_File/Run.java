package com.kh.A_File;

import java.io.File;
import java.io.IOException;

public class Run {
	
	/*
	 *  간단하게 파일(File)을 만들어보자
	 *  java.io.File 클래스를 가지고 
	 *  ctrl + shift + o : 클래스 내 import 되지 않은 클래스를 찾아서 import 함
	 */
	public static void main(String[] args) {
		
	
		// 1. 경로지정을 딱히 하지않고 파일을 생성
		File f1 = new File("test.txt"); // 파일객체를 하나 만든 상태(실제 파일 x)
							// \ 하나만 하면 \t 로 인식되어 탭문자 처리됨
		
		// 2. 존재하는 폴더에 파일 생성 => 해당 경로까지 지정
		File f2 = new File("D:\\test.txt");
		
		
		// 3. 폴더 먼저 만들고 파일까지 만들어지게 하는 방법
		File tmpFolder = new File("D:\\tmp");
		tmpFolder.mkdir(); // 폴더가 만들어지게하는 메소드. make directory 의 준말
				
		File f3 = new File("D:\\tmp\\test.txt");
		
		try {
			f1.createNewFile(); // 파일객체에 담긴 정보를 통해서 실제 파일을 만들어주는 역할
			// 프로젝트 폴더 내에 test.text 파일명의 텍스트 파일 생성
			// 메소드까지 해줘야 파일이 생성됨
			f2.createNewFile();
			// 존재하지 않는 경로로 제시하면 IOException 발생
			
			f3.createNewFile();
			
			System.out.println(f1.exists()); // 파일의 존재 유무 확인하는 메소드
			System.out.println(new File("ttt.txt").exists());
			
			System.out.println(f1.isFile()); // 파일이 맞는지의 여부 확인하는 메소드
			System.out.println(tmpFolder.isFile());
			
			//=============================================================
			
			File folder = new File("parent"); // 도트.\는 현재 위치를 의미
			folder.mkdir();
			
			File file = new File("parent\\person.txt");
			file.createNewFile();
			
			System.out.println("파일명 : " + file.getName());
			System.out.println("절대경로 : " + file.getAbsolutePath());
			// 절대경로는 변하지 않는 경로를 의미. 사용자부터 c드라이브 ~ 파일이 있는 곳까지.
			
			System.out.println("파일 용량 : " + file.length());
			System.out.println("상위 폴더 : " + file.getParent());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		System.out.println("프로그램을 종료합니다.");
	}

}
