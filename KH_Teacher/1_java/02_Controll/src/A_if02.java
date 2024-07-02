import java.util.Scanner;

public class A_if02 { // A_if02이름을 가진 클레스
	public static void main(String[] arge) { // main메소드 영역
		Scanner sc = new Scanner(System.in);
		
		//나이를 입력받아
		// 13세 이하 : 어린이
		// 13세 초과 19세 이하 : 청소년
		// 19세 초과 : 성인
		// xx세는 xxx에 속합니다.
		
		
		/*
		int age;
		String type = "";
		
		System.out.print("나이(정수만) : ");
		age = sc.nextInt();
		sc.nextLine();
		*/
		
		// if문만 이용해서
		/*
		if (age <= 13) {
			type = "어린이";
		}
		
		if (age > 13 && age <= 19) {
			type = "청소년";
		}
		
		if (age > 19) {
			type = "성인";
		}
		*/
		
		/*
		if(age <= 13) {
			type = "어린이";
		} else if(age <= 19) {
			type = "청소년";
		} else{
			type = "성인";
		}
		

		
		System.out.println(age + "세는 " + type + "에 속합니다.");
		*/
		
		//=====================================================================
		
		//성별을 (m/f)(대소문자 상관없음)로 입력받아 남학생인지 여학생인지
		//출력하는 프로그램을 작성하세요
		//성별(m/f) : 
		//여학생입니다 / 남학생입니다 / 잘못입력하셨습니다.
		
		/*
		char gender;
		String name = "최지원";
		String result = "";
		
		System.out.println("성별(m/f) : ");
		gender = sc.next().charAt(0);
		
		
		if (gender == 'F' || gender == 'f') {
			System.out.println("여학생입니다.");
		} else if (gender == 'M' || gender == 'm') {
			System.out.println("남학생입니다.");
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
		
		
		if (gender == 'F' || gender == 'f') {
			result = "여학생";
		} else if (gender == 'M' || gender == 'm') {
			result = "남학생";
		} else {
			System.out.println("잘못 입력하셨습니다.");
			return; //  해당 메소드 자체를 빠저나가는 구문
		}
		
		System.out.println(name + "님은 " + result + "입니다.");
		*/
	
		//===========================================================
		
		//정수(양수)를 입력받아
		//짝수인지 홀수인지 출력하는 프로그램작성
		//정수(양수) 입력 : ()
		//짝수다 / 홀수다 / 양수가 아닙니다. 잘못입력하셨습니다.
		int num;
		
		System.out.print("정수(양수) 입력 : ");
		num = sc.nextInt();
		
		/*
		if (num > 0) { // 양수일 경우
			if (num % 2 == 0) { // 양수이면서 짝수일 경우 
				System.out.println("짝수다.");
			} else { // 양수이면서 홀수인 경우
				System.out.println("홀수다.");
			}
		} else {
			System.out.println("양수가 아닙니다. 잘못입력하셨습니다.");
		}
		*/
		
		if (num > 0 && num % 2 == 0) { // num은 0보다 크다(양수) 그리고 num은 2로 나눈 나머지가 0이다(짝수)
			System.out.println("짝수다.");
		} else if(num > 0 && num % 2 == 1) { // 양수이면서 홀수인경우
			System.out.println("홀수다.");
		} else {
			System.out.println("양수가 아닙니다. 잘못입력하셨습니다.");
		}
		
	}
}
