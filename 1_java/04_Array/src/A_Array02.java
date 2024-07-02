
public class A_Array02 {
	public static void main(String[] args) {
		/*
		int i = 10;
		int[] iArr = new int[5];
		
		double[] dArr = new double[3]; //0.0으로 초기화 되어있음
		System.out.println(dArr);
		*/
		
		/*
		 * 실제 리터럴값을 곧바로 담을 수 있는 변수를 일반 변수라고 이야기함.(참조변수는 아직 크기가 정해져있지 않기에 new 이후에 ~)
		 * 주소값을 담고 있는 변수는 참조 변수(레퍼런스 변수)라고 표현
		 * 
		 * 기본 자료형(boolean, int, char, long, double 등등)으로 선언된 변수
		 * => 실제 리터럴 값을 바로 담는 변수 => 일반 변수
		 * 
		 * 그외 자료형(int[], double[], char[], ... , String, Scanner)
		 * => 참조변수
		 */
		
		int[] iArr = new int[3]; // 0 ~ 2번 인덱스
		double[] dArr = new double[4]; // 0 ~ 3번 인덱스
		// 배열 선언하고 크기 지정(할당)까지만 한 상태
		// 그럼 각각의 인덱스에 초기화가 되어 있는가?
		
		for (int i = 0 ; i < 3; i++) {
			System.out.println(iArr[i]);
		}
		System.out.println( );
		
		for (int i = 0 ; i < 4; i++) {
			System.out.println(dArr[i]);
		}
		//내가 각 인덱스를 초기화하지 않아도 값들이 담겨 있음
		// Heap 이라는 공간은 절대 빈 공간이 존재할 수 없음
		// => 따라서 공간이 만들어질 때 JVM이 기본값으로라도 초기화 진행
		
		System.out.println(iArr); // 배열의 자료형 + @ + 주소값의 16진수 형태
		System.out.println(iArr.hashCode()); // 주소값의 10진수 형태
		System.out.println("안녕하세요".length()); //문자열은 .length 후 소괄호 필요
		System.out.println(iArr.length);
		
		//배열의 길이 활용하여 iArr 전부 출력하기
		for (int i = 0 ; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
		
		int[] arr = null; // 아무것도 참조하고 있지 않음
		//주소값을 담는 참조변수의 기본값 == null
		System.out.println(arr);
//		System.out.println(arr.length);
		// java.lang.NullPointerException 에러
		// .length 는 해당 주소값의 길이
		// null 은 가리키고 있는 주소가 없음. 따라서 에러 발생
		
		/*
		 * null을 가지고 있는 참조변수에 접근하여 다른 정보를 구하고자 한다면
		 * 항상 오류가 발생한다 => NullPointerException (가리키고 있는게 없음을 의미)
		 * ex) System.out.println(arr.length); 
		 */
		System.out.println();
		
		arr = new int[5];
		System.out.println(arr[4]);

		/*
		 * java.lang.ArrayIndexOutOfBoundsException
		 *  : 배열에 부적절한 인덱스(범위에서 벗어난 인덱스) 제시시 발생
		 *   ex) System.out.println(arr[5]);
		 * 배열의 단점
		 * : 한 번 지정된 크기는 변경이 불가함. 유동적으로 값을 늘릴 수 없음.
		 *   배열의 크기를 변경하고자 한다면 다시 만들어야 함.
		 */
		
		System.out.println(arr.hashCode());
		arr = new int[7];
		System.out.println(arr.hashCode());
		// => 주소값이 변경되었음 즉, 새로운 곳을 참조하고 있음.
		
		/*
		 * 연결이 끊어진 기존 배열은 Heap 영역에 둥둥 떠다님(어디에도 참조되어있지않아 사용되지 않음. 필요없는 존재)
		 * => 일정 시간이 지나면 "가비지 컬렉터(GC)"가 알아서 지워줌
		 * => 자바에서의 "자동 메모리 관리" 특징 == 개발자가 코드 작성에만 집중할 수 있음
		 */
		
		arr = null;
		// 배열을 강제로 삭제시키고자 한다면 => 연결고리를 끊어주면 됨(null 대입)
		
		
		// 배열 선언, 할당, 초기화 전부 동시에 진행하기
		int[] arr2 = new int[] {1, 2, 3, 4}; // 표현법1
		int[] arr3 = {1, 2, 3, 4}; // 표현법2
		
		// 배열 비교하기 
		System.out.println(arr2 == arr3); //false. why? 각각의 변수에 담겨 있는 주소값을 비교하기 때문
	}
}
