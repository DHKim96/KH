//1. Scanner를 사용하기 위해서 외부로부터 가져온다.

import java.util.Scanner;

public class InputTest {
	/*
	 * 키보드로 값을 입력하는 방법
	 * Scanner를 사용함. - 사용자가 입력한 값을 사용하기 위한 것
	 * (java.util.Scanner 클래스를 이용하는 것.)
	 * Scanner 클래스 내부의 메소드를 호출하여 입력받는 것.
	 *
	 * [사용법]
	 * Scanner 이름 = new Scanner(System.in);
	 * ex)
	 * Scanner sc = new Scanner(System.in);
	 * sc.next() : 사용자가 입력한 값 중 공백이 있을 경우, 공백 이전까지의 값만 읽어옴
	 * sc.nextLine() : \n을 포함하는 한 라인을 읽고 '\n'을 버린 나머지만 가져옴.
	 * sc.nextByte(), sc.nextShort(), sc.nextInt(), sc.nextLong()
	 * sc.nextFloat(), sc.nextDouble()
	 * 위처럼 정수나 실수를 입력받는 코드를 작성했을 때 \n 토큰이 함께 들어오기 때문에
	 * sc.nextLine()을 통해서 비워주는 코드를 작성해야한다.
	 * 
	 * close() : 더이상 Scanner를 사용하지 않겠다고 선언하는 매서드.
	 * hasNext() : 현재 Scanner 공간에 사용자로부터 입력받은 값이 남아있는지 확인
	 *				없으면 다른 값이 들어올때까지 무작정 기다립니다. 기다렸다가 true리턴
	 */
	public static void main(String[] args) {
		//2. Scanner 클래스의 객체를 생성한다.
		//String str = new String("안녕");
		//Scanner 클래스의 객체를 생성
		//Scanner sc = new Scanner(System.in); 
		//System.in : 입력받은 값을 바이트 단위로 받아들이겠다.(코드로 들어오는 것)
		//System.out : 출력해서 화면으로 보내주겠다.(코드에서 나가는 것)
		
//		System.out.print("아무거나 입력하세요 : ");
//		String str = sc.next();
//		System.out.println(str);
//		String str2 = sc.next();
//		System.out.println(str2);
//		String str3 = sc.next();
//		System.out.println(str3);
//		String str4 = sc.next();
//		System.out.println(str4);
		
//		System.out.print("한줄 입력받기 : ");
//		String st1 = sc.nextLine();
//		System.out.println(st1);
		
//		System.out.print("이름을 입력하세요 : ");
//		String name = sc.next();
//		
//		System.out.print("나이를 입력하세요 : ");
//		int age = sc.nextInt(); // nextInt()는 숫자만 가져오기 때문에 Scanner 공간에 \n이 남음
//		sc. nextLine(); // 위에서 사용한 nextInt() 때문에 함께 들어온 \n을 비워주는 코드
//		// sc. nextLine()을 안써주면 \n이 남아서 아래의 sc.nextLine()이 바로 적용됨에 따라 add에 넣을 값이 없어짐.
//		
//		System.out.print("주소를 입력하세요 : ");
//		String add = sc.nextLine();
//		
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(add);
//		sc.close();
		
//		//스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		String name, address;
		int age; // 콤마로 이어서 다른 변수도 생성 가능.
		
		
		System.out.println("====================================");
		System.out.print("이름을 입력해주세요 : ");
		name = sc.nextLine();
		System.out.print("나이를 입력해주세요 : ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.print("주소를 입력해주세요 : ");
		address = sc.nextLine();
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + address);
		System.out.println("====================================");
		
		sc.close();
	}
}
