package com.kh.Test240126;

public interface Phone {
	public static final char[] NUMBERPAD = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '0', '#'
	};
	//인터페이스에서 필드 멤버는 무조건 final 상수이기에 스태틱 파이널 생략 가능
	
	public String makeCall(); // 전화 걸기
	public String takeCall(); // 전화 받기
}
