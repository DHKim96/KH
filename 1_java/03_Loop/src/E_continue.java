
public class E_continue {
/*
 * continue; : 반복문 안에 기술되는 구문.
 * 				continue; 코드 실행시 그 뒤의 코드를 실행하지 않고 곧바로 다시 반복문의 상단으로 이동.
 */
	public static void main(String[] args) {
		//1~10의 홀수 출력
		/*
		 * for ( int i = 0 ; i < 11 ; i++ ) {
			if ( i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
		*/
		
		/*
		for ( int i = 1 ; i < 11 ; i++ ) {
			if ( i % 2 == 0 ) { //i가 짝수일 때 
				continue; // 다시 반복문의 상단(증감식)으로 이동. 반복문 내의 뒤의 구문들은 실행되지 않고 반복문 위로 올라감
			}
			System.out.print(i + " ");
		}
		*/
		
		//1 ~ 100 의 총 합계를 구해라
		//단, 6의 배수값은 빼고 덧셈 연산 진행할 것
		
		int sum = 0 ;
		for (int i = 1 ; i < 101 ; i++) {
			if (i % 6 == 0) {
				continue;
			}
			sum += i ;
		}
		System.out.println(sum);
		
	}
}
