package com.kh.Inherit01;

public class Run {
	public static void main(String[] args) {
		BusinessMan man = new BusinessMan("kh", "강사", "지원");
//		man.name = "지원"; // BusinessMan 클래스에 name 이라는 멤버 변수가 없음에도~
//		man.tellYourName();
//		man.company = "kh";
//		man.position = "강사";
		man.tellYourInfo();
	}
}
