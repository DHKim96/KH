package com.kh.Test240126;

public interface Phone {
	static final char[] NUMBERPAD = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '*', '0', '#'};
  	public abstract String makeCall(); // 전화 걸기
  	public abstract String takeCall(); // 전화 받기
}
