package com.kh.Test240202.test10;

public class Company {

	public static void main(String[] args) {
		  Employee[] employees = new Employee[2];   
	      // 1번의 사용 데이터를 기반으로 객체를 생성하여 배열에 넣는다 .
		  employees[0] = new Secretary("Hilery", 1, "secretary", 800);
		  employees[1] = new Sales("Clinten", 2, "sales", 1200);
		  
		  // 모든 객체의 기본 정보를 출력한다 (for 문을 이용하여 출력한다.) 
		  System.out.printf("%-10s %-10s %-10s\n", "name", "department", "salary");
		  System.out.println("------------------------------------");
		  for(int i = 0; i < employees.length; i++) {
			  Employee e = employees[i];
			  System.out.printf("%-10s %-10s %-10d\n", e.getName(), e.getDepartment(), e.getSalary());
		  }
		  
	      // 모든 객체에 인센티브 100 씩 지급한 급여를 계산하고 다시 객체의 salary에 넣는다 .
		  System.out.println("\n인센티브 100지급\n");
		  for(Employee e : employees) {
			  if (e instanceof Secretary) {
				  ((Secretary)e).incentive(100);
			  } else if(e instanceof Sales) {
				  ((Sales)e).incentive(100);
			  }
		  }
		  
	      // 모든 객체의 정보와 세금을 출력한다 (for 문을 이용하여 출력한다.)
		  System.out.printf("%-10s %-10s %-10s %-10s\n", "name", "department", "salary", "tax");
		  System.out.println("----------------------------------------------");
		  for(int i = 0; i < employees.length; i++) {
			  Employee e = employees[i];
			  System.out.printf("%-10s %-10s %-10d %-10.1f\n", e.getName(), e.getDepartment(), e.getSalary(), e.tax());
		  }
		  
	}

}
