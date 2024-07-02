
public class A_Array {
	public static void main(String[] args) {
		/*
		 * 변수 : 하나의 공간에 하나의 값을 담을 수 있다.
		 * 배열 : 하나의 공간에 여러개의 값을 담을 수 있는 개념
		 * 		 "같은 자료형의 값"으로만 담을 수 있다.
		 * 		 정확히 얘기하자면 배열의 각 인덱스 자리에 실제 값이 담김(index는 0부터 시작한다.)
		 */
		
		
		// 배열을 왜 사용할까?
		// 변수만을 사용하게 된다면 -> 대량의 데이터들을 보관하고자 할 때 각각의 변수를 만들어서 따로 관리해야한다.
		/*
		int num1 = 0;
		int num2 = 1;
		int num3 = 2;
		int num4 = 3;
		int num5 = 4;
		
		//int[] arr1 = new int[5];
		int[] arr1 = {0, 1, 2, 3, 4};
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		
		int sum = num1 + num2 + num3 + num4 + num5;
		*/
		
		/*
		 * 1. 배열선언 (여러개의 값들을 보관할 배열을 만들겠다!!)
		 * 	  자료형 배열명[];
		 * 	  자료형[] 배열명;
		 */
		
		int[] arr;
		
		/*
		 * 2. 배열 할당 (이 배열에 몇개의 값들을 보관할껀지 크기지정하는 과정, 그 갯수만큼의 방이 만들어짐)
		 * 	 배열명 = new 자료형[배열의 크기];
		 */
		arr = new int[5];
		
		// * 배열 선언과 동시에 할당(생성과 동시에 크기지정)
		int[] tmp = new int[5];
		
		
		/*
		 * 3. 값 대입
		 *   배열명[인덱스] = 값;
		 */
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		
		for (int i = 0; i < 5; i++) {
			arr[i] = 1;
		}
		
		// 배열의 장점 :  반복문 활용 가능
		for (int i = 0; i < 5; i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println(arr);// 실제 arr이라는 박스에는 "주소값"이라는게 담겨있음 -> 이상한 문구가 출력됨
	}
}
