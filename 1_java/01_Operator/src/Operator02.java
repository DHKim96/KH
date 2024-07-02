
public class Operator02 {
	/*
	 * 증감연산자
	 * ++ : 변수에 담긴 값을 1 증가시킴
	 * -- : 변수에 담긴 값을 1 감소시킴 
	 * 전위연산, 후위연산
	 */
	
	public static void main(String[] args) {
		int num1 = 0;
		System.out.println(num1++); // 0
		System.out.println(--num1);	// 0
		System.out.println(--num1); // -1
		System.out.println(num1--); // -1
		System.out.println(num1++); // -2
		System.out.println(++num1); // 0
		System.out.println(++num1); // 1
		System.out.println(num1++); // 1
	}
}
