package com.kh.B_Stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServeStream {

	/*
	 * 보조스트림 : 기반스트림만으로 부족했던 성능을 보다 향상시켜주는 스트림
	 * 			 기반스트림에서 제공하지 않는 추가적인 메소드 제공 / 데이터 전송 속도를 향상시켜준다
	 *     >> 외부매체와 직접적으로 연결되는 스트림이 아니다.(단독사용 불가 -> 반드시 기반스트림과 함께 사용)
	 */
	
	// 프로그램 -> 파일(출력)
	public void fileSave() {
		// FileWriter : 파일과 직접적으로 연결해서 2바이트 단위로 출력할 수 있는 기반 스트림
		// BufferedWriter : 속도향상에 도움을 주는 보조스트림
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt"))){
			/*
			// 1. 기반스트림먼저 생성
			FileWriter fw = new FileWriter("c_buffer.txt");
			
			// 2. 보조스트림 생성시 기반ㅅ그트림 객체를 전달하면서 생성
			BufferedWriter bw = new BufferedWriter(fw);
			*/
			
			bw.write("안녕하세요.\n");
			bw.write("반갑습니다.");
			bw.newLine(); // 새로운 메소드 사용가능
			bw.write("끝");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void fileRead() {
		
		//FileReader : 파일과 연결해서 2바이트 단위로 데이터를 입력받을 수 있는 객체
		
		try (BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))){
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
//			System.out.println(br.readLine());
			
			String value = null;
			while((value = br.readLine()) != null) {
				System.out.println(value);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	// 프로그램 -> 파일 출력
	public void obejectSave() {
		
		//출력할 데이터 (Product객체)
		Product phone1 = new Product("아이폰1", 1000000);
		Product phone2 = new Product("아이폰2", 2000000);
		Product phone3 = new Product("아이폰3", 3000000);
		
		//FileOutputStream : 파일과 연결해서 1바이트 단위로 출력할 수 있는 기반스트림
		//ObjectOutputStream : 객체 단위로 출력할 수 있도록 도움을 주는 보조스트림(ObjectWriter 없음)
		
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d_product.txt"))){
			
			oos.writeObject(phone1);
			oos.writeObject(phone2);
			oos.writeObject(phone3);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void objectRead() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d_product.txt"))){
			while(true) {
				System.out.println(ois.readObject());
			}
			
		} catch (EOFException e) {
			System.out.println("파일을 다 읽어들였습니다.");
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
