import java.util.Scanner;

public class Test240117 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		//사용자로부터 정수형 변수 num1과 num2를 입력받아 큰값에서 작은값을 뺀 결과를 출력하세요.
		int num1, num2;
		System.out.print("첫번째 정수 입력 : ");
		num1 = sc.nextInt();
		
		System.out.print("두번째 정수 입력 : ");
		num2 = sc.nextInt();
		
		if (num1 > num2) {
			System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		} else {
			System.out.println(num2 + " - " + num2 + " = " + (num2 - num1));
		}
		*/
		
		/*
		// 85에서 10까지 수를 1씩 줄여가며 모든 사이에 숫자를 출력하세요.
		for (int i = 85; i >= 10; i--) { // 85 ~ 9
			System.out.println(i);
		}
		*/
		
		//임의의 숫자 하나(1~5)를 생성하고 이를 맞추는 프로그램 작성
		// 몇번만에 맞췄는지를 출력하세요.
		//ex)
		// 컴퓨터가 생각하는 수는 : 4(사용자입력)
		// 컴퓨터가 생각하는 수는 : 2(사용자입력)
		// 정답입니다 2번만에 맞추셨습니다.
		// Math.random() * 5 + 1  => 1~5 난수발생 => target이라는 변수 저장
		// count변수 하나만들어서 몇번입력했는지 횟수를 누적하면서
		// do - while을 이용해서 반복해서 입력받기(사용자가 입력한 값이 target과 같은면 탈출)
		
		/*
		int target = (int)(Math.random() * 5 + 1); // 1~5사이의 난수 발생
		int num, count = 0; // 몇번 질문했는지를 저장하는 변수
		do {
			System.out.print("컴퓨터가 생각하는 수는 : ");
			num = sc.nextInt(); // 사용자 입력값 받기
			
			count++; // 질문횟수 1 증가
		} while(target != num); // 사용자가 입력한 값과 컴퓨터가 만들어낸 난수가 다르면 계속 반복
		
		System.out.printf("정답입니다. %d번만에 맞추셨습니다", count );
		*/
		
		/*
		//길이가 10인 배열을 선언하고 1부터 10까지의 값을 반복문을 이용하여
		//순서대로 대입하고 그 값을 출력하세요.
		
		int[] arr = new int[10]; // 배열생성
		// 필요한 값 : 1 ~ 10
		// 배열index: 0(+1) ~ 9(+1)
		//대입을 위한 반복
		for (int i = 0; i < arr.length; i++) { //i => 0~9
			arr[i] = i + 1;
		}
		
		//출력을 위한 반복
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		*/
		
		
		//로또 추첨 번호를 예상하는 프로그램 작성
		//임의의 숫자를 1에서 45까지 총 6개 추첨하여 당첨번호를 구합니다.
		//중복된 숫자는 있으면 안된다.
		// 길이가 6인 배열만들고
		// 반복문을 통해서 6개의 난수를 각각의 배열의 인덱스값에 대입
		// 단 생성한 난수가 이미 배열에 존재하는 값일 경우
		// 다시 생성해서 대입
		
		int[] arr = new int[6]; // 6개의 값을 저장하기위한 배열 생성
		
		for (int i = 0; i < arr.length; i++) { // 랜덤값 6개를 받기위한 반복 index : 0~5
			arr[i] = (int)(Math.random() * 45 + 1); // 1~45사이의 랜덤값을 배열에 저장
			
			//중복검사
			if (i > 0) {
				for (int j = 0; j < i; j++) { // 배열을 전부 확인
					if (arr[i] == arr[j]) {
						i--; // 중복이 존재하므로 i값을 1줄여서 다시 arr[i]의 값을 넣어준다.
						break;
					}
				}
			}
		}
		
		System.out.printf("%d %d %d %d %d %d", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
	}
}
