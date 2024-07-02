package com.kh.EX02;
/*
 * 이름 나이 수학점수 영어점수 국어점수를 데이터로 가지고 있는 객체를 만들기 위한 클래스를 작성해라
 * 데이터는 직접 접근을 허용하지 않고, 모두 간접적으로 set/get해줄 수 있도록 작성해라
 * 모든 데이터는 매개변수로 받아 초기화하면서 객체를 생성할 수 있는 생성자를 작성
 */
public class Student {
	private String name;
	private int age;
	private int mathScore;
	private int englishScore;
	private int koreanScore;
	
	public Student(String name, int age, int mathScore, int englishScore, int koreanScore) {
		this.name = name;
		this.age = age;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		this.koreanScore = koreanScore ;
	}
	
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
	
	public int getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	
	public int getKoreanScore() {
		return koreanScore;
	}
	public void setKoreanScore(int koreanScore) {
		this.koreanScore = koreanScore;
	}
	
	public int getEverage() {
		int everage = (this.englishScore + this.koreanScore + this.mathScore) / 3;
		return everage; 
	}
	
}
