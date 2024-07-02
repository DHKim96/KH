package com.kh.Test240202.test12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropTest {

	public static void main(String[] args) {
		 Properties prop = new Properties(); 
		 //{1=apple,1200,3,  2=banana,2500,2,  3=grape,4500,5,  
		 // 4=orange,800,10,  5=melon,5000,2}
	      //명시한 사용 데이터를 prop 에 기록한다. 
		    prop.setProperty("1", "apple,1200,3");
	        prop.setProperty("2", "banana,2500,2");
	        prop.setProperty("3", "grape,4500,5");
	        prop.setProperty("4", "orange,800,10");
	        prop.setProperty("5", "melon,5000,2");
	        
	        /* prop 저장된 요소들을 Enumeration을 이용해 출력 */
//	        Enumeration enumeration = prop.propertyNames();// key만 모아서 가져오고 싶으면 propertyNames()
//	        
//
//	        while (enumeration.hasMoreElements()) { //아직 남은게 있는지 확인
//	        	
//	            String element = (String) enumeration.nextElement(); //key를 하나씩 뽑는다.
//	            System.out.println(element + "=" + prop.getProperty(element));
//	            //prop.getProperty(key) => value 가져오고 있다. 
//	        }
	 
	    // fileSave() 메소드를 호출한다. 
	        fileSave(prop);
	        
	    // fileOpen() 메소드를 호출한다.
	        fileOpen(prop);

	}
	
	public static void fileSave(Properties p) {
		try {
			p.storeToXML(new FileOutputStream("data.xml"), "Properties Example");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fileOpen(Properties p) {
		try {
			//data.xml파일에서 데이터를 읽어온다
			p.loadFromXML(new FileInputStream("data.xml"));
			
			Enumeration enumeration = p.propertyNames();// key만 모아서 가져오고 싶으면 propertyNames()
			Fruit[] fruitArr = new Fruit[p.size()]; 
			
			//String name, int price, int quantity
			for(Fruit f : fruitArr) {
				String key = (String) enumeration.nextElement();
				String value = p.getProperty(key); // "melon,5000,2"
				String[] values = value.split(","); //[melon, 5000, 2]
				f = new Fruit(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]));
				System.out.println(key + " = " + f.toString());
			}
			
			
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
