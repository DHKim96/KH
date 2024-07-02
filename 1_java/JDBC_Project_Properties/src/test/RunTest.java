package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RunTest {

	public static void main(String[] args) {
		// Properties
		
		/*
		 * Properties 특징 - Map 계열 컬렉션 (key value 세트로 담음; key, value 모두 필요)
		 * setProperty(key, value)
		 * getProperty(key) : value 반환
		 * 
		 * - 주로 외부 파일(.properties / .xml) 이용한 입출력 시 많이 사용 
		 */
		
		// 파일로 출력하는 것
		/*
		Properties prop = new Properties();
		
		prop.setProperty("C", "INSERT"); // 데이터 저장
		prop.setProperty("R", "SELECT"); // 데이터 읽기
		prop.setProperty("U", "UPDATE"); // 데이터 수정
		prop.setProperty("D", "DELETE"); // 데이터 삭제
		
		try {
//			prop.store(new FileOutputStream("resources/driver.properties"), "properties test");
			
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "properties test");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		
		// 파일로부터 읽어오기
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(prop.getProperty("U")); // 키 값을 통해 가져올 수 있음
		
		System.out.println(prop.getProperty("driver"));
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
