package com.kh.override;
import java.util.Scanner;
public class PointMenu {
	private Scanner sc = new Scanner(System.in);
	private CircleController cc = new CircleController();
	private RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		while(true) {
			int select;
			System.out.println("===== 메뉴 =====");
			System.out.println("1. 원");
			System.out.println("2. 사각형");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1 : this.circleMenu();
				break;
			case 2 : this.rectangleMenu();
				break;
			case 9 : System.out.println("종료합니다");
				return;
			default : System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				
			}
	
		}
	}
	
	public void circleMenu() {
		while(true) {
			int select;
			System.out.println("===== 원 메뉴 =====");
			System.out.println("1. 원 둘레");
			System.out.println("2. 원 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1 : this.calcCircum();
				break;
			case 2 : this.calcCircleArea();
				break;
			case 9 :
				System.out.println("메인으로 돌아갑니다");
				return;
				// this.mainMenu() 로 하면 이미 mainMenu() 메서드를 통해서 circleMenu()로 들어온 것이기 때문에
				// 해당 메서드가 종료된 것이 아니므로 함수가 축적됨. 따라서 return 을 통해 원래 위치인 mainMenu() 메서드로 가는 것
			default :  
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				return;
				
			}
		}
	}
	
	public void rectangleMenu() {
		while(true) {
			int select;
			System.out.println("===== 사각형 메뉴 =====");
			System.out.println("1. 사각형 둘레");
			System.out.println("2. 사각형 넓이");
			System.out.println("9. 메인으로");
			System.out.print("메뉴 번호 : ");
			select = sc.nextInt();
			sc.nextLine();
			
			switch(select) {
			case 1 : this.calcPerimeter();
				break;
			case 2 : this.calcRectangleArea();
				break;
			case 9 : this.mainMenu();
				return;
			}
		}
	}
	
	public void calcCircum() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		sc.nextLine();
		
		System.out.println(cc.calcCircum(x, y, radius));
	}
	
	public void calcCircleArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("반지름 : ");
		int radius = sc.nextInt();
		
		System.out.println(cc.calcArea(x, y, radius));
	}
	
	public void calcPerimeter() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int height = sc.nextInt();
		System.out.print("너비 : ");
		int width = sc.nextInt();
		
		System.out.println(rc.calcPerimeter(x, y, height, width));
	}
	
	public void calcRectangleArea() {
		System.out.print("x 좌표 : ");
		int x = sc.nextInt();
		System.out.print("y 좌표 : ");
		int y = sc.nextInt();
		System.out.print("높이 : ");
		int height = sc.nextInt();
		System.out.print("너비 : ");
		int width = sc.nextInt();
		
		System.out.println(rc.calcArea(x, y, height, width));
	}
	
	
	
}
