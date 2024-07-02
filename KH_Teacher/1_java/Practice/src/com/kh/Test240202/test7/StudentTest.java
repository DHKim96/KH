package com.kh.Test240202.test7;

public class StudentTest {

	public static void main(String[] args) {
		Human[] arr = new Human[3];
		arr[0] = new Student("홍길순", 25, 171, 81, "201401", "영어영문학");
		arr[1] = new Student("한사랑", 23, 183, 72, "201402", "건축학");
		arr[2] = new Student("임꺽정", 26, 175, 65, "201403", "체육학");
		
		for(Human h : arr) {
			System.out.println(h.toString());
		}
		
	}

}
