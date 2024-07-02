import java.util.Scanner;

public class B_switch01 {
	/*
	 * *switch 문
	 * 
	 * if 문과 동일하게 조건문
	 * 다만, if 문과의 차이점이라면
	 *	1. if 문은 조건식을 자유롭게 기술 가능(논리값만 나온다면)
	 *		switch 문은 동등 비교로 밖에 수행되지 않음.
	 *		실행할 구문만 실행하고 자동으로 빠져나오지 못함(직접 break 문 작성해야 함)
	 *
	 *	[표현법]
	 *	switch(비교 대상-정수, 문자, 문자열-){
	 *	case 값 1 : 실행 코드 1; break;
	 *	case 값 2 : 실행 코드 2; break;
	 *	... 
	 *	default : 위의 값들이 모두 일치하지 않았을 때 실행하는 코드;
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 정수를 입력 받아
		 * 1일 경우, "빨간색입니다"
		 * 2일 경우, "파란색입니다"
		 * 3일 경우, "초록색입니다"
		 * 나머지의 경우, "잘못입력하였습니다"
		 */
//		
//		System.out.println("정수를 입력하세요");
//		
//		System.out.print("정수(1~3) 입력 : ");		
//		int num = sc.nextInt();
//		sc.close();
//		
//		String color;
		
//		switch(num) {
//		case 1 : 
//			System.out.println("빨간색입니다.");
//			break;
//		case 2 :
//			System.out.println("파란색입니다.");
//			break;
//		case 3 :
//			System.out.println("초록색입니다.");
//			break;
//		default :
//			System.out.println("잘못입력하였습니다.");
//		}
		
//		if (num >= 1 && num <= 3 ) {
//			if(num == 1) {
//				color = "빨간색";
//			} else if(num == 2) {
//				color = "파란색";
//			} else {
//				color = "초록색";
//			}
//		}else {
//			System.out.println("잘못입력하였습니다");
//			return;
//		}
//		System.out.println(num + "의 색깔은 " + color + "입니다.");
		
		/*
		 * 과일을 구매하는 프로그램을 작성하여 봅시다.
		 * 구매하고자하는 과일을 입력하면
		 * 그에 맞는 가격이 출력되는 프로그램을 작성해 주세요.
		 * [출력]
		 * 구매하고자 하는 과일(사과(1000), 바나나(2000), 딸기(3000)) 입력 : 
		 * "xx의 가격은 xxxx입니다." 또는 "잘못입력하였습니다."
		 */
	
		
//		System.out.println("과일을 구매하는 프로그램");
//		System.out.println("구매하고자 하는 과일을 입력해주세요");
//		
//		System.out.print("구매하고자 하는 과일((사과(1000), 바나나(2000), 딸기(3000)) : ");
//		String fruit = sc.nextLine();
//		
//		sc.close();
//		
//		int won;
//		
//		if (fruit.equals("사과")) {
//			won = 1000;
//		} else if (fruit.equals("바나나")) {
//			won = 2000;
//		} else if (fruit.equals("딸기")) {
//			won = 3000;
//		} else {
//			System.out.println("잘못입력하였습니다");
//			return;
//		}
//		System.out.println(fruit + "의 가격은 " + won + "입니다.");
		
//		
//		switch(fruit) {
//		case "사과" :
//			System.out.println("사과의 가격은 1000원입니다");
//			break;
//		case "바나나" : 
//			System.out.println("바나나의 가격은 2000원입니다");
//			break;
//		case "딸기" :
//			System.out.println("딸기의 가격은 3000원입니다");
//			break;
//		default :
//			System.out.println("잘못입력하였습니다");
//		} 
		
		/*
		 * 해당 월의 일 수를 계산하는 프로그램
		 * 
		 * 1,3,5,7,8,10,12 => 31일
		 * 4,6,9,11 => 30일
		 * 2 => 28일
		 */
		
		int month, day;
		System.out.print("월을 입력하세요 : ");
		month = sc.nextInt();
		sc.nextLine();
		
		sc.close();
//		
//		switch(month) {
//		case 1 :
//		case 3 :
//		case 5 :
//		case 7 :
//		case 8 :
//		case 10 :
//		case 12 :
//			day = 31;
//			break;
//		case 4 :
//		case 6 :
//		case 9 :
//		case 11 :
//			day = 30;
//			break;
//		case 2 :
//			day = 28;
//			break;
//		default :
//			day = 0;
//			System.out.println("1~12까지만 입력가능합니다");
//			return;
//		}
		
		if (month >= 1 && month <= 12) {
			if (month % 2 != 0) {
				if (month == 9 || month == 11) {
					day = 30;
				}else {
					day = 31;
				}
			} else if (month == 8 || month == 12) {
				day = 31;
			} else if (month == 4 || month == 6) {
				day = 30;
			} else {
				day = 28;
			}	
		} else {
			System.out.println("1~12까지만 입력가능합니다.");
			return;
		}
		
		System.out.println(month + "월은 " + day + "일입니다.");
		
	}	
}
