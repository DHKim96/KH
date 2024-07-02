
public class C_Array_Two {

	/*
	 * 2차원 배열
	 * 자료형이 같은 1차원 배열의 묶음으로 배열안에 다른 배열이 존재한다.
	 * 2차원 배열은 할당된 공간마다 인덱스번호를 두개 부여(앞번호는 몇번째 1차원 배열인지, 뒷번호는 1차원배열의 몇번째 index인지를 구분)
	 */
	public static void main(String[] args) {
		/*
		 * 1. 2차원 배열선언 (1차원 배열의 묶음을 참조하는 2차원배열 참조변수를 만들겠다.)
		 * 	  자료형 배열명[][];
		 * 	  자료형[][] 배열명;
		 */
		
//		int[][] arr;
		
		/*
		 * 2. 배열 할당(실제 m크기의 1차원 배열 n개를 만들어서 참조)
		 * 	 배열명 = new 자료형[n][m];
		 * 
		 * 1차원 배열의 참조변수 묶음 먼저 생성가능
		 * 배열명 = new 자료형 [n][];
		 * 배열명[0] = new int[4];
		 * 배열명[1] = new int[4];
		 * 배열명[2] = new int[4];
		 */
		
//		arr = new int[3][4];
//		arr = new int[3][];
//		arr[0] = new int[4];
//		arr[1] = new int[4];
//		arr[2] = new int[4];
//		
//		// * 배열 선언과 동시에 할당(생성과 동시에 크기지정)
//		int[][] tmp = new int[5][5]; // 5크기의 1차원배열 5개를 가진 2차원 배열 생성
//		
		/*
		 * 3. 값 대입
		 *   배열명[배열순번][인덱스] = 값;
		 */
//		arr[0][0] = 1;
//		arr[1][1] = 2;
//		arr[2][3] = 3;
		
		
		
		
		// 3행 3열짜리 문자열 배열을 선언 및 할당하고 인덱스 0행0열부터 2행2열까지 차례대로 접근하여 (행,열)값을 
		//저장한 후 출력하세요.
		
		String[][] arr = new String[3][3];
		
		for (int row = 0; row < arr.length; row++) {
			for(int col = 0; col < arr[row].length; col++) {
				arr[row][col] = "(" + row + ", " + col + ")";
			}
		}

		for (int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr[r].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
	}

}
