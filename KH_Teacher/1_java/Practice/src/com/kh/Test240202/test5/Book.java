package com.kh.Test240202.test5;

public class Book {
	private String title;
	private String author;
	private int price;
	private String publisher;
	private double discoutRate;
	public Book() {
		super();
	}
	public Book(String title, String author, int price, String publisher, double discoutRate) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.discoutRate = discoutRate;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public double getDiscoutRate() {
		return discoutRate;
	}
	public void setDiscoutRate(double discoutRate) {
		this.discoutRate = discoutRate;
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + ", publisher=" + publisher
				+ ", discoutRate=" + discoutRate + "]";
	}
	
}
