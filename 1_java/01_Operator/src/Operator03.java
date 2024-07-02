
public class Operator03 {

/*
 * 산술연산자 ( 이항연산자 == 두 개의 값을 가지고 연산한다 )
 * + - * / %
 * 우선순위 : * / % > + -	
 * 
 * 복합 대입 연산자
 * 산술 연산자와 대입 연산자가 결합되어있는 형태
 * 연산처리 속도가 빨라지므로 사용하는 걸 권장!
 * += -= /= *= %=
 * ( a = a + 3 ) == ( a += 3)
 * ( a = a - 3 ) == ( a -= 3)
 * ( a = a * 3 ) == ( a *= 3)
 * ( a = a % 3 ) == ( a %= 3)  
 */
	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		
		int c = ( ++a ) + b; // a = 6, b = 10, c = 16
		int d = c / a; // a = 6, b = 10, c = 16 , d = 2
		int e = c % a; // a = 6, b = 10, c = 16 , d = 2, e = 4
		int f = e++; // a = 6, b = 10, c = 16 , d = 2, e = 4 , f = 4
		int g = ( --b ) + ( d-- ); // a = 6, b = 9, c = 16 , d = 2, e = 5 , f = 4, g = 11
		int h = 2;
		int i = ( a++ ) + b / ( --c / f ) * ( g-- - d ) % ( ++e + h ); // a = 6, b = 9, c = 16 , d = 1, e = 5 , f = 4, g = 11, i = 
		// 6 + 9/(15/4) * (11-1) % (6 + 2)
		// 6 + 9/3 * 10 % 8
		// 6 + 3 * 10 % 8
		// 6 + 30 % 8
		// 6 + 6
		
		
		
		
		
		System.out.println(a + b); // 15
		System.out.println(a - b); // -5
		System.out.println(a * b); // 50
		System.out.println(a / b); // 0
		System.out.println(a % b); // 5
		
		System.out.println( "a : " + a); // 
		System.out.println( "b : " + b);
		System.out.println( "c : " + c);
		System.out.println( "d : " + d);
		System.out.println( "e : " + e);
		System.out.println( "f : " + f);
		System.out.println( "g : " + g);
		System.out.println( "h : " + h);
		System.out.println( "i : " + i);
	}

}
