import java.util.Scanner;

public class Array06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
		 * 3이상인 홀수 자연수를 입력 받아 해당 크기의 배열을 생성한다.
		    배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
			중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
			단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
			다시 정수를 받도록 하세요.
			
			
			
			3이상인 홀수 자연수 입력받기
			해당크기의 배열을 생성
			배열중간까지는 1부터 1씩증가하여 값을 넣고
			중간이후부터는 1씩 감소하면서 값을 넣어라
			
			입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
			다시 정수를 받도록 하세요.
		 */
		
		System.out.print("정수 : ");
		int num = sc.nextInt(); // 5
		
		//정상적인 수 입력시 반복안함
		while(num % 2 == 0 || num < 3) {
			System.out.println("다시 입력하세요.");
			System.out.print("정수 : ");
			num = sc.nextInt();
		}
		
		
		int[] arr = new int[num]; // 입력받은 정수크기의 정수형배열 선언 -> 크기가 5인 배열 arr선언
		int mid = num / 2; //2
		int count = 0;
		
		//배열중간까지는 1부터 1씩증가하여 값을 넣고
		arr[0] = 1;
		for (int i = 1; i <= mid; i++) { // 1, 2
			arr[i] = arr[i - 1] + 1;
		}
		
		for (int i = mid + 1; i < arr.length; i++) { // 3, 4
			arr[i] = arr[i - 1] - 1;
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	
//	
//	for (int i = 0; i < arr.length; i++) {
//		if (i <= mid) {
//			arr[i] = ++count;
//		} else {
//			arr[i] = --count;
//		}
//	}
}
