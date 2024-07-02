import java.util.Scanner;

public class StarMenu {


	private Scanner sc = new Scanner(System.in);

	
	//MemberController 객체 생성(전역에서 바로 요청할 수 있도록)
	private StarController stc = new StarController();
	


	public void mainMenu() {
		while(true) {
			System.out.println("============= 스타벅스 메뉴 관리 프로그램 =============");
			System.out.println("1. 상품 추가");
			System.out.println("2. 상품 조회");
			System.out.println("3. 상품 정보 수정");
			System.out.println("4. 상품 삭제");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.inputStarbucks();
			case 2:
				stc.selectList(); // 회원정보 Controller 에 요청
				break;
			case 3:
				// 회원 정보 수정
				// 수정할 회원 식별 위한 userId
				// pwd, email, phone, address
				this.updateStarbucks();
				break;
			case 4:
				// 회원 탈퇴
				// 탈퇴할 회원 식별 위한 userId
				stc.deleteStarbucks();
				break;
			case 5:	
			case 6:
			case 0:
				System.out.println("이용해주셔서 감사합니다. 프로그램을 종료합니다.");
				return;
			default: 
				System.out.println("메뉴를 잘못입력하셨습니다. 다시 입력해주세요");
			}
		}
	}
	
	private void updateStarbucks() {
		// TODO Auto-generated method stub
		
	}

	public void inputStarbucks() {
		System.out.println("================== 상품 추가 =======================");
		System.out.print("추가할 상품의 종류를 입력해주세요(음료/푸드) : ");
		String type = sc.nextLine();
		if(type.equals("음료")) {
			System.out.print("음료 종류 : ");
			System.out.print("음료명 : ");
			System.out.print("음료 가격 : ");
		}
		else if(type.equals("푸드")) {
			System.out.println("푸드 종류: ");
			System.out.println("푸드명: ");
			System.out.println("푸드 가격 : ");

		}
	}
	
	public void logoMenu() {
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⡤⡦⣲⢖⣧⢳⣺⣲⡲⡴⣤⡠⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⣔⢾⢝⡾⣝⡽⡵⠻⠪⠀⠺⢪⠾⣝⣞⣞⢽⣳⣢⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡰⡮⣻⡺⡽⣝⢞⢵⢯⣺⢄⠀⠀⠀⣠⢾⢕⡷⢝⣵⣳⣳⡫⣗⣆⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢞⣞⡽⣵⡫⡯⢞⡥⠀⠈⠚⠅⢠⢤⣀⠨⠋⠁⠀⣔⠷⢕⣗⡽⡵⣳⡳⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠫⡯⣞⣞⡵⣫⢶⡀⠈⠀⠀⠀⡀⣁⣀⣀⡀⠀⠀⠀⠁⢀⣞⢮⢾⢽⢵⡫⠗⡧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣺⠀⠈⣞⡞⣞⠽⡵⣳⢤⢲⡓⡽⠉⠈⠀⠁⠙⢽⠱⡲⡤⣳⢽⢝⢵⢯⡳⠁⠀⣟⣖⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⡺⡊⠀⠀⠀⠀⠀⣠⡞⡕⢍⠎⡸⠔⡢⣆⠀⣔⢔⠢⡧⠱⡍⡎⣗⣄⠀⠀⠈⠀⠀⠸⣺⢥⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠎⠀⠀⡀⡀⡠⣞⣗⢡⡃⢼⠀⢯⠙⠊⠊⠀⠎⠓⠙⡵⠀⡇⠸⡐⣗⣗⡄⡀⡀⡀⠀⠩⡳⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⢰⢥⢤⠖⠋⠙⡹⣝⣞⢮⠰⡅⠸⡄⠸⡀⠀⢐⢒⢀⠀⢀⠇⢰⡃⢸⠂⣺⣪⢾⣙⠙⠪⠲⡤⣌⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⢁⣄⡖⣖⡽⣺⢮⢯⡂⢵⡀⢯⡀⠳⣄⠈⠉⠁⣠⢎⢀⠷⢀⡏⢠⣗⣗⢯⣞⢖⡴⣠⡀⠁⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠸⠙⠃⢁⣀⡼⣝⢾⢵⣫⠆⢸⠂⣜⠆⢨⡓⠛⠊⠋⢳⢅⠨⣇⠐⣇⠸⣺⣪⢗⣗⢧⣀⡁⠙⠹⠅⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⡦⡮⠓⠃⣟⣞⡽⡵⠃⡴⠃⣔⠃⡠⡞⠀⠀⠀⠀⠀⠳⡄⠘⢆⡈⢦⠑⢽⣝⢮⣻⠘⠚⢖⡦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⡲⡳⣳⡳⡽⡂⣺⠀⢮⠃⢰⡍⠀⠀⠀⠀⠀⠀⠀⢹⡂⠘⣖⠈⢧⠈⡾⣝⣞⠮⣖⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠃⣁⢴⡘⠊⠁⠀⠸⡄⠪⣇⠀⢗⡀⠀⠀⠀⠀⠀⢀⡞⠄⣸⠊⢰⠃⠀⠈⠘⢒⣤⣀⠑⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⡠⡯⠃⡼⠁⣰⠓⠀⣼⠁⠀⠀⠀⠑⡧⠀⢱⣅⠈⢧⡈⢗⡅⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠀⠳⠁⠀⠀⠀⠀⠀⠐⠝⠀⠈⠈⠀⠀⠂⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		System.out.println("");
		System.out.print("⠀⠀⣤⡦⣦⠄⢠⣴⣤⣤⣦⠀⠀⣤⣴⡄⠀⠀⣤⣦⡴⣤⡀⠀⣴⣤⢦⣤⡄⠀⣴⡤⠀⣴⣤⠀⢀⣤⡦⣦⡄⢀⣦⡆⣠⣦⠂⢀⣴⢴⣤⠄⠠⠠⠀\r\n"
				+ "");
		System.out.print("⠀⠘⢿⢶⣦⡁⠀⠈⣾⡇⠀⠀⣼⡿⢸⣷⡀⠀⣺⣗⣬⣻⠇⠀⣾⣻⣤⣿⡃⠀⣯⣟⠀⣾⣻⠀⣾⢷⠁⠈⠀⠠⣿⣳⣿⠂⠀⠸⢿⡶⣤⡁⠀⠁⠀\r\n"
				+ "");
		System.out.print("⠀⠰⢦⣵⣻⠝⠀⠀⡿⣇⠀⢰⢿⠝⠛⢽⣖⠀⢽⢯⠘⣿⡄⠀⢾⢿⢤⡷⠟⠀⠹⢿⣴⢯⠏⠀⠙⢿⣦⡶⡆⠐⡿⡇⢻⣧⡀⢰⢦⣮⢿⠃⠀⠀⠀\r\n"
				+ "");
		System.out.print("");
		System.out.print("");
	}
}
