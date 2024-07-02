package com.kh.Test2402071;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class FarmMenu {
	private Scanner sc;
	private FarmController fc;
	
	public FarmMenu() {
		sc = new Scanner(System.in);
		fc = new FarmController();
	}
	
	public void mainMenu() {
		System.out.println("========== KH 마트 ==========");
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 직원 메뉴");
			System.out.println("2. 손님 메뉴");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 선택 : ");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {
			case 1 : this.adminMenu();
			System.out.println();
				break;
			case 2 :
				this.customerMenu();
				System.out.println();
				break;
			case 9 : System.out.println("프로그램 종료.");
				return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			System.out.println();
			}
		}
		
	}
	
	public void adminMenu(){
		while(true) {
			System.out.println("******* 직원 메뉴 *******");
			System.out.println("1. 새 농산물 추가");
			System.out.println("2. 종류 삭제");
			System.out.println("3. 수량 수정 ");
			System.out.println("4. 농산물 목록 ");
			System.out.println("9. 메인으로 돌아가기 ");
			System.out.print("메뉴 번호 선택 : ");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {
			case 1 : this.addNewKind();
			System.out.println();
				break;
			case 2 : this.removeKind();
			System.out.println();
				break;
			case 3 : this.changeAmount();
			System.out.println();
				break;
			case 4 : this.printFarm();
			System.out.println();
				break;
			case 9 : System.out.println("메인 메뉴로 돌아갑니다.");
			System.out.println();
				return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			System.out.println();
			}
		}
	}
	
	public void	customerMenu() {
		while(true) {
			System.out.println("******* 고객 메뉴 *******");
			System.out.println("KH마트 농산물 수량 현황");
			this.printFarm();
			System.out.println();
			System.out.println("1. 농산물 구매");
			System.out.println("2. 농산물 빼기");
			System.out.println("3. 구입한 농산물 보기");
			System.out.println("9. 메인으로 돌아가기 ");
			System.out.print("메뉴 번호 선택 : ");
			int select = sc.nextInt();
			sc.nextLine();
			switch(select) {
			case 1 : this.buyFarm();
			System.out.println();
				break;
			case 2 : this.removeFarm();
			System.out.println();
				break;
			case 3 : this.printBuyFarm();
			System.out.println();
				break;
			case 9 : System.out.println("메인 메뉴로 돌아갑니다.");
				System.out.println();
				return;
			default : System.out.println("잘못 입력하였습니다. 다시 입력해주세요");
			System.out.println();
			}
		}
	}

	public void	addNewKind() {
		while(true) {
			System.out.println("******* 새 농산물 추가 *******");
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("추가할 종류 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("수량 : ");
			int num = sc.nextInt();
			sc.nextLine();
			if (select >= 1 && select <= 3) {
				Farm f = null;
				switch(select) {
				case 1 : f = new Fruit("과일", name);
					break;
				case 2 : f = new Vegetable("채소", name);
					break;
				case 3 : f = new Nut("견과", name);
					break;
				}
				if( fc.addNewKind(f, num) ) {
					System.out.println("해당 농산물을 추가하였습니다.");
					System.out.println();
					return;
				}
				else {
					System.out.println("해당 농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
				}
			}
			else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			}
		}
	}

	public void	removeKind() {
		while(true) {
			System.out.println("******* 종류 삭제 *******");
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("삭제할 종류 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			if (select >= 1 && select <= 3) {
				Farm f = null;
				switch(select) {
				case 1 : f = new Fruit("과일", name);
					break;
				case 2 : f = new Vegetable("채소", name);
					break;
				case 3 : f = new Nut("견과", name);
					break;
				}
				if( fc.removeKind(f) ) {
					System.out.println("해당 농산물을 삭제하였습니다.");
					System.out.println();
					return;
				}
				else {
					System.out.println("해당 농산물 삭제에 실패하였습니다. 다시 입력해주세요.");
					System.out.println();
				}
			}
			else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
	}

	public void	changeAmount() {
		while(true) {
			System.out.println("******* 수량 수정 *******");
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("수정할 종류 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("수정할 수량 : ");
			int num = sc.nextInt();
			sc.nextLine();
			if (select >= 1 && select <= 3) {
				Farm f = null;
				switch(select) {
				case 1 : f = new Fruit("과일", name);
					break;
				case 2 : f = new Vegetable("채소", name);
					break;
				case 3 : f = new Nut("견과", name);
					break;
				}
				if( fc.changeAmount(f, num) ) {
					System.out.println("해당 농산물 수량을 수정하였습니다.");
					System.out.println();
					return;
				}
				else {
					System.out.println("해당 농산물 수량 수정에 실패하였습니다. 다시 입력해주세요.");
					System.out.println();
				}
			}
			else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
	}

	public void	printFarm() {
		System.out.println("******* 농산물 목록 *******");
		HashMap<Farm, Integer> result = fc.printFarm();
		if (result.isEmpty()) {
			System.out.println("현재 농산물이 없습니다.");
			System.out.println();
		}
		else {
//			Iterator itKey = result.keySet().iterator();
//			while(itKey.hasNext()) {
//				String key = (String) itKey.next();
//				Integer num = (Integer)result.get(key);
//				String[] arr = key.split(",");
//				System.out.printf("%s : %s(%d)", arr[0], arr[1], num);
			
			
			for (Farm f : result.keySet()) {
				if (f instanceof Fruit) {
					System.out.printf("%s : %s(%d개)\n", f.getKind(), ((Fruit)f).getName(), result.get(f));
				}
				else if (f instanceof Vegetable) {
					System.out.printf("%s : %s(%d개)\n", f.getKind(), ((Vegetable)f).getName(), result.get(f));
				}
				else if (f instanceof Nut){
					System.out.printf("%s : %s(%d개)\n", f.getKind(), ((Nut)f).getName(), result.get(f));
				}
			}
			System.out.println();
		}
	}

	public void	buyFarm() {
		while(true) {
			System.out.println("******* 농산물 구매 *******");
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("구매할 종류 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			System.out.print("구매할 것 : ");
			String name = sc.nextLine();
			if (select >= 1 && select <= 3) {
				Farm f = null;
				switch(select) {
				case 1 : f = new Fruit("과일", name);
					break;
				case 2 : f = new Vegetable("채소", name);
					break;
				case 3 : f = new Nut("견과", name);
					break;
				}
				if( fc.buyFarm(f) ) {
					System.out.println("해당 농산물을 구매하였습니다.");
					System.out.println();
					return;
				}
				else {
					System.out.println("마트에 없는 물건이거나 수량이 없습니다. 다시 입력해주세요.");
					System.out.println();
				}
			}
			else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
	}
	
	public void	removeFarm() {
		while(true) {
			System.out.println("******* 농산물 빼기 *******");
			System.out.println("1. 과일 / 2. 채소 / 3. 견과");
			System.out.print("취소할 종류 번호 : ");
			int select = sc.nextInt();
			sc.nextLine();
			System.out.print("구매 취소할 것 : ");
			String name = sc.nextLine();
			if (select >= 1 && select <= 3) {
				Farm f = null;
				switch(select) {
				case 1 : f = new Fruit("과일", name);
					break;
				case 2 : f = new Vegetable("채소", name);
					break;
				case 3 : f = new Nut("견과", name);
					break;
				}
				if( fc.removeFarm(f) ) {
					System.out.println("해당 농산물의 구매를 취소하였습니다.");
					System.out.println();
					return;
				}
				else {
					System.out.println("구매 목록에 존재하지 않습니다. 다시 입력해주세요.");
					System.out.println();
				}
			}
			else {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
				System.out.println();
			}
		}
	}

	public void	printBuyFarm() {
		System.out.println("******* 구입한 농산물 보기 *******");
		Iterator<Farm> it = fc.printBuyFarm().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
	}
	
}
