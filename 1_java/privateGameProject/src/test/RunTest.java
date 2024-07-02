package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RunTest {
	public static void main(String[] args) {
		
		Properties prop = new Properties();

		try {
			
			prop.store(new FileOutputStream("resources/driver.properties"), "properties test");

			
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "properties test");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
