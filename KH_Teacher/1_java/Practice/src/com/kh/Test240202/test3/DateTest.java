package com.kh.Test240202.test3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date birth = new Date(1990 - 1900, 5 - 1, 27);
		Date today = new Date();
		
		SimpleDateFormat f1 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		SimpleDateFormat f2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		
		String birthFormat = f1.format(birth);
		String todayFormat = f2.format(today);
		
		System.out.println("생일 : " + birthFormat);
		System.out.println("현재 : " + todayFormat);
		System.out.println("나이 : " + (today.getYear() - birth.getYear()));

	}

}
