package com.kh.employy;

public class Employee {
	private int empNo; //사원번호
	private String name; // 이름
	private char gender; // 성별
	private String phone; //연락처
	private String dept; // 부서
	private int salary; // 월급
	private double bonus; //보너스
	
	public Employee() {
		super();
	}
	public Employee(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.dept = dept;
		this.salary = salary;
		this.bonus = bonus;
	}
	
	public Employee(int empNo, String name, char gender, String phone) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.gender = gender;
		this.phone = phone;
		this.dept = "미입력";
		this.salary = 0;
		this.bonus = 0;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", dept="
				+ dept + ", salary=" + salary + ", bonus=" + bonus + "]";
	}
}
