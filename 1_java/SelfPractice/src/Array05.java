import java.util.Scanner;

public class Array05 {
	public static void main(String[] args) {
		/*
		 	사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고		 	
			배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.		
			그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int size = sc.nextInt(); 
		int sum = 0;
		
		int[] arr = new int[size]; 
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("배열 %d번째 인덱스에 넣을 값 : ", i);
			arr[i] = sc.nextInt(); 
		}
		
		for(int i=0; i < arr.length; i++) { 
			System.out.print(arr[i] + " ");
			sum += arr[i];
		}
		System.out.println("\n총 합 : " + sum);
		
	}
}
