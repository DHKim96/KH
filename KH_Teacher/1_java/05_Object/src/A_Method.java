
public class A_Method {
	public static void main(String[] args) {
		/*
		double myHeight = 175.9;
		hiEveryone(12, 12.5);
		hiEveryone(13, myHeight);
		byEveryone();
		*/
		
		
		int result;
		
		result = adder(4, 5); //adder가 반환하는 값을 result에 저장
		System.out.println("4 + 5 =" + result);
		System.out.println("3.5 * 3.5 =" + square(3.5));
		
		
	}
	
	public static int adder(int num1, int num2) {
		int addResult = adder(4,5);
		return addResult; //addResult의 값을 반환
	}
	
	public static double square(double num) {
		return num*num; // num * num의 결과를 반환
	}
	
	
	
	
	
	
	
	
	/*
	public static void hiEveryone(int age, double height) {
		System.out.println("제 나이는 " + age + "세 입니다.");
		System.out.println("저의 키는 " + height + "cm 입니다");
	}
	
	public static void byEveryone() {
		System.out.println("다음에 뵙겠습니다.");
	}
	*/
}
