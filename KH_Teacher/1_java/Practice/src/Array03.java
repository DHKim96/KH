import java.util.Scanner;

public class Array03 {

	public static void main(String[] args) {
		/*
		 * 문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇개 들어가 있는지
		 * 개수와 몇번째 인덱스에 위치하는지 인덱스를 출력하세요.
		 */

		Scanner sc = new Scanner(System.in);
		//1. 문자열을 입력받아
		System.out.print("문자열 : ");
		String str = sc.next(); //hello
		int count = 0;
		
		//2. 배열을 만들어서 문자열 -> 문자로 바꿔서 배열에 넣는다.
		char[] chArr = new char[str.length()]; // 길이가 내가입력한 문자의 길이와 같은 배열을 생성(hello -> 5)
		
		//3. 문자열 -> 문자로 바꿔서 배열에 넣는다.
		for (int i = 0; i < chArr.length; i++) {
			chArr[i] = str.charAt(i); // chArr[0] = 'h'; chArr[1] = 'e';
		}
		
		//4. 문자 하나 입력받기
		System.out.print("문자 : ");
		char target = sc.next().charAt(0);// 'l'
		
		// 5. 검색할 문자가 문자열에 몇개 들어가 있는지
		// 개수와 몇번째 인덱스에 위치하는지 인덱스를 검색
		
		System.out.print(str + "에 존재하는 위치(인덱스) : ");
		// hello에 존재하는 위치(인덱스) : 2, 3
		
		for (int index = 0; index < chArr.length; index++) {
			if (target == chArr[index]) { // 'l' == 'l'
				//배열의 i번째 값과 문자가 동일한지 체크   
				count++; // 동일한 문자 발견시 숫자 기록해주기
				System.out.print(index + " "); // 인덱스 출력
			}
		}
		System.out.println("\n" + target +"개수 : " + count);
	}

}
