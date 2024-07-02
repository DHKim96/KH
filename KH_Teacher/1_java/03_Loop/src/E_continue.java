
public class E_continue {
	/*
	 * continue;  : 반복문 안에 기술되는 구문
	 * 				continue; 코드를 실행시 그 뒤의 코드를 실행하지않고 곧바로 다시 반복문의 상단으로 이동
	 */
	public static void main(String[] args) {
		// 1부터 10까지의 홀수 출력
		/*
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
		*/
		
		/*
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 0) { // 만약 i가 짝수일 때
				continue; // 반복문 내의 뒤의 구문들은 실행되지않고 반복문 위로 올라감(증감식)
			}
			
			System.out.print(i + " ");
		}
		*/
		
		//1부터 100까지의 총 합계
		//단, 6의 배수값은 빼고 덧셈 연산
		
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			if (i % 6 == 0) {
				continue;
			}
			
			sum += i;
		}
		System.out.println(sum);
	}
}
