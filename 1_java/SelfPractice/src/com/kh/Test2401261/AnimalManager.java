package com.kh.Test2401261;
public class AnimalManager {
	public static void main(String[] args) {
		
		/*
		 * * 추상클래스
		 * 		미완성된 클래스
		 * 		객체 생성이 불가함(단, 레퍼런스 변수-참조변수- 선언이 가능)
		 * 		일반 필드 + 일반 메소드 (+ 추상 메소드-필수는 아님-) 형태
		 * 	=> 추상 메소드를 가진 클래스는 반드시 추상 클래스로 명시해야 함
		 *		* 추상 메소드가 굳이 없어도 추상 클래스를 사용할 수 있을까? 可!
		 *			> 개념적 : 이 경우, 단지 이 클래스가 미완성된 클래스라는 걸 알리기 위해 추상 클래스를 사용함
		 *			> 프로그래밍적 : 객체 생성이 불가하게 끔 하고자 할 때
		 *		
		 *		* 추상 메소드가 있는 추상 클래스를 사용하는 이유
		 *			부모 클래스에 추상 메소드가 존재할 경우
		 *			자식 클래스에서는 강제로 오버라이딩해서 동일한 패턴의 메소드를 가지게 됨
		 *			=> 각 자식 클래스마다 실행시킬 내용은 다르지만 동일한 형태의 메소드로 구현했으면 할 때
		 */
		
		Animal[] animals = new Animal[5];
		animals[0] = new Dog("개똥이", "진돗개", 20);
		animals[1] = new Cat("개냥이", "러시안블루", "집 앞", "블루");
		animals[2] = new Dog("똥개", "시고르자브종", 30);
		animals[3] = new Cat("냥", "도둑고양이", "편의점앞", "치즈색");
		animals[4] = new Dog("개훌륭", "강형욱", 40);
		
		for (int i = 0; i < animals.length ; i++) {
			// for (Animal a : animals) 도 가능
			//  	a.speak();
			if (animals[i] instanceof Dog) {
				((Dog)animals[i]).speak();
			}
			else if (animals[i] instanceof Cat) {
				((Cat)animals[i]).speak();
			}
		}
	}
}
