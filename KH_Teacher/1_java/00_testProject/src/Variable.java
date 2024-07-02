
public class Variable {
	/*
	 * 변수의 선언 값을 기록하기위한 변수를 메모리 공간에 확보, 할당한다. -> 즉, 값을 보관하기위한 공간을 만든다고 생각하면 된다.
	 * 
	 * [표현법] 자료형 변수이름;
	 * 
	 * 자료형 : 변수의 크기 및 모양을 지정해주는 부분 변수이름 : 변수의 이름을 붙여주는 부분(변수에 접근하기위해서 의미를 부여한다)
	 * 
	 * 변수 선언 시 주의할점
	 * 
	 */

	public static void main(String[] args) {
		// int(정수)라는 자료형으로 num라는 이름의 변수를 선언
//		int num;

		// boolean(참과거짓)이라는 자료형으로 isTrue라는 이름의 변수를 선언
//		boolean isTrue;

		// float(실수)이라는 자료형으로 num20라는 이름의 변수를 선언
//		float num20;
//		
//		System.out.println(6 + 3);

		// num1, num2 라는 int변수 선언
//		int num1;
//		int num2;

		// num1에 10 num2에 20이라는 값을 할당
//		num1 = 10;
//		num2 = 20; 

		// num1에 있는 값과 num2의 있는 값을 더해서 출력
//		System.out.println(num1 + num2);
		
		
		
		/* 
		 * 정수 자료형
		 * byte(1) short(2) int(4) long(8)
		 * 모두 정수를 저장하는 자료형이지만 각 자료형마다 표현할 수 있는 수의 범위가 다르다.
		 */
		byte by = 10;
		short sh = 10;
		int in = 10;
		long lo = 10;
		
		System.out.println("정수 자료형");
		System.out.println(by + ", " + sh + ", " + in + ", " + lo);

		/*
		 * 실수 자료형
		 * float(4)   double(8)
		 * 모두 실수를 저장하는 자료형이지만 float보다 double이 더 정확한 수를 표현할 수 있다.
		 */
		
		float fl = 4.24f;
		double dou = 4.24;
		
		System.out.println("실수 자료형");
		System.out.println(fl + ", " + dou);
		
		/*
		 * 문자 자료형
		 * char(2)
		 * 문자하나를 담을 수 있는 자료형
		 * 자바는 2바이트의 유니코드로 표현한다.
		 */
		
		char ch1 = '최';
		char ch2 = '지';
		char ch3 = '원';
		
		System.out.println("문자 자료형");
		System.out.print(ch1);
		System.out.print(ch2);
		System.out.print(ch3);
		
		/*
		 * 논리 자료형
		 * boolean(1)
		 * true(참)와 false(거짓)을 저장하는 자료형 
		 */
		
		boolean b1 = 10 > 5; // true
		boolean b2 = 20 == 10; //false
		
		System.out.println("논리 자료형");
		System.out.println(b1);
		System.out.println(b2);
		
		/*
		 * 문자열
		 * String(객체)
		 * 문자열 같은 경우 할당해야할 메모리크기가 너무 가변적이므로 원시타입이 아닌 객체로 변수를 만들어 준다.
		 * 
		 * 
		 */
		
		String str1 = "병아리";
		String str2 = new String("병아리"); //객체생성방식으로 String변수를 선언
		String str3 = "병아리" + "삐악삐악";
		String str4 = new String("병아리"+"삐악삐악");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		
		//다른 자료형 + 문자열 = 문자열
		String str5 = 20 + " 병아리" + 5 + "살 " + "삐악삐악";
		System.out.println(str5);
		
		/*
		 * 이스케이프 시퀀스
		 * 문자열내에서 백스페이스, 탭, 백슬래시, 작은따옴표등 코드로 사용되는 특수문자를
		 * 표현할때 사용하는 방식
		 * 
		 * 백스페이스 \b
		 * 탭문자 \t
		 * 백슬래스 \\
		 * 작은따옴표 \'
		 * 큰따옴표 \"
		 * 개 행 문자 \n
		 * 캐리지리턴(다음 글자가 찍힐 위치를 그 줄의 왼쪽 끝으로 함) \r
		 */
		System.out.println("저는 이렇게 말했습니다. \"저는 배고파요\" ");
		System.out.print("저는\n지금\n배가 고파요");
		
		/*
		 * 상수
		 * 수하에서는 변하지 않는 값
		 * 프로그래밍에서는 한 번만 값을 할당할 수 있는 메모리
		 * 
		 * [표현법] final 자료형 변수이름;
		 * 
		 * 상수의 이름은 모두 대문자로 짓는 것이 관례
		 * 이름이 둘 이상의 단어로 이뤄질 경우 단어를 언더바로 연결해 준다. ex) MY_AGE
		 */
		
		final int AGE;
		AGE = 90;
		// AGE = 10; 한번 값을 초기화하면 더이상 변경할 수 없음
		
		
	}
}
