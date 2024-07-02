
public class A_Array02 {
	public static void main(String[] args) {
		/*
		int i = 10;
		int[] iArr = new int[5];
		System.out.println(iArr);
		
		double[] dArr = new double[3];
		System.out.println(dArr);
		*/
		
		/* 
		 * 실제 리터럴값을 곧바로 담을 수 있는 변수를 일반변수라고 이야기한다.
		 * 주소값을 담고 있는 변수는 참조 변수(레퍼런스 변수)라고 표현
		 * 
		 * 기본자료형(boolean, int, char, byte, long, double등등)으로 선언된 변수
		 * => 실제 리터럴 값을 바로 담는 변수 => 일반변수
		 * 
		 * 그외 자료형(int[], double[], char[], ..., String, Scanner)
		 * => 참조변수
		 */
		
		
		int[] iArr = new int[10]; // 0~9번 인덱스
		double[] dArr = new double[4]; // 0~3번 인덱스
		// 배열 선언하고 크기지정(할당)까지만 한 상태
		// 그럼 각각의 인덱스에 초기화가 되어있는가?
		
		//iArr 전부 출력
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		System.out.println(iArr[0]);
		
		System.out.println();
		
		//dArr 전부 출력
		for(int i = 0; i < dArr.length; i++) {
			System.out.print(dArr[i] + " ");
		}
		
		//내가 각 인덱스의 초기화를 하지 않아도 값들이 담겨 있다.
		// Heap이라는 공간에 절대 빈공간이 존재할 수 없어서
		// => 따라서 공간이 만들어질 때 JVM이 기본값으로라도 초기화를 진행해준다.
		
		System.out.println(iArr); // 배열의 자료형 + @ + 주소값의 16진수형태
		System.out.println(iArr.hashCode()); // 주소값의 10진수 형태
		System.out.println("안녕하세요".length());
		System.out.println(iArr.length); // 배열의 길이
		
		int[] arr = null; //아무것도 참조하고있지 않음
		// 주소값을 담는 참조변수의 기본값이 null이다.
		System.out.println(arr);
		
		/*
		 * null을 가지고 있는 참조변수에 접근하여 다른 정보를 구하고자 한다면
		 * 항상 오류가 발생한다 => NullPointerException
		 * System.out.println(arr.hashCode());
		 * System.out.println(arr.length);
		 */
		
		arr = new int[5];
		System.out.println(arr[4]);
		/*
		 * ArrayIndexOutOfBoundsException
		 * : 배열에 부적절한 인덱스 제시시 발생(범위에서 벗어난 인덱스 제시)
		 * System.out.println(arr[5]);
		 */
		
		// 배열의 가장 큰 단점
		// - 한번 지정된 배열의 크기는 변경이 불가하다.
		// => 배열의 크기를 변경하고자한다면 다시 만들어야한다.
		System.out.println(arr.hashCode());
		arr = new int[7];
		System.out.println(arr.hashCode());
		// 주소값이 변경되었다 -> 새로운 곳을 참조하고 있다.
		
		/*
		 * 연결이 끊어진 기존 배열은 Heap영역에 둥둥 떠다님(어디에도 참조되어있지않아 사용되지 않음 => 필요없는 존재)
		 * => 일정시간이 지나면 "가비지컬렉터(GC)"가 알아서 지워줌
		 * => 자바에서의 "자동메모리 관리" 특징 == 개발자가 코드작성에만 집중할 수 있다.
		 */
		
		arr = null;
		// 배열을 강제로 삭제시키고자 한다면 => 연결고리를 끊어주면된다(null대입)
		
		
		//배열 선언, 할당, 초기화 전부 동시에 진행하기
		int[] arr2 = new int[] {1,2,3,4}; // 표현법1
		int[] arr3 = {1,2,3,4}; //표현법2
		
		System.out.println(arr2 == arr3); //false -> 각각의 변수에 담겨있는 주소값을 비교하기 때문에		
		
		
	}
}
