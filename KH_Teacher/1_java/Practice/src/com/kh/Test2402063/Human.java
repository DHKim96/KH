package com.kh.Test2402063;

public class Human {
	//필드
	// 접근제한자 자료형 변수이름
	private String name;
	private int age;
	private int mathScore;
	private int enScore;
	
	//생성자
	//접근제한자 생성자명(매개변수){초기화}
	public Human() {
		super();
	}

	public Human(String name, int age, int mathScore, int enScore) {
		super();
		this.name = name;
		this.age = age;
		this.mathScore = mathScore;
		this.enScore = enScore;
	}

	//메소드
	//접근제한자 (static) 반환형 메소드이름(매개변수){메소드내용}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getEnScore() {
		//반환형 : 리턴뒤에 어떤타입이 오냐?
		// 	      함수의 결과값으로 어떤 값을 보낼꺼냐?
		return enScore;
	}

	public void setEnScore(int enScore) {
		this.enScore = enScore;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + ", mathScore=" + mathScore + ", enScore=" + enScore + "]";
	}
	
}
