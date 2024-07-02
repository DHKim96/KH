package com.kh.B_Stream;

import java.io.Serializable;
//의도했는지 안했는지 확인하기 위한 용도 (실제로 Serializable의 문서를 확인하면 비어있음)
public class Product implements Serializable{ // 직렬화를 위한 인터페이스를 구현하겠다고 선언
	private String name;
	private int price;
	
	public Product() {
		
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	
}
