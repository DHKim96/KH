package com.kh.Interface02;

public class Run {
	/*
	 * * 인터페이스
	 *	:   추상 메소드로만 이루어진 클래스
	 *		추상 메소드로만 이루어져 있기 때문에 객체를 직접 생성할 수 없다.
	 *		참조변수로 사용은 가능하다.
	 *
	 * * 추상메소드
	 * 		미완성된 메소드. 몸체({})가 구현되어 있지 않은 메소드
	 * 		무조건 오버라이딩 후 호출 가능함  
	 */
	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		shapes[0] = new Circle(17.5);
		shapes[1] = new Rectangle(12.3, 8.6);
		/*
		 * 배열 또는 컬렉션에서 사용
		 * 처음부터 끝까지 무조건 모두 탐색한다는 조건
		 * 해당 배열의 인덱스값이 하나씩 왼쪽에 있는 값에 대입되어 반복문 진행
		 */
		for(Shape shape : shapes) { // 자료형 (임의의)변수명 : 배열명
			/* 위 for문의 형태는
			 * for 문(int i = 0 ; i < shapes.length ; i++){
			 * 	Shape shape = shapes[i];  와 동일 // 얕은 복사
			 * }
			 */
			System.out.println("도형의 넓이 : " + shape.calcArea()); // 새로이 만든 변수명으로 접근
		}
	}

}
