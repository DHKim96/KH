package com.kh.Test2401262;

public class Employee {
	private int empNo;
	private String name;
	private char gender;
	private String phone;
	
	public Employee(int empNo, String name, char gender, String phone) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name + ", gender=" + gender + ", phone=" + phone + "]";
	}
	
	
}
