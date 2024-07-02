package com.kh.Test240126;

public class Run {
	public static void main(String[] args) {
		PhoneController pc = new PhoneController();
		String[] result= pc.method();
		for (String rearr : result) {
			System.out.println(rearr);
			System.out.println();
		}
	}
}
