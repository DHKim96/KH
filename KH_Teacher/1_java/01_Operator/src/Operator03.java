
public class Operator03 {

	/*
	 * 산술연산자 (이항 연산자 == 두개의 값을 가지고 연산한다)
	 * + - * / %
	 * 
	 * * / %  >  + -
	 * 
	 * 복합 대입 연산자
	 * 산술연산자와 대입연산자가 결합되어있는 형태
	 * 연산처리 속도가 빨라지므로 사용하는 걸 권장!
	 * 
	 * += -= /= *= %=
	 * 
	 * a = a + 3;     ->   a += 3;
	 * a = a - 3;     ->   a -= 3;
	 * a = a * 3;     ->   a *= 3;
	 * a = a / 3;     ->   a /= 3;
	 * a = a % 3;     ->   a %= 3;
	 */
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		
		int c = (++a) + b; // a=6, b=10, c= 16
		int d = c / a; // a=6, b=10, c=16, d=2
		int e = c % a; // a=6, b=10, c=16, d=2, e=4
		int f = e++; // a=6, b=10, c=16, d=2, e=4(5), f=4
		int g = (--b) + (d--); // a=6, b=9, c=16, d=2(1), e=5, f=4, g=11
		int h = 2; // a=6, b=9, c=16, d=1, e=5, f=4, g=11, h=2
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h);
		//		  6   + 9 / (15 / 4) * (11 - 1) % (6 + 2);
		//		  6   + 9 /   3   * 10 % 8
		//		  6   +  3  * 10 % 8
		//        6   +  30  % 8
		//		  6   +  6
		//        12
		
//		System.out.println(a + b);
//		System.out.println(a - b);
//		System.out.println(a * b);
//		System.out.println(a / b);
//		System.out.println(a % b);
		System.out.println("a : " + a);//
		System.out.println("b : " + b);//
		System.out.println("c : " + c);//
		System.out.println("d : " + d);//
		System.out.println("e : " + e);//
		System.out.println("f : " + f);//
		System.out.println("g : " + g);//
		System.out.println("h : " + h);//
		System.out.println("i : " + i);//
	}

}
