import java.util.Scanner;
public class Practice1 {
	/*
	 * 이름, 성별, 나이, 키를 사용자에게 입력받아 각각의 값을 변수에 담고 출력하세요.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name;
		char gender;
		int age;
		double height;
		
		System.out.print("이름을 입력해주세요 : " );
		name = sc.nextLine();
		System.out.print("성별을 입력해주세요 : " );
		gender = sc.next().charAt(0);
		/*문자열.charAt(index) : 문자열에서 내가 원하는 index의 글자를 가져온다.
		 *index : 몇번째냐
		 *컴퓨터의 첫번째 글자는 0번째임
		 */
		System.out.print("나이를 입력해주세요 : " );
		age = sc.nextInt();
		sc.nextLine();
		System.out.print(" 키를 입력해주세요 : " );
		height = sc.nextDouble();
		sc.nextLine();
		sc.close();
	
		System.out.println("이름 : " + name);
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + age);
		System.out.println(" 키 : " + height);
		System.out.println(" 키 " + height + "cm인 " + age + "살 " + gender + "자 " + name + "님 반갑습니다^^");
		System.out.printf("키 %.1f인 %d살 %c자 %s님 반갑습니다^^", height, age, gender, name);
		//%f인 하면 소숫점 아래 float 자리까지 나옴 따라서 %.1f 처럼 소숫점 자리 지정해줄 것
		
		
	}

}
