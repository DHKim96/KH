import java.util.Scanner;

public class ControllAndLoop01 {
	public static void main(String[] args) {
		/*
		 * 사용자로부터 문자열을 입력받고 문자열의 검색될 문자를 입력받아 해당문자가 몇개 있는지 개수를 출력하세요.
		 * 그리고 다시하시겠습니까? : 표시해준뒤 y를입력하면
		 * 다시 반복하고 다른문자를 입력하면 종료
		 * 
		 * 문자열 : banana
		 * 문자 : a
		 * banana안에 포함된 a의 개수 : 3
		 * 다시 하시겠습니까?(y/n) : y
		 * 
		 * 문자열 : banana
		 * 문자 : a
		 * banana안에 포함된 a의 개수 : 3
		 */
		Scanner sc = new Scanner(System.in);
		
		String str;
		char ch, tobeContinue;
		int count;
		do {
			System.out.print("문자열  : ");
			str = sc.next();
			
			System.out.print("문자 : ");
			ch = sc.next().charAt(0);
			
			count = 0;
			for (int i=0; i < str.length(); i++) {
				if (str.charAt(i) == ch) {
					count++;
				}
			} // count에는 모든 문자중 사용자가 입력한 문자가 몇개 있는지 저장
			
			System.out.println(str + "에 포함된 " + ch + "의 개수 : " + count);
			
			System.out.print("다시하시겠습니까?(y/n) :");
			tobeContinue = sc.next().charAt(0);
		} while(tobeContinue == 'y');
		
		System.out.println("종료합니다.");
		
	}
}
