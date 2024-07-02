package com.kh.Test240202.test4;

import java.util.Scanner;

public class ProductTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("상품명을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("가격을 입력하세요 : ");
		int price = sc.nextInt();
		
		System.out.print("개수을 입력하세요 : ");
		int quantity = sc.nextInt();
		
		Product ph = new Product(name, price, quantity);
		
		System.out.println(ph.information());
		System.out.println("총 구매 가격 : " + (ph.getPrice() * ph.getQuantity()) + " 원");
		
		

	}

}
