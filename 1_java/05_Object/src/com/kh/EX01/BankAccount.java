package com.kh.EX01;

public class BankAccount {
	//필드(클래스의 데이터를 정의하는 곳)
		int balance = 0;
		String accNumber;
		String ssNumber;
		
		//생성자(데이터 초기화를 위한 특수목적 메소드)
		//생성자는 class와 이름이 동일한 메소드이다.
		//반환형이 존재하지 않는다.
		//아무것도 만들지 않으면(아래와 같이) 컴파일러가 자동으로 기본 생성자를 만들어준다.
		/*
		 * public BankAccount() {
		 * }
		 */
		
	public BankAccount() {
		
	}
		
		
	public BankAccount(String accNumber, String ssNumber, int bal) {
			this.accNumber = accNumber;
			this.ssNumber = ssNumber;
			this.balance = bal;
			//this. => 객체 자체의 필드값에 접근하는 방법
	}
	
	public BankAccount(String accNumber, String ssNumber) { //메소드 오버로딩
		this(accNumber, ssNumber, 0);
//		accNumber = acc;
//		ssNumber = ss;
//		balance = 0;
		// 위의 변수들 대신 this(acc,ss,0); 도 가능.
		// this() => 생성자에서 다른 생성자를 호출해주는 것. 항상 최상단에 위치해있어야 함
}
		
		//데이터 초기값 세팅을 위한 메소드 생성
	public void inItAccount(String accNumber, String ssNumber, int balance) {
		this.accNumber = accNumber;
		this.ssNumber = ssNumber;
		this.balance = balance;
	}
	
		
	public int deposit(int amount) {
		balance += amount;
		return balance;
	}
	
	public int withdraw(int amount) {
		balance -= amount;
		return balance;
	}
	
	public int checkMyBalance() {
		System.out.println("잔액 : " + balance);
		return balance;
	}
	
	public boolean balanceEquals(BankAccount act01) {
		if(balance == act01.balance) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
