package test12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

public class PropTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("1", "apple,1200,3");
		prop.setProperty("2", "banana,2500,2");
		prop.setProperty("3", "grape,4500,5");
		prop.setProperty("4", "orange,800,10");
		prop.setProperty("5", "melon,5000,2");
	
		
		fileSave(prop);
		
		fileOpen(prop);
	}

	
	public static void fileSave(Properties p){
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("data.xml") ) ) {
			for(int i = 1 ; i <= p.size() ; i++) {
				bw.write(p.getProperty(String.valueOf(i)));
				bw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public static void fileOpen(Properties p) {
		Fruit[] fruit = new Fruit[p.size()];
		
		try(BufferedReader br = new BufferedReader(new FileReader("data.xml"))) {
			String value = null;
			int index = 0;
			while( (value = br.readLine() ) != null) {
				StringTokenizer stn = new StringTokenizer(value, ",");
				while(stn.hasMoreTokens()) {
					String name = stn.nextToken();
					int price = Integer.parseInt(stn.nextToken());
					int quantity = Integer.parseInt(stn.nextToken());
					fruit[index] = new Fruit(name, price, quantity);
					index++;
				}
				
			}
			
			for(int i = 0 ; i < fruit.length ; i++) {
				System.out.println(( i+1 ) + "" + fruit[i]);
			}
		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
