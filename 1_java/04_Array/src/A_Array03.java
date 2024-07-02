import java.util.Scanner;

public class A_Array03 {
	public static void main(String[] args) {
		//1. 크기가 10인 정수형 배열 생성 후
		// 2. 반복문을 활용해서 0번 인덱스부터 마지막 인덱스까지 순차적으로 접근하면서 값을 대입해라 
			// 	매번 1 ~ 100 사이의 랜덤값
		//3. 반복문을 활용해서 해당 배열의 0번 인덱스 ~ 마지막 인덱스까지 담겨 있는 값을 전부 출력
				//arr[x] : xx
//		int[] arr1 = new int[10];
//		for (int i = 0 ; i < arr1.length ; i++) {
//			arr1[i] = (int)(Math.random() * 100 + 1);
//			System.out.printf("arr[%d] : %d\n", i, arr1[i]);
//		}
		
		try (/*
				 * 1. 사용자에게 배열의 길이를 입력받은 후 해당 크기의 문자열 배열을 생성해라
				 * 2. 반복문을 활용해서 매번 사용자에게 과일 명을 입력받아 그 값을 매 인덱스 자리에 대입해라(0 번째 인덱스 ~ 마지막 인덱스)
				 * 3. 반복문을 이용해서 0번째 ~ 마지막 인데스까지 담긴 값을 출력 
		
				 */
		//		int size;
		Scanner sc = new Scanner(System.in)) {
		}
		
		/*
		 * 사용자에게 문자열 하나 입력받은 후
		 * 각각의 인덱스에 있는 문자들을 char 배열에 옮겨 담기
		 * 
		 * 1. 사용자에게 문자열 한 개 입력받기
		 * 2. char 배열 생성해두기(배열의 길이 == 문자열의 길이)
		 * 3. 반복문을 통해서 해당 문자열에서 각각 인덱스별 문자를 char배열에 각 인덱스에 대입
		 * 4. 반복문을 이용해서 해당 배열의 0 ~ 마지막 인덱스까지 담긴 값을 출력
		 */
		

//		System.out.print("문자열을 입력하세요 : ");
//		String str = sc.nextLine();
//		char[] ch = new char[str.length()];
//		
//		for (int i = 0 ; i < str.length(); i++ ) { // i < ch.length 로 해도 상관없음
//			
//			ch[i] = str.charAt(i);
//			System.out.printf("ch[%d] : %c\n", i, ch[i]); //개행 문자 잊지 말 것
//		}
		
		/*[1, 3, 5, 4, 2]
		 * 1. 사용자에게 배열의 길이를 입력받은 후 해당 크기만큼의 정수 배열을 생성해라
		 * 2. 반복문을 활용해서 0 ~ 마지막 인덱스까지 매번 1 ~ 100 의 랜덤값을 발생시켜 대입해라
		 * 3. 반복문을 활용해서 배열에 담긴 모든 값을 출력함과 동시에 짝수인 값()들의 총 합을 구해라
		 * 4. 위에서 구한 짝수 값의 총합을 출력해라
		 */
		
//		int size, sum = 0;
//		
//		System.out.print("배열의 길이 : ");
//		size = sc.nextInt();
//		
//		int[] arr = new int[size];
//		
//		for (int i = 0 ; i < arr.length ; i++) {
//			arr[i] = (int)(Math.random()*100 + 1);
//			System.out.printf("arr[%d] : %d\n", i, arr[i]);
//			
//			if (arr[i] % 2 == 0 ) {
//				sum += arr[i];
//			}
//		}
//		System.out.println("짝수의 총 합 : " + sum);
		
		
	}

}
