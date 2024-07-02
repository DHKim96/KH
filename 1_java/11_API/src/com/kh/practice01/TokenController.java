package com.kh.practice01;
import java.util.StringTokenizer;
public class TokenController {
	
	public TokenController() {
	}
	
	public String afterToken(String str) {
		StringTokenizer stn = new StringTokenizer(str);
//		int count = stn.countTokens();
		String st = "";
//		for ( int i = 0 ; i < count ; i++) {
//			st += stn.nextToken();
//		}
		while(stn.hasMoreTokens()) {
			st += stn.nextToken();
		}
		return st;
	}
	
	public String firstCap(String input) {
		
		if (input == null || input.isEmpty()) {
			return input;  // 예외처리 안할시 nullpointerexception 
		}
		
		String str = ( ( input.substring(0, 1) ).toUpperCase() ) + input.substring(1);
//		char[] ch1 = input.toCharArray();
//		char[] ch2 = input.toUpperCase().toCharArray();
//		ch1[0] = ch2[0];
//		String str = String.valueOf(ch1);
		return str;
	}
	
	public int findChar(String input, char one) {
		int count = 0;
		//첫번째
//		for (int i = 0; i < input.length() ; i++) {
//			if (input.charAt(i) == one) {
//				count++;
//			}
//		}
		
		//두번째
		for (char c : input.toCharArray()) {
			if ( c == one ) {
				count++;
			}
		}
		
		// 내 코드
//		char[] ch1 = input.toCharArray();
//		for (int i = 0; i < ch1.length ; i++) {
//			if (ch1[i] == one) {
//				count++;
//			}
//		}
		return count;
	}
}
