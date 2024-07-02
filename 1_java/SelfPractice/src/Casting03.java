
public class Casting03 {

	public static void main(String[] args) {
		// 선언및 초기화된 5개의 변수를 가지고 알맞은 사칙연산(+, -, *, /)과 형변환을 이용하여
		//다음과 같은 값이 나오도록 코드를 작성하세요.

		int iNum1 = 10;
		int iNum2 = 4;
		
		float fNum = 3.0f;
		
		double dNum = 2.5;
		char ch = 'A';
		
		System.out.println(iNum1 /iNum2);
		System.out.println((int)dNum);
		
		System.out.println(iNum2 * dNum);
		System.out.println((float)iNum1);
		
		System.out.println((float)iNum1 / iNum2);
		System.out.println(dNum);
		
		System.out.println((int)fNum);
		System.out.println(iNum1 / (int)fNum);
		
		System.out.println(iNum1 / fNum);
		System.out.println((double)iNum1 / fNum);
		
		System.out.println(ch);
		System.out.println((int)ch);
		System.out.println(ch + iNum1);
		System.out.println((char)(ch + iNum1));
	}

}
