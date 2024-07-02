import java.util.Scanner;
public class A_if02 {
/*
 * 나이를 입력받아
 * 13세 이하 : 어린이
 * 13세 초과, 19세 이하 : 청소년
 * 19세 초과 : 성인
 * xx세는 xxx에 속합니다.
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		
//		int age;
//		String type = "";
//		
//		System.out.print("나이(정수만) : ");
//		age = sc.nextInt();
//		sc.nextLine();
//		
//		sc.close();
//		
////		if (age <= 13) {
////			type = "어린이";
////		} else if (age > 13 && age <= 19) {
////			type = "청소년";
////		} else {
////			type = "성인";
////		}
//		
//		if (age <= 13) {
//			type = "어린이";
//		} if (age > 13 && age <= 19) {
//			type = "청소년";
//		} if (age > 19) {
//			type = "성인";
//		}
//		
//		// if문만 쓰면 String 값이 제대로 입력되지 않아서 컴파일러 오류 발생. 따라서 String 선언 시에 = ""를 사용해 초기화시켜준다.
//		
//		System.out.println(age + "세는 " + type + "에 속합니다."); 
		
		//==============================================================
		
		/*
		 * 성별을 (m/f; 대소문자 상관없음)로 입력 받아 남학생인지 여학생인지 출력하는 프로그램을 작성하세요.
		 * 성별(m/f) :
		 * 남학생입니다 / 여학생입니다/ 잘못입력하셨습니다.
		 */
//		
//		System.out.println("성별을 입력해주세요");
//		
//		System.out.print("성별(m/f) : ");
//		int gender = sc.next().charAt(0);
//		
//		sc.close();
//		
//		String str = "";
//		
//		if (gender == 'm' || gender == 'M') {
//			str = "남학생";
//		} else if (gender == 'f' || gender == 'F') {
//			str = "여학생";
//		} else {
//			System.out.println("잘못입력하셨습니다");
//			return; //해당 메소드(main) 자체를 빠져나가는 구문
//			//따라서 아래의 출력문은 실행되지 않음.
//		}
//		
//		System.out.println(str + "입니다");
		
		//============================================================================
		
		/*
		 * 정수(양수)를 입력 받아 짝수인지 홀수인지 출력하는 프로그램 작성
		 * 정수(양수) 입력 : ()
		 * 짝수다 / 홀수다 / 양수가 아닙니다. 잘못입력하셨습니다
		 */
		
		System.out.println("정수(양수)를 입력해주세요");
		
		System.out.print("정수(양수) 입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		
		sc.close();
		
		String result = "";
		
		if (num > 0) {
			if (num % 2 == 0) {
				result = "짝수";
			}else if (num % 2 != 0) {
				result = "홀수";
			}
		}else {
			System.out.println(num + "은(는) 양수가 아닙니다. 잘못입력하셨습니다.");
			return;
		}
		
		System.out.println(num + "은(는) " + result + "입니다.");
		
	}

}
