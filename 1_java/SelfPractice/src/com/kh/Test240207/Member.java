package com.kh.Test240207;

public class Member {
	private String password;
	private String name;
	
	public Member() {}

	public Member(String password, String name) {
		super();
		this.password = password;
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Member [password=" + password + ", name=" + name + "]";
	}
	
	
}
