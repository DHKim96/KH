package test_0214_03;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Test02 {
	public static void main(String[] args) {
		output();
	}
	
	public static void output() {
		
		FileWriter fw = null;
			try {
				fw = new FileWriter("test.txt");
				fw.write(97);
				fw.write(65);
				fw.write(112);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
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
}
