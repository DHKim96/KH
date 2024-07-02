package com.kh.Test240125;

public class Member {
	private String name;// 회원명
	private int age;// 회원나이
	private char gender;// 성별
	private int couponCount;//요리학원쿠폰개수 = 0
	
	
	public Member() {
		super();
	}

	public Member(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.couponCount = 0;
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(int couponCount) {
		this.couponCount = couponCount;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", gender=" + gender + ", couponCount=" + couponCount + "]";
	}
	
}
