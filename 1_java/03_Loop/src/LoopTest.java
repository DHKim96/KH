
public class LoopTest {
	public static void main(String[] args) {
		for (int i = 1; i < 5; i++) {
			System.out.println("반복문 실행 : " + i);
		}
		System.out.println("반복문 종료");
	
		for (int i = 1; i < 5; ++i) {
			System.out.println("반복문 실행 : " + i);
		}
		System.out.println("반복문 종료");
	}

}
