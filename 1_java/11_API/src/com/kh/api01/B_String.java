package com.kh.api01;

import java.util.StringTokenizer;

public class B_String {
	public void method01() {
		// 1. 생성자를 통한 문자열 생성
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1);
		System.out.println(str2);
		// String 클래스에 toString메소드 이미 오버라이딩 되어있음(실제 담긴 문자열을 반환하도록)
		
		System.out.println(str1 == str2); // false 출력됨 why? 주소값 비교이기에
		
		System.out.println(str1.equals(str2));
		// Object 클래스의 equals 메소드는 본디 주소값 비교하는 기능이지만
		// String클래스에 equals 메소드는 이미 오버라이딩 되어있음(주소값 비교가 아닌 담긴 문자열을 비교하도록)
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		// String 클래스에 hashCode 메소드 이미 오버라이딩 되어있다.
		// 주소값이 아닌 문자열을 가지고 해시코드 구현. 문자열이 같은 경우 해시코드도 같음
		// 주소값에 대한 해시코드를 알고 싶다면, identityHashCode 메소드를 이용해야한다.
		System.out.println(System.identityHashCode(str1)); 
		System.out.println(System.identityHashCode(str2));
	
	
		System.out.println("=======================================");
		
		
		// 2. 문자열을 리터럴값으로 생성
		String str3 = "hello";
		String str4 = "hello";
		// 리터럴 제시 시 상수풀(String Pool) 영역에 올라감
		// String Pool 특징 : 동일한 문자열을 가질 수 없다.
		System.out.println(str3);
		System.out.println(str4);
		
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		
		System.out.println(str3 == str4); // 주소값이 같음 why? 리터럴 때문
	
