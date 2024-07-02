package com.kh.Test240125;

public class AniBook extends Book{
	private int accessAge; // 제한나이

	
	public AniBook() {
		super();
	}

	public AniBook(String title, String author, String publisher, int accessAge) {
		super(title, author, publisher);
		this.accessAge = accessAge;
	}
	

	public int getAccessAge() {
		return accessAge;
	}

	public void setAccessAge(int accessAge) {
		this.accessAge = accessAge;
	}

	@Override
	public String toString() {
		return super.toString() + " / " + accessAge;
	}
	
}
