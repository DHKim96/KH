import java.util.Scanner;

public class Test240116 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		//정수형 변수 num1, num2를 사용자로부터 입력받아
		// + - * / % 의 결과값을 각각 출력하세요.
		int num1, num2;
		System.out.print("첫번째 정수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		num2 = sc.nextInt();
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
		System.out.printf("%d %% %d = %d",num1, num2, (num1 % num2));
		*/
		
		/*
		//가위바위보를 진행합니다. user1의 가위,바위,보 정보와
		// user2의 가위,바위,보 정보를 받아 누가 이겼는지를 출력하세요.
		// 가위바위보 정보는 숫자로 입력받습니다(가위 = 1, 바위 = 2, 보 = 3)
		
		int user1, user2;
		System.out.println("user1 입력(가위 = 1, 바위 = 2, 보 = 3) : ");
		user1 = sc.nextInt();
		
		while (user1 > 3 || user1 < 1) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("user1 입력(가위 = 1, 바위 = 2, 보 = 3) : ");
			user1 = sc.nextInt();
		}
		
		System.out.println("user2 입력(가위 = 1, 바위 = 2, 보 = 3) : ");
		user2 = sc.nextInt();
		
		while (user2 > 3 || user2 < 1) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("user2 입력(가위 = 1, 바위 = 2, 보 = 3) : ");
			user2 = sc.nextInt();
		}
		
		if (user1 == user2) {
			System.out.println("무승부 입니다.");
		} else if((user1 == 1 && user2 == 3) || (user1 == 2 && user2 == 1) || (user1 == 3 && user2 == 2)) {
			System.out.println("user1이 승리하였습니다.");
		} else {
			System.out.println("user2가 승리하였습니다.");
		}
		*/
		
		
		/*
		// 15 ~ 111까지의 수를 순서대로 출력하세요.
		
		for(int i = 15; i <= 111; i++) {
			System.out.print(i + " ");
		}
		*/
		
		/*
		// 숫자를 입력받아 * 2인 숫자를 출력하세요.
		// 유저가 숫자 0을 입력할때까지 반복하세요.
		
		int num;
		
		while(true) {
			System.out.print("숫자 입력 : ");
			num = sc.nextInt();
			
			if (num == 0) {
				System.out.println("종료합니다.");
				break;
			}
			
			System.out.println(num + " * 2 = " + (num * 2));
		}
		*/
		
		
		// user3의 가위바위보 정보를 입력받고
		// 컴퓨터의 랜덤한 가위바위보 정보를 생성해
		// 누가 이겼는지를 출력하세요.
		// 가위바위보 정보는 숫자로 입력받습니다(가위 = 1, 바위 = 2, 보 = 3)
		// 해당 행위를 user3이 5를 입력받을 때까지 반복하세요.
		
		/*
		int user1, com;
		System.out.println("user1 입력(가위 = 1, 바위 = 2, 보 = 3) : ");
		user1 = sc.nextInt();
		
		while (user1 > 3 || user1 < 1) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("user1 입력(가위 = 1, 바위 = 2, 보 = 3) : ");
			user1 = sc.nextInt();
		}
		
		com = (int)(Math.random() * 3 + 1);
		
		if (user1 == com) {
			System.out.println("무승부 입니다.");
		} else if((user1 == 1 && com == 3) || (user1 == 2 && com == 1) || (user1 == 3 && com == 2)) {
			System.out.println("user1이 승리하였습니다.");
		} else {
			System.out.println("컴퓨터가 승리하였습니다.");
		}
		*/
	}
}
