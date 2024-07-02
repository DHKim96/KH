package com.kh.practice01;

import java.util.StringTokenizer;

public class TokenController {
	public TokenController() {
		
	}
	
	public String afterToken(String str) {
		// str 공백을 토큰으로 처리한 문자열 반환
		StringTokenizer tokenizer = new StringTokenizer(str);
		String newStr = "";
		while(tokenizer.hasMoreTokens()) {
			newStr += tokenizer.nextToken();
		}
		
		return newStr.toString();
		
	}
	
	public String firstCap(String input) {//"TokenMenu"  "tokenMenu" 
		//첫 글자만 대문자로 바꾼 문자열 반환
		
		if (input == null || input.isEmpty()) {
			return input;
		}
		
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
	
	public int findChar(String input, char one) {
		//문자열 안에 찾을 문자개수가 몇 개 들어가있는지 반환
		
		int count = 0;
//		for(int i = 0; i < input.length(); i++) {
//			if (input.charAt(i) == one) {
//				count++;
//			}
//		}
		
		for (char c : input.toCharArray()) {
			if (c == one) {
				count++;
			}
		}
		
		return count;
	}
}
