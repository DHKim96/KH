import java.util.Arrays;

public class B_Array_Copy {

	//배열 복사
	public static void main(String[] args) {
		/*
		int[] origin = {1, 2, 3, 4, 5};

		System.out.println("=== 원본 배열 출력 ===");
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println();
		
		//단순하게 origin을 다시 대입시킨 copy배열 세팅
		int[] copy = origin;
		System.out.println("=== 복사본 배열 출력 ===");
		for(int i=0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();
		
		copy[2] = 99;
		
		System.out.println("--------------- 복사본 배열 값 변경 후 ----------------------------");
		System.out.println("=== 원본 배열 출력 ===");
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println();
		
		System.out.println("=== 복사본 배열 출력 ===");
		for(int i=0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();
		// copy의 값만을 수정해도 원본의 값이 변경됨
		// 왜? origin과 copy가 같은 곳을 참조하고 있기 때문(즉, 메모리 주소값이 같다)
		// 얕은 복사 : 주소값을 복사
		*/
		
		/*
		 * 얕은복사의 문제점을 해결하기 위한 방법 : 깊은복사
		 * 
		 */
		
		/*
		// 1. for문을 활용한 방법
		//	  새로운 배열을 만들어서 반복문을 통해 원본배열의 값들을 새로운 배열에 대입
		int[] origin = {1, 2, 3, 4, 5};
		
		//int[] copy = origin;
		int[] copy = new int[5];
		for (int i=0; i < origin.length; i++) {
			copy[i] = origin[i];
		}
		
		copy[2] = 99;
		
		System.out.println("--------------- 복사본 배열 값 변경 후 ----------------------------");
		System.out.println("=== 원본 배열 출력 ===");
		for(int i = 0; i < origin.length; i++) {
			System.out.print(origin[i] + " ");
		}
		System.out.println();
		
		System.out.println("=== 복사본 배열 출력 ===");
		for(int i=0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();
		*/
		
		/*
		// 2. 새로운 배열 생성 후 arraycopy() 메소드를 이용해서 복사하기
		int[] origin = {1,2,3,4,5};
		int[] copy = new int[10]; // 0~9번 인덱스 모든 값은 0으로 초기화되어있음
		
		// System.arraycopy(원본배열, 복사시작할인덱스, 복사본배열, 복사본배열의복사시작인덱스, 복사할갯수);
		
		System.arraycopy(origin, 2, copy, 0, 3);
		for(int i=0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		System.out.println();
		System.out.println(origin);
		System.out.println(copy);
		// 주소값이 다름(깊은복사)
		// => 각자 다른 배열을 참조하고 있음
		// => 즉, 배열 수정시 서로에게 영향 주지 않음
		*/
		
		/*
		//3. Arrays클래스에서 제공하는 copyOf()메소드이용
		int[] origin = {1,2,3,4,5};
		
		// 복사본 배열 = Arrays.copyOf(원본배열명, 복사할길이);
		int[] copy = Arrays.copyOf(origin, 5);
		
		origin[1] = 44;
		
		for(int i=0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		
		/*
		 * Arrays.copyOf 메소드
		 * => 내가 제시한 길이만큼 복사본 배열 크기 할당
		 * => 단, 내가 제시한 길이가 원본배열의 크기보다 클 경우 기존의 배열에 있는 값 다 복사 나머지는 0으로 채움
		 */
		
		
		//4. clone() 메소드 활용한 복사
		// 인덱스 지정불가, 크기지정 불가
		
		int[] origin = {1,2,3,4,5};
		int[] copy = origin.clone();
		
		origin[1] = 44;
		
		for(int i=0; i < copy.length; i++) {
			System.out.print(copy[i] + " ");
		}
		System.out.println();
		
		System.out.println(origin);
		System.out.println(copy);
	}

}
