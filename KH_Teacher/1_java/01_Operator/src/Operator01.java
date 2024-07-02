
public class Operator01 {

	/*
	 * !
	 * 논리부정 연산자(단항 연산자 == 하나의 값을 가지고 연산)
	 * 
	 * 논리값(true/false)을 반대로 바꾸는 연산자
	 * 
	 * => 결과 마저도 논리값이다.
	 */
	public static void main(String[] args) {
		System.out.println("true의 부정 " + !true);
		System.out.println("false의 부정 " + !false);
		
		boolean b1 = true;
		System.out.println("b1의 부정 : " + !b1);
		
		boolean b2 = !b1; // false
		
		boolean b3 = !(5 > 3); // false
		System.out.println("b3 : " + b3);
		
		
		boolean isOpen = true;
		

	}

}
