package com.kh.B_Stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileChar {
	/*
	 *  "문자 기반 스트림"을 활용하여 입출력 해보자
	 *  
	 *  - 문자스트림 : 데이터를 2바이트단위로 전송하는 통로
	 *  - 기반스트림 : 외부매체와 직접적으로 연결되는 통로
	 *  
	 *  xxxReader : 입력용 스트림
	 *  xxxWriter : 출력용 스트림
	 */
	
	// 프로그램 --> 파일 (출력)
	public void fileSave() {
		// FileWriter : 파일로 데이터를 2바이트 단위로 출력할 수 있는 스트림
		FileWriter fw = null;
		
		try {
			// 1. FileWriter 객체 생성
			fw = new FileWriter("b_char.txt"); // 해당파일이 없으면 새로 만들고 연결 / 있으면 그냥 연결
			
			// 2. write메소드를 활용하여 데이터 출력
			fw.write("와후 IO가 너무 재미있다."); //실제로는 해당 문자열의 문자가 하나씩 하나씩 전송되는 개념
			fw.write(" ");
			fw.write('A');
			fw.write("\n");
			
			char[] arr = {'a','p','p','l','e'};
			fw.write(arr);
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void fileRead() {
		//FileReader : 파일로부터 데이터를 2바이트 단위로 입력받을 수 있는 스트림
		
		// 알아서 try가 다 처리되면 해당 스트림을 반납한다.
		try(FileReader fr = new FileReader("b_char.txt")) {
			// 1.FileReader객체생성 -> 파일로부터 데이터를 읽어들일 수 있는 통로 연결!
			
			
			// 2. read메소드를 이용해서 파일을 읽어들이자!
			// 파일의 끝을 만나는 순간 -1반환
			int value = 0;
			while((value = fr.read()) != -1) {
				System.out.print((char)value);	
			} 
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * try-with-resource구문 => 자원을 자동으로 반납해준다.
		 * 
		 * try(try에서 사용할 스트림객체 생성구문){
		 * 
		 * } catch(예외클래스 e){
		 * 
		 * }
		 */
		
		
		
	}
}
