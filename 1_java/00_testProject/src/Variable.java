
public class Variable {
/*
 * 변수의 선은
 * 값을 기록하기 위한 변수를 메모리 공간에 확보, 할당한다. -> 즉, 값을 보관하기 위한  공간을 만든다고 생각하면 된다.
 * 
 * [표현법] 자료형 변수이름;
 * 
 * 자료형 : 변수의 크기 및 모양을 지정해주는 부분
 * 변수이름: 변수의 이름을 붙여주는 부분(변수에 접근하기 위해서 의미를 부여한다.)
 * 
 * 변수 선언 시 주의할 점
 * 
 */
	public static void main(String[] args) {
//		//int(정수)라는 자료형으로 num이라는 이름의 변수를 선언.
//		int num;
//		
//		//boolean(참과 거짓)이라는 자료형으로 isTrue라는 이름의 변수를 선언
//		boolean isTrue;
//		
//		//float(실수)라는 자료형으로 num2라는 이름의 변수를 선언.
//		float num20;
//		
//		System.out.println(6 + 3);
//		
//		//num1, num2라는 int 변수 선언
//		int num1;
//		int num2;
//		
//		//num1에 10, num2에 20이라는 값을 할당
//		num1 = 10;
//		num2 = 20;
		
		//num1에 있는 값과 num2에 있는 값을 더해서 출력
//		System.out.println(num1 + num2);
		
		/*
		 * 정수 자료형(바이트 크기)
		 * byte(1), short(2), int(4), long(8)
		 * 모두 정수를 저장는 자료형이지만 각 자료형마다 표현할 수 있는 저장 범위가 다름.
		 */
		byte by = 10; // 2^7을 넘어가면 에러 발생
		short sh = 10;
		int in = 10;
		long lo = 10;
		
		System.out.println("정수 자료형");
		System.out.println(by + ", " + sh + ", " + in + ", " + lo);
		/*
		 * 실수 자료형
		 * float(4), double(8)
		 * 모두 실수를 저장하는 자료형이지만 double이 더 정확한 수를 표현할 수 있음.
		 */
		float fl = 4.24f; //왜 float는 f 표기? double이 표준?
		double dou = 4.24;
		
		System.out.println("실수 자료형");
		System.out.println(fl + ", " + dou);
		
		/*
		 * 문자 자료형
		 * char(2)
		 * 문자 하나를 담을 수 있는 자료형.
		 * 자바는 2바이트의 유니코드로 표현함.
		 */
		
		char ch1 = '김';
		char ch2 = '동';
		char ch3 = '현';
		System.out.println("문자 자료형");
		System.out.print(ch1);
		System.out.print(ch2);
		System.out.print(ch3);
		System.out.println();
		
		/*
		 * 논리자료형
		 * boolean(1)
		 * true(참), false(거짓)를 저장하는 자료형.
		 */
		
		boolean b1 = 10 > 5; // true
		boolean b2 = 20 == 10; //false
		System.out.println("논리 자료형");
		System.out.println(b1);
		System.out.println(b2);
		
		/*
		 * 문자열
		 * String(객체) cf.이전의 자료형들은 자바 내에 있는 원시타입
		 * 문자열 같은 경우 할당해야 할 메모리 크기가 가변적이므로 원시타입이 아닌 객체로 변수를 만들어 줌.
		 */
		
		String str1 = "병아리";
		String str2 = new String("병아리"); // 객체 생성 방식으로 String 변수를 선언.
		String str3 = "병아리" + "삐약삐약";
		String str4 = new String("병아리" + "삐약삐약");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		
		//다른 자료형 + 문자열 = 문자열
		String str5 = 20 + "병아리" + 5 + "살" + "삐약삐약";
		System.out.println(str5);
		
		/*
		 * 이스케이프 시퀀스
		 * 문자열내에서 백스페이스, 탭, 백슬래시, 작은따옴표 등 코드로 사용되는 특수문자를 
		 * 표현할 때 사용하는 방식
		 * 
		 * 백스페이스 \b
		 * 탭문자 \t
		 * 백슬래시 \\
		 * 작은따옴표 \'
		 * 큰따옴표 \"
		 * 개 행 문자 \n cf. println();은 \n 이 생략되어 있음
		 * 캐리지리턴 \r 다음 글자가 찍힐 위치를 그 줄의 왼쪽 끝으로 함
		 */
		
		System.out.println("백슬래시");
		System.out.print("저는 이렇게 말했습니다. \"저는 배고파요\" "); // \를 안쓰면 큰따옴표 사이에 있는 '저는 배고파요'를 코드로 인식
		System.out.println();
		System.out.println();
		System.out.println("개행문자");
		System.out.print("저는\n지금\n배가 고파요");
		System.out.print("저는 지금 배가 고파요\n");
		System.out.println();
		System.out.println("캐리지리턴");
		System.out.print("저는 \r지금 \r배가 고파요");
		System.out.println();
		System.out.println();
		System.out.println("백스페이스");
		System.out.println("저는\b 지금 배가 고파요");
		System.out.print("\n"); // System.out.print()은 내용에 큰따옴표를 써야 출력됨.
		/*
		 * 상수
		 * 수학에서는 변하지 않는 값을 의미
		 * 프로그래밍에서는 한 번만 값을 할당할 수 있는 메모리
		 * 
		 * [표현법]final 자료형 변수이름;
		 * 
		 * 상수 표현시 대문자 사용하는 것이 관례. 상수와 변수를 구분할 수 있도록
		 * 단어 연결된 상수 표기시 카멜케이스 대신 언더바(_)를 사용해 줌. ex) MY_AGE
		 */
		
		final int AGE = 90; 
		System.out.println(AGE);
		// AGE = 10; 에러 발생. 한 번 값을 초기화하면 더 이상 변경할 수 없음.
	}
}
