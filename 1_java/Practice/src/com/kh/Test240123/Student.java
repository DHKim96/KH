package com.kh.Test240123;

public class Student {
	private String name;
	private int math;
	private int korean;
	private int english;
	
	public Student(String name, int math, int korean, int english) {
		super();
		this.name = name;
		this.math = math;
		this.korean = korean;
		this.english = english;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}
	
	public double getAvg() {
		return (this.math + this.korean + this.english) / 3.0;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", math=" + math + ", korean=" + 
					korean + ", english=" + english + ", avg = "+ this.getAvg() + "]";
	}
	
}
