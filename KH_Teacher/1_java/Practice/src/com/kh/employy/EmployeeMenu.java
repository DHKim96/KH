package com.kh.employy;

import java.util.Scanner;

/*
 * 화면에 출력하는 것과
 * 사용자로부터 입력받는 것을 처리해주는 객체
 */
public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec; // Employee접근하기위한 객체
	
	public EmployeeMenu() {
		this.ec = new EmployeeController();
	}
	//메인화면을 출력하는 메소드
	public void EmployeeMainMenu() {
		/*
		 * 1. 사원추가
		 * 9. 프로그램 종료
		 * 메뉴 번호를 누르세요 : 
		 * (정수하나입력받기)
		 */
		int number;
		
		while(true) {
			System.out.println("1. 사원추가");
			System.out.println("2. 사원전체출력");
			System.out.println("3. 사원삭제");
			System.out.println("4. 사원검색출력");
			System.out.println("9. 프로그램종료");
			System.out.print("메뉴 번호를 누르세요 : ");
			number = sc.nextInt();
			
			switch(number) {
			case 1:
				/*
				 * 사원추가기능
				 * 사원번호, 이름, 성별, 휴대폰번호입력받고
				 * 추가 정보를 더 입력하시겠습니까?(y/n)
				 * y일때만 부서, 연봉, 보너스율 입력받고
				 * 해당 데이터를 활용하여 emList에 사원추가
				 */
				this.insertEmp();
				break;
			case 2:
				ec.printEmpList();
				break;
			case 3:
				/*
				 * 전체 사원을 출력 ->
				 * 삭제할 사원의 사원번호를 입력해주세요. : ?
				 * y => 가장 최근에 등록된사원을 삭제하고
				 * 삭제된 사원 정보 출력
				 * n을누르면 그대로 다시 돌아옵니다.
				 */
				
				this.deleteEmp();
				break;
			case 4:
				/*
				 * 정보를 출력할 사원의 사번을 입력하세요 : 
				 * 사원정보 :
				 */
				
				this.printEmpInfoByEmpNo();
				break;
			case 9:
				System.out.println("프로그램을 종룍합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}
	}

	//회원을 추가하기위한 정보를 입력받는 메소드
	public void insertEmp() {
		System.out.print("사원번호 : ");
		int empNo = sc.nextInt();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		//toLowerCase()  -> 모든 문자열 소문자로 변경
		System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : YYY");
		boolean isContinue = sc.next().toLowerCase().charAt(0) == 'y';
		if (isContinue) { // 추가정보를 입력받음(y를 입력했을 때)
			System.out.print("부서 : ");
			String dept = sc.next();
			
			System.out.print("연봉 : ");
			int salary = sc.nextInt();
			
			System.out.print("보너스 율 : ");
			double bonus = sc.nextDouble();
		 
			ec.insert(empNo, name, gender, phone, dept, salary, bonus);
		} else { // 추가정보를 입력받지않음 n을 입력했을 때
			
			ec.insert(empNo, name, gender, phone, "부서없음", 0, 0.0);
		}
	}

	public void deleteEmp() {
//		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
//		char ch = sc.next().toLowerCase().charAt(0);
//		
//		if (ch == 'y') { //삭제하기
//			 ec.deleteEmp();
//		} 
		
		//전체사원출력
		//삭제할 사원의 사원번호를 입력해주세요.
		//deleteEmpByEmpNo
		
		System.out.print("삭제할 사원번호를 입력해주세요 : ");
		int empNo = sc.nextInt();
		
		ec.deleteEmpByEmpNo(empNo);
	}

	public void printEmpInfoByEmpNo() {
		System.out.print("정보를 출력할 사원의 사번을 입력하세요 : ");
		int empNo = sc.nextInt();
		ec.printEmpByNo(empNo);
	}
}
