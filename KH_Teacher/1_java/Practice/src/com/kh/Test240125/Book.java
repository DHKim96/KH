package com.kh.Test240125;

public class Book {
	private String title;// 도서명
	private String author;// 저자명
	private String publisher;// 출판사명
	
	public Book() {
		super();
	}

	public Book(String title, String author, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return title + " / " + author + " / " + publisher;
	}

}
