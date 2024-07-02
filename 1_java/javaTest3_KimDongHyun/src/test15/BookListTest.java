package test15;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookListTest {
	public static void main(String[] args) {
		BookListTest test5 = new BookListTest();
		ArrayList<Book> list = new ArrayList<>();
		
		test5.storeList(list);
		
		
		
		test5.saveFile(list);
	}
	
	public void storeList(List<Book> list) {
		Book[] bArr = new Book[3];
		bArr[0] = new Book("자바의 정석", "남궁성", 30000, "도우출판", 0.15);
		bArr[1] = new Book("열혈강의 자바", "구정은", 29000, "프리렉", 0.2);
		bArr[2] = new Book("객체지향 JAVA8", "금영욱", 30000, "북스홈", 0.1);
		
		for (Book b : bArr) {
			list.add(b);
		}
		
		
	}
	
	public void saveFile(List<Book> list) {
		try(FileWriter fr = new FileWriter("books.dat")) {
			fr.write(list.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadFile(List<Book> list) {
		
	}
	
	public void printList(List<Book> list) {
		
	}
	
}
