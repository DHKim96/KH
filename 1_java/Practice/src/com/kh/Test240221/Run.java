package com.kh.Test240221;

public class Run {

	public static void main(String[] args) {

		Employee emHong = new Employee();
		
		emHong.setEmpNo(100);
		emHong.setEmpName("홍길동");
		emHong.setDept("영업부");
		emHong.setJob("과장");
		emHong.setAge(25);
		emHong.setGender('남');
		emHong.setSalary(2500000);
		emHong.setBonusPoint(0.05);
		emHong.setPhone("010-1234-5678");
		emHong.setAddress("서울시 강남구");
		
		System.out.println(emHong.getAddress());
	}

}
