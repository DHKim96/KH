package com.kh.Inherit01;

public class BusinessMan extends Man { // 의미적 연관 관계가 존재
	String company;
	String position;
	

	
	public BusinessMan(String company, String position, String name) {
		super(name); // 부모 생성자를 부를 때
		//인자로 문자열 하나를 전달받을 수 있는 부모 생성자
		// 없으면 부모의 디폴트 생성자 호출함

		// super.name = name; 부모 객체를 가리키는 참조 변수
		this.company = company; 
		this.position = position;
	}
	
	public void tellYourInfo() {
		System.out.println("My company is " + company);
		System.out.println("My position is " + position);
		super.tellYourName(); // 상속 받은 Man의 메서드를 사용. 제목과 도트 연산자 없이 호출한 것은 내 것이라는 의미
	}
}