		System.out.println(System.identityHashCode(str1)); 
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3)); 
		System.out.println(System.identityHashCode(str4));
		
		str4 = "hi";
		System.out.println(System.identityHashCode(str4));
		
		// String 클래스 == 불변클래스(변하지 않는 클래스)
		// 변경이 가능하지만 수정되는 개념이 아니라 새로 생성하여 교체하는 개념
		
		str3 = "bye";
		System.out.println(System.identityHashCode(str3));
		// 변경하는 순간 기존의 문자열 자리에서 변경되는게 아닌
		// 새로운 곳을 참조하도록 함(새로운 주소값 부여받음 == 주소값 변경)
		
		str4 = "hello";
		System.out.println(System.identityHashCode(str4));
	}

	public void method02() {
		String str1 = "Hello World";
		
		// 메소드명(매개변수) : 반환형
		
		/*  1. 문자열.charAt(int index) : char
		 * 		문자열에서 전달받은 index 위치의 문자만을 추출해서 리턴
		*/
		char ch = str1.charAt(6);
		System.out.println("ch : " + ch);
		
		/*
		 *  2. 문자열.concat(String str) : String
		 *  	문자열과 전달된 또 다른 문자열을 하나로 합쳐서 새로운 문자열로 리턴
		 * 		concatenate(함께 연결하다)의 준말
		 */
		String str2 = str1.concat("!!!"); // 객체를 새로 생성하고 리턴해줌 
		System.out.println("str2 : " + str2);
		
		String str3 = str1 + "!!!"; // 상수 처리
		System.out.println("str3 : " + str3);
		
		//str2와 str3에 담긴 문자열은 일치하나, 담겨있는 주소값은 다름
		System.out.println("str2와 str3의 일치 여부 : " + ( str2 == str3 ));
		
		/*
		 * 3. 문자열.equals(Object obj) : boolean
		 * 		문자열과 전달된 또 다른 문자열을 가지고 주소값 비교가 아닌, 실제 문자열 값을 가지고 동등비교
		 */
		System.out.println("str2와 str3의 일치 여부 : " + ( str2.equals(str3) ) );
		
		/*
		 *  4. 문자열.contains(CharSequence s) : boolean
		 */
		System.out.println("str1에 Hello라는 문자열의 포함 여부 : " + str1.contains("Hello") );
		System.out.println("str1에 Bye라는 문자열의 포함 여부 : " + str1.contains("Bye") );
		
		/*
		 *  5. 문자열.length() : int
		 *  	문자열의 길이를 반환하는 메소드
		 */
		System.out.println("str1의 길이 : " + str1.length());
		
		/*
		 *  6-1. 문자열.substring(int beginIndex) : String
		 *  	문자열의 beginIndex 위치에서부터 끝까지 문자열 추출해서 리턴
		 *  6-2. 문자열.substring(int beginIndex, int endIndex) : String
		 *		문자열의 beginIndex 위치에서부터 ( endIndex - 1 ) 위치까지 문자열을 추출해서 리턴     
		 */
		System.out.println(str1.substring(6));
		System.out.println(str1.substring(0, 5));
		
		/*
		 *  7. 문자열.replace(char oldChar, char newChar) : String
		 *  	문자열에서의 oldChar문자를 newChar 문자로 변환한 새 문자열 리턴
		 *  	특정 문자를 다른 문자로 바꾸고 싶을 때 사용
		 */
		String str4 = str1.replace('l', 'c');
		System.out.println("str4 : " + str4);
		
		/*
		 *  8-1. 문자열.toUpperCase() : String
		 *  	문자열을 전부 대문자로 변경한 새 문자열 리턴
		 *  8-2. 문자열.toLowerCase() : String
		 *  	문자열을 다 소문자로 변경한 새 문자열 리턴
		 */
		String str5 = str1.toUpperCase();
		System.out.println("str5 : " + str5);
		System.out.println("Lower : " + str1.toLowerCase());
		
		System.out.println("계속하시겠습니까? (y/n)");
//		char ch = new java.util.Scanner(System.in).next().toUpperCase().charAt(0); // N or Y
	
		/*
		 *  9. 문자열.trim() : String
		 *  	문자열의 앞 뒤 공백을 제거한 뒤 새 문자열을 리턴
		 */
		String str6 = "       JA    VA          ";
		System.out.println(str6.trim());
		
		/*
		 *  10. 문자열.toCharArray() : char[]
		 */
		char[] arr = str1.toCharArray();
		for(char ar : arr) {
			System.out.print(ar+ " ");
		}
		System.out.println();
		
		/*
		 *  11. static valueOf(char[] date) : String
		 *  	캐릭터형 배열을 다시 String형으로 변환
		 *  	다른 타입을 String형으로 전환
		 */
		
		System.out.println(String.valueOf(arr));
	}

	public void method03() {
		
		String str = "Java,Oracle,JDBC,HTML,CSS,Spring";
		
		// 구분자를 기준으로 문자열을 분리시키는 방법
		
		/*
		 *  방법1. 분리된 문자열들을 String[] 배열에 차곡차곡 담고자 할때
		 *  		String클래스에 제공하는 split 메소드 이용
		 *  		문자열.split(구분자) : String[]
		 */
		
		String[] arr = str.split(","); // 분리할게 없으면 초기값을 리턴함
		// 구분자를 사용하지 않을 경우 디폴트값은 띄어쓰기 기준
		
		System.out.println("배열의 길이 : " + arr.length);
		
		for(String str1 : arr) {
			System.out.print(str1 + " ");
		}
		
		System.out.println();
		
		// 스플릿은 빈 문자열을 토큰으로 인식. 스플릿의 결과값은 문자열 배열임
		
		/*
		 *  방법2. 분리된 문자열들을 각각 토큰으로써 관리하고자 할 때
		 *  		java.util.StringTokenizer 클래스를 이용하는 방법
		 *  cf) 문자열에서는 문자 하나 하나를 토큰이라고 함
		 */
		StringTokenizer stn = new StringTokenizer(str, ","); // 구분자를 기입하지 않으면 자동적으로 띄어쓰기를 기준으로 문자열을 분리함
		//stn에 str을 쉼표로 나눈 토큰들이 저장됨
		// StringTokenizer stn = new StringTokenizer(str, "," , true);
		// 뒤에 true / false 의 boolean 값을 넣어주면 구분자도 토큰에 포함됨. 이때 디폴트값은 false
		// 여러 개의 구분자 인자를 가질 수도 있음
		
		// StringTokenizer stn = new StringTokenizer(str, "e," , true);
		
		
		System.out.println(stn.countTokens()); // stn 내 토큰의 갯수
		
		// 반복하여 처음부터 끝까지 출력하는 방법.
		
		// 방법 1. for 문 사용
//		int count = stn.countTokens();
//		
//		for (int i = 0 ; i < count ; i++) {	
//			System.out.println(stn.nextToken());// stn의 토큰 하나가 빠져나오는 것
//		}
//				
//		System.out.println(stn.countTokens()); // nextToken()으로 빠져나오면 stn 공간에서 사라짐
	
		// 내부에 더 이상 토큰이 없을 때 nextToken(); 사용하면 NoSuchElementException 에러 발생
		
		// 방법 2. while 문 사용
		while(stn.hasMoreTokens()) { // 남은 토큰이 있으면 true
			System.out.println(stn.nextToken());
		}
	}
}
