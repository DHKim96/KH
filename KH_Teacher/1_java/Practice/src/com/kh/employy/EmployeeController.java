package com.kh.employy;

/*
 * 실제 정보를 넘겨받아서 사원에대한 정보를 저장하거나
 * 반환해주는 역할
 */
public class EmployeeController {
	private Employee[] emList = new Employee[100];
	
	public EmployeeController() {
		System.out.println("생성");
		this.emList[0] = new Employee(1, "최지원", 'm', "010-2222-1111", "부서없음", 0, 0.0);
		this.emList[1] = new Employee(2, "김개똥", 'f', "010-2222-1111", "개발팀", 35000000, 0.3);
		this.emList[2] = new Employee(3, "김소망", 'm', "010-4444-2222", "경영지원", 40000000, 0.2);
	}
	//insert => 사원을 배열에 추가해주는 메소드
	public void insert(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		for (int i = 0; i < emList.length; i++) {
			if (emList[i] == null) {
				emList[i] = new Employee(empNo, name, gender, phone, dept, salary, bonus);
				break;
			}
		}
	}
	
	public void printEmpList() {
		
		System.out.println("==============사원 목록==========");
		
		for (int i = 0; i < emList.length; i++) {
			if(emList[i] == null) {
				break;
			}
			System.out.println(emList[i].toString());
		}
	}
	
	// empList에서 맨 마지막에 추가된 회원 삭제
	public void deleteEmp() {
		if (emList[0] == null) {
			System.out.println("삭제할 사원이 없습니다.");
			return;
		}
		
		for(int i = 0; i < emList.length; i++) {
			if (emList[i] == null) { // i번째 인덱스가 비어있다면
				System.out.println("삭제된 사원 정보 : " + emList[i - 1].toString());
				emList[i - 1] = null; // 바로전 인덱스값을 지워줘라
				break;
			} else if(i == (emList.length - 1)) { // 마지막까지 가득차있다면
				System.out.println("삭제된 사원 정보 : " + emList[i].toString());
				emList[i] = null; //마지막 값을 지워줘라
		 	}
		}
	
	}
	
	//empNo에 해당하는 근로자 삭제
	public void deleteEmpByEmpNo(int empNo) {
		for (int i = 0; i < emList.length; i++) {
			if(emList[i] == null) {
				System.out.println(empNo + "번 근로자를 찾을 수 없습니다");
				break;
			} else if(emList[i].getEmpNo() == empNo) { //근로자목록에서 empNo가 일치하는 근로자를 찾음
				emList[i] = null;
				for(int j = i; j < emList.length; j++) {
					if (j+1 == emList.length) {
						emList[j] = null;
						break;
					}
					emList[j] = emList[j+1];
				}
				
				System.out.println(empNo + "번 근로자를 삭제하였습니다.");
				break;
			}
		}
	}
	
	public void printEmpByNo(int empNo) {
		
		for (Employee e : emList) {
			if (e == null) {
				break;
			}else if (e.getEmpNo() == empNo) {
				System.out.println(e.toString());
				break;
			}
		}
	}
}
