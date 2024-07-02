import java.util.Scanner;

public class Array07 {
	public static void main(String[] args) {
		/*
		  	사용자가 입력한 값이 배열에 있는지 검색하여
			있으면 “OOO 치킨 배달 가능“, 없으면 “OOO 치킨은 없는 메뉴입니다“를 출력하세요.
			단, 치킨 메뉴가 들어가있는 배열은 본인 스스로 정하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		boolean isTrue = false; // 거짓
		
		String[] menu = {"후라이드", "양념", "간장", "반반", "핫후라이드", "슈프림양념"}; // 치킨종류가 들어있는 메뉴배열 생성
		
		System.out.print("치킨 이름을 입력하세요 : ");
		String pick = sc.next(); // 사용자로부터 치킨입력받음 => 양념
		
		for (int i = 0; i < menu.length; i++) { // 0 1 2 3 4 5
			if (menu[i].equals(pick)) { // 사용자가 입력한 값을 메뉴에서 발견
				System.out.println(pick + "치킨 배달 가능");
				return;
			} 
		}
		
		
		System.out.println(pick + "치킨은 없는 메뉴입니다.");
		
//		if (isTrue) { //사용자가 입력한 값을 메뉴에서 발견 했을 때
//			System.out.println(pick + "치킨 배달 가능");
//		} else { // 그게아니면
//			System.out.println(pick + "치킨은 없는 메뉴입니다.");
//		}
		
		
	}
}
