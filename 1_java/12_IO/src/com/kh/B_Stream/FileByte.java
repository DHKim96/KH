package com.kh.B_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByte {
	/*
	 * "바이트 기반 스트림"을 통한 입출력해보기
	 * 
	 * 	1. 바이트 스트림 : 데이터를 1바이트 단위로 전송하는 통로(좁은 통로 -> 한글 깨짐)
	 * 	2. 기반 스트림 : 외부 매체와 직접적으로 연결하는 통로
	 * 	
	 * xxxInputStream : xxx매체로부터 데이터를 입력받는 통로(외부 데이터를 읽어오겠다.)
	 * 
	 * xxxOutputStream : xxx매체로부터 데이터를 출력하는 통로(외부 매체로 데이터를 내보내겠다.)
	 */
	
	// 프로그램(자바) -> 외부 매체(파일) 데이터를 출력(프로그램상의 데이터를 파일로 내보내겠다.)
	public void fileSave() {
		FileOutputStream fout = null;
		try {
			// 1. FileOutputStream 객체 생성 => 해당 파일과의 연결통로 만들기
			// 해당 파일이 없으면 새로 만들어주고 통로 연결 / 있으면 있는 파일로 통로 연결
			/*
			 *  true 미작성 시 => 해당 파일이 존재할 경우 기존의 데이터를 덮어씌움(기본값이 false)
			 *  true 작성 시 => 해당 파일이 존재할 경우 기존의 데이터에 이어서 작성
			 */
			fout = new FileOutputStream("a_Byte.txt", true);
			
			// 2. 파일에 데이터를 출력해보자 (입출력의 기준은 코드. 따라서 코드가 파일로 나가는 것이기에 출력임)
			// 		숫자를 출력하든 문자를 출력하든 실제로는 파일에 문자로 기록이 됨(아스키코드표)
			//		숫자는 0 ~ 127 까지만 기록됨
			// 		한글은 2byte짜리여서 깨져서 저장됨 => 바이트 스트림으로는 제한이 있음
			fout.write(98); // 'a' 문자가 저장
			fout.write('c'); // 'b' 문자가 저장
			fout.write('k');
			fout.write('i');
			fout.write('m');
			
			byte[] arr = {102, 103, 104};
			fout.write(arr); // cde 문자가 저장됨
			
			
			// fout.write(byte[], int off, int len)
			// 	: byte 배열의 off인덱스부터 len개만큼 출력
			fout.write(arr, 0, 1);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) { // 예외처리시 조상클래스가 같이 존재할때 순서 주의할 것
			e.printStackTrace();
		} finally { 
			// 이 안에 작성된 코드는 어떤 예외가 있더라도 마지막에 무조건 실행하고 빠져나가도록 함
			try {
				// 3. 스트림을 다 이용했으면 무조건 반납하기!(반드시!)
				fout.close(); // 닫아줘야함
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	// 외부 매체 -> 프로그램(자바) 데이터를 입력(파일로부터 데이터를 읽겠다)
	public void fileRead() {
		
		//FileInputStream : 파일로부터 데이터를 1바이트 단위로 입력받는 스트림
		
		// 1. 스트림 생성 (통로만들기)
		// 2. 스트림 통해서 입력받아옴(메소드 활용)
		// 3. 사용이 끝난 스트림 반납
		
		FileInputStream fin = null;
		
		try {
			// 1.FileInputStream 객체 생성 ==> 해당 파일과 연결 통로가 만들어짐
			fin = new FileInputStream("a_byte.txt");
			
			// 2. 파일로부터 데이터를 읽어들이고자 할 때 read() 메소드 사용
			//		1byte 단위로 하나씩 읽음 / 숫자로 읽어옴
//			System.out.println(fin.read()); 
//			System.out.println(fin.read());
//			System.out.println(fin.read());
//			System.out.println(fin.read());
//			System.out.println(fin.read());
//			
//			System.out.println(fin.read()); // 파일의 끝을 만나는 순간 -1을 반환함
			
			// 반복출력 1. 무한 반복을 돌리면서 매번 검사해보기
//			while(true) {
//				int value = fin.read();
//				if ( value == -1 ) {
//					break;
//				}
//				System.out.print((char)value);
//			}
//			
			// 반복출력 2.
			int value = 0 ;
			while( (value = fin.read() ) != -1) { // 먼저 value에 넣고 반환하기에 1번씩만 돌아감
				System.out.print((char)value); // 숫자로 리턴되는 값을 다시 캐릭터형으로 형변환하여 출력하면 문자로 보임
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fin.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
