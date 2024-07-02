package com.kh.Test2402052;

import java.util.ArrayList;
import java.util.List;

public class BookController {
	private List<Book> list; // Book 제네릭 해주면 instanceof 안써도 됨

	public BookController() {
		this.list= new ArrayList<Book>();
		list.add(new Book("자바의 정석", "남궁 성", "기타", 20000));
		list.add(new Book("쉽게 배우는 알고리즘", "문병로", "기타", 15000));
		list.add(new Book("대화의 기술", "강보람", "인문", 17500));
		list.add(new Book("암 정복기", "박신우", "의료", 21000));	
	}
	
	public void insertBook(Book bk) {
		this.list.add(bk);
	}
	
	public ArrayList<Book> selectList() {
		
		return (ArrayList<Book>)(this.list); // 다운캐스팅
	}
	
	public ArrayList<Book> searchBook(String keyword) {
		ArrayList<Book> searchList = new ArrayList<Book>();
//		for (int i = 0 ; i < this.list.size() ; i++) {
//			if ( this.list.get(i).toString().contains(keyword) ) {
//				searchList.add(this.list.get(i));
//			}
//		}
//		return searchList;
		
		for (Object obj : list) { 
			if ( obj instanceof Book ) { // 서비스의 확장이 지속된다면 이렇게 예외처리를 해주는 편이 안전함
				Book book = (Book)obj;
				if (book.getTitle().contains(keyword) || book.getAuthor().contains(keyword) || book.getCategory().contains(keyword)) {
					searchList.add(book);
				}
			}
		}
		return searchList;

	}
	
	public Book deleteBook(String title, String author) {
		Book removeBook = new Book();
		removeBook = null;
//		for ( int i = 0 ; i < list.size() ; i++) {
//			 String[] arr = ((String)(list.get(i))).split("/");
//			 if ( arr[0].equals(title) && arr[1].equals(author)) {
//				list.get(i) = removeBook; // 대입어케?
//			 }
//		}
		
		// 배열에서 빼는 방법
		// 1. index 로 제거
		// 2. obj 로 제거
		
		for (Object obj : this.list) {
			if (obj instanceof Book) {
				removeBook = (Book)obj;
				if ( removeBook.getTitle().equals(title) && removeBook.getAuthor().equals(author)) {
					list.remove(removeBook);
					return removeBook;
				}
			}
		}
	return removeBook;
	}
	
	public int ascBook() {
		
//		for (int i = 0 ; i < list.size() ; i++) {
//			((Book) list.get(i)).compareTo((Book)list.get(i+1));
//		}
//		
//		// list의 오름차순 어떻게 구현?
		
		/*
		 * 문자열.compareTo => 두 문자열이 동일한 경우 : 0
		 * 					  사전적으로 먼저 위치한 문자열이 앞에 나온 경우 : 음수
		 * 					  사전적으로 먼저 위치한 문자열이 뒤에 나온 경우 : 양수
		 */
		
//		this.list.sort(new Comparator<Book>() {
//			@Override
//			public int compare(Book obj1, Book obj2) {
//				return obj1.getTitle().compareTo(obj2.getTitle());
//			}
//		}); // 이 로직 대신 람다식 사용 가능
		try {
			this.list.sort( (obj1, obj2) -> ( (Book)obj1 ).getTitle().compareTo( ( (Book)obj2 ).getTitle() ) );
			return 1;
		}
		catch(Exception e) { // 제대로 정렬이 되지 않을 경우
			return 0;
		}
	}
	
	
}
