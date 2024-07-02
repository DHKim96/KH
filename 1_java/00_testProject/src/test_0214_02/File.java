package test_0214_02;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class File {
	public void fileSave(String fileName) {
		Food food1 = new Food("사과", 20);

		try( FileOutputStream fos = new FileOutputStream(fileName);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)	) {
			
			oos.writeObject(food1);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
