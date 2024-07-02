package com.kh.Test2401261;

public class Dog extends Animal{
	public static final String PLACE = "애견카페";
	private int weight;
	
	public Dog() {
	}

	public Dog(String name, String kinds, int weight) {
		super(name, kinds); // protected
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public void speak() {
		System.out.println(super.toString() + "몸무게는 " + this.weight + "kg 입니다.");
		
	}
	
}
