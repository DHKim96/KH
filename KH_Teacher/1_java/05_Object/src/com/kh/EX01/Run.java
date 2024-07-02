package com.kh.EX01;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		//두개의 인스턴스 객체가 생성된다.
		BankAccount lee = new BankAccount(); 
		BankAccount choi = new BankAccount();
		sc.next();
		
		//각각의 인스턴스 객체를 대상으로 예금을 진행
		lee.deposit(5000);
		choi.deposit(3000);
		
		//각각의 인스턴스 객체를 대상으로 출금 진행
		lee.withdraw(2000); // 5000 - 2000 => 3000
		choi.withdraw(2000); // 3000 - 2000 => 1000
		
		//각각의 인스턴스 객체의 잔액을 조회
		lee.checkMyBalance(); // 3000
		choi.checkMyBalance(); // 1000
		
		System.out.println(lee.balanceEquals(choi));
		
		choi.checkMyBalance(); // 0
		*/
		/*
		String st = new String("hello. by");
		BankAccount t = new BankAccount();
		t.test(st);
		System.out.println(st.hashCode());
		System.out.println(st); // 
		*/
		BankAccount choi2 = new BankAccount();
		BankAccount choi = new BankAccount("12-456-78", "123456-789456", 10000);
		
		
		BankAccount park = new BankAccount("12-446-78", "122256-789456");

	}

}
