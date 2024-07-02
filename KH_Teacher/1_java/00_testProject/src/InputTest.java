import java.util.Scanner;
// 1. Scanner를 사용하기 위해서 외부로부터 가져온다

public class InputTest {
	/*
	 * 키보드로 값을 입력하는 방법
	 * Scanner를 사용한다.
	 * (java.util.Scanner 클래스를 이용하는 것이다)
	 * Scanner 클래스 내부의 메소드를 호출하여 입력받는 것
	 * 
	 * [사용법]
	 * Scanner 이름 = new Scanner(System.in);
	 * ex) Scanner sc = new Scanner(System.in);
	 * 
	 * sc.next() : 사용자가 입력한 값 중 공백이 있을 경우 공백 이전까지의 값만 읽어옴
	 * sc.nextLine() : \n(개행문자)를 포함하는 한 라인을 읽고 '\n'을 버린 나머지만 가져옴
	 * 
	 * sc.nextByte(),  sc.nextShort(),  sc.nextInt(),  sc.nextLong()
	 * sc.nextFloat(),  sc.nextDouble(), 
	 * 위처럼 정수나 실수를 입력받는 코드를 작성했을 때 \n 토큰이 함께 들어오기 때문에
	 * sc.nextLine()을 통해서 비워주는 코드를 작성해야한다. 
	 * 
	 * close() : 더이상 Scanner 를 사용하지 않겠다.
	 * hasNext() : 현재 Scanner 공간에 사용자로 부터 입력받은 값이 남아있는지 확인
	 * 				없으면 다른 값이 들어올때까지 무작정 기다립니다. 기다렸다가 true리턴
	 * 
	 */
	public static void main(String[] args) {
		//2. Scanner 클래스의 객체를 생성한다
//		Scanner sc = new Scanner(System.in);
		//System.in은 입력받은 값을 바이트 단위로 받아들이겠다
		//출력시에는 System.out 이라는 구문을 사용했다.
		
//		System.out.print("아무거나 입력하세요 : ");
//		String st1 = sc.next();
//		String st2 = sc.next();
//		String st3 = sc.next();
//		
//		System.out.println(st1);
//		System.out.println(st2);
//		System.out.println(st3);
		
//		System.out.print("한줄 입력받기 : ");
//		String st1 = sc.nextLine();
//		System.out.println(st1);

//		System.out.print("이름을 이력하세요 : ");
//		String name = sc.next();
//		
//		System.out.print("나이를 입력하세요 : ");
//		int age = sc.nextInt();
//		sc.nextLine(); // 위에서 사용한 nextInt() 때문에 함께 들어온 \n을 비워주는 코드 
//		
//		System.out.print("주소를 입력하세요 : ");
//		String add = sc.nextLine();
//		
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(add);
//		
//		sc.close();
		
		
		//스캐너 객체 생성
		Scanner input = new Scanner(System.in);
		String name, address;
		int age;
		
		System.out.println("==================================================");
		System.out.print("이름을 입력해주세요 : ");
		name = input.nextLine();
		System.out.print("나이를 입력하세요 : ");
		age = input.nextInt();
		input.nextLine();
		
		System.out.print("주소를 입력하세요 : ");
		address = input.nextLine();
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + address);
		System.out.println("==================================================");
		
		
	}
}
