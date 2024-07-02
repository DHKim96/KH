package com.kh.Inherit02;

public class Run {
	/*
	 * * 상속의 장점
	 * 	  1) 보다 적은 양의 코드로 새로운 클래스 작성 가능
	 * 	  2) 코드를 공통으로 관리하기 대문에 코드의 추가나 변경이 용이함
	 * 		 (프로그램의 생산성과 유지보수성이 좋아짐)
	 *  * 상속의 특징
	 *    1) 클래스 간의 상속에서는 다중상속 불가(즉, 부모는 하나다)
	 *    2) 부모 클래스에 정의돼있는 protected 필드는 자식 클래스에서 직접 접근이 가능함
	 *    3) 자식 객체는 부모 클래스에 있는 메소드를 마치 내 것처럼 호출이 가능함 
	 *    	+ 부모 클래스에 정의된 기능이 마음에 들지 않을 경우 내 마음대로 수정 가능(오버라이딩)
	 *    4) 명시되어있지는 않지만 모든 클래스-자바에서 제공하거나 직접 만든 클래스-는 Object클래스의 후손이다
	 *    	 => Object 클래스에 있는 메소드를 마음대로 호출 가능
	 *    	 => 오버라이딩 통한 재정의도 가능
	 */
	public static void main(String[] args) {
		Tv t = new Tv("LG", "t-01", "엄청얇은티비", 3500000, 65);
		Desktop d = new Desktop("SAMSUNG", "d-01", "고사양데스크탑", 2600000, true);
		SmartPhone s = new SmartPhone("GALAXY", "p-01", "제트플립", 1300000, "알뜰폰");
		
		/*
		 * 세 클래스의 공통적인 필드와 메소드들이 존재함
		 * 이런 중복된 코드들을 따로 "부모" 클래스로 한 번만 정의해두면 중복된 코드를 줄일 수 있음
		 * => 수정과 같은 유지보수 요청이 들어왔을 때 일일이 찾아서 수정할 필요 없이
		 * 	  부모 클래스만 수정하면 전체적으로 반영이 됨
		 */
		
		System.out.println(t.information());
		System.out.println(d.information());
		System.out.println(s.information());
	}
}
