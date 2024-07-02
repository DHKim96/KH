package com.kh.Test240205;

public class Human {
	//필드
	String name;
	int age;
	
	//생성자
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	//메소드
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
	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}
	
}
