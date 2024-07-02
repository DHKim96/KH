
public class A_Method {
//	public static void main(String[] args) {
//		System.out.println("프로그램 시작");
//		hiEveryOne(12);
//		hiEveryOne(13);
//		System.out.println("프로그램 끝");
//	}
//	public static void hiEveryOne(int age) {
//		System.out.println("좋은 아침입니다");
//		System.out.println("제 나이는 " + age + "세 입니다.");
//	}
	
//	public static void main(String[] args) {
//		double myHeight = 175.9;
//		hiEveryOne(12, 12.5);
//		hiEveryOne(13, myHeight);
//		byEveryOne();
//	}
//	
//	public static void hiEveryOne(int age, double height) {
//		System.out.println("제 나이는 " + age + "세 입니다.");
//		System.out.println("저의 키는 " + height + "cm 입니다.");
//	}
//	public static void byEveryOne() {
//		System.out.println("다음에 뵙겠습니다.");
//	}
	public static void main(String[] args) {
		int result;
		result = adder(4, 5);
		System.out.println("4 + 5 = " + result);
		System.out.println("3.5 x 3.5 = " + square(3.5));

	}
	
	public static int adder(int num1, int num2) {
		int addResult = num1 + num2;
		return addResult;
	}
	
	public static double square(double num) {
		return num * num;
	}
}
