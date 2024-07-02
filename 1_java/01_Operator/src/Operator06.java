import java.util.Scanner;
public class Operator06 {
	/*
	 * 삼항 연산자 (항목 3개를 가지고 연산해주는 연산자)
	 * [표현법]
	 * (조건식) ? (조건식이 참 일 경우, 돌려줄 결과값) : (조건식이 거짓 일 경우, 들어올 결과값)
	 * 이때, 조건식은 반드시 true 또는 false 가 나오도록 해야 함.
	 * 주로 비교, 논리 연산자를 통해 작성함.
	 */
	public static void main(String[] args) {
		//입력 받은 정수 값이 양수인지 아닌지 판별 후 출력한다.
		Scanner sc = new Scanner(System.in);
//		String result;
//		int num;
//		System.out.print("정수값 입력 : ");
//		num = sc.nextInt();
//		
////		String result = num > 0 ? "양수" : "음수";
//		if ( num > 0 ) {
//			result = "양수";
//		} else {
//			result = "음수";
//		}
//		
//		System.out.println(result + "입니다.");
//		
//		sc.close();
		
		//정수 하나를 입력 받아 짝수인지 홀수인지 판별 후 출력
		//출력
		// 정수값 입력 : 
		// 
		
//		System.out.print("정수값 입력 : ");
//		int num = sc.nextInt();
//		
//		String result = ( num % 2 ) == 0 ? "짝수" : "홀수";
//		
//		System.out.println(result + "입니다.");
//		System.out.printf("%d은(는) %s입니다.", num, result);
//		
//		sc.close();
		
		
		//사용자에게 두 개의 정수값을 입력 받으세요. + 또는 - 를 입력 받아 그에 맞는 연산 결과를 출력해 주세요.
		//단, + 또는 - 이외에 다른 문자를 입력 했을 경우, "잘못 입력했습니다" 출력
		//첫 번째 정수 : 
		//두 번째 정수 :
		//연산자 입력(+ 또는 -) : 
		//결과
		
//		int num1;
//		int num2;
//		char op;
//		String result;
//		
//		System.out.print("첫 번째 정수 : ");
//		num1 = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.print("두 번째 정수 : ");
//		num2 = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.print("연산자 입력(+ 또는 -) : ");
//		op = sc.next().charAt(0);
//		
//		result = ( ( op == '+' ) ? ( num1 + num2 ) + "" : ( ( op == '-' ) ? ( num1 - num2 ) + "" : "잘못 입력했습니다" ) );
		// 삼항 연산자
		// 조건문 중 if문
//		if ( op == '+') {
//			result = num1 + num2 + "";
//		} else if ( op == '-' ) {
//			result = num1 - num2 + "";
//		} else {
//			result = "잘못 입력했습니다.";
//		}
		
		// 조건문 중 switch
//		switch(op) {
//		case '+' : 
//			result = num1 + num2 + "";
//			break;
//		case '-' :
//			result = num1 - num2 + "";
//			break;
//		default :
//			result = "잘못 입력했습니다.";
//		}
////		
//		System.out.println("결과 : " + result);
	
//		//코리아 초등학교에서 1학년부터 4학년까지 중간고사 시험을 보았다. 
//
//	    4학년은 70점 이상이면 합격, 그 이외의 학년은 60점 이상이면 합격이다. 
//
//	    이를 판단하는 프로그램을 작성해보자.
//
//	    점수가 0미만 100초과이면 경고문구 출력!
		
		int grade;
		int score;
		String msg;
		
		System.out.println("코리아 초등학교 1학년 ~ 4학년 중간고사 시험 결과입니다.");
		
		System.out.println("학년과 점수를 입력해주세요.");
		
		System.out.print("학년 : ");
		grade = sc.nextInt();
		sc.nextLine();
		
		System.out.print("점수 : ");
		score = sc.nextInt();
		sc.nextLine();
		
		if(score >= 0 && score <= 100 ) {
			if(grade != 4) {
				if(score >= 60) {
					msg = "합격";
					System.out.println("결과 : " + msg);
				}else {
					msg = "불합격";
					System.out.println("결과 : " + msg);
				}
			}else if(grade == 4) {
				if(score >= 70) {
					msg = "합격";
					System.out.println("결과 : " + msg);
				}else {
					msg = "불합격";
					System.out.println("결과 : " + msg);
				}
			}
		}else {
			System.out.println("잘못 입력하셨습니다");
		}
		sc.close();
	}
}


