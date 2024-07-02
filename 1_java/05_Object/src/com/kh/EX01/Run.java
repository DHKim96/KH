package com.kh.EX01;

public class Run {
	public static void main(String[] args) {
//		//두 개의 인스턴스 객체가 생성됨
//		BankAccount kim = new BankAccount();
//		BankAccount dong = new BankAccount();
//		
//		//각각의 인스턴스 객체를 대상으로 예금 진행
//		kim.deposit(5000);
//		dong.deposit(3000);
//		
//		//각각의 인스턴스 객체를 대상으로 출금 진행
//		kim.withdraw(2000);
//		dong.withdraw(2000);
//		
//		//각각의 인스턴스 객체의 잔액 조회
//		kim.checkMyBalance();
//		dong.checkMyBalance();
//		
//		System.out.println(kim.balanceEquals(dong));// 잔액 비교
		
		BankAccount kim = new BankAccount("12-456-78", "960207", 1000);// BankAccount 라는 참조 자료형의 kim 이라는 인스턴스 객체 생성
		BankAccount dong = new BankAccount("12-968-10", "920609");
		
//		kim.inItAccount("12-456-78", "960207" , 10000); // 객체를 대상으로 BankAccount  클래스의 inItAccount 메소드 호출
//		
//		dong.inItAccount("12-968-10", "920609" , 0); // 객체를 대상으로 BankAccount  클래스의 inItAccount 메소드 호출
//		
		
	}
}
