package com.kh.Test2402063;

public class Run {

	public static void main(String[] args) {
		//Human Class하나 만들어주세요
		// 필드에서는 String name,ing age, int mathScore, int enScore
		// toString, getter, setter

		
		//Human객체 3개를 생성하세요
		//내부에 값은 임의로 넣어주시면됩니다.
		
		
		//클래스이름 객체이름 = new 생성자명(매개변수);
		Human jiwon = new Human("최지원", 20, 50, 100);
		Human sumin = new Human("김수민", 30, 70, 90);
		
		Human minsu = new Human();
		minsu.setName("오민수");
		minsu.setAge(17);
		minsu.setMathScore(70);
		minsu.setEnScore(50);
		
		System.out.println(minsu);
		System.out.println(minsu.getEnScore());
		
		String name = sumin.getName();
	}

}
