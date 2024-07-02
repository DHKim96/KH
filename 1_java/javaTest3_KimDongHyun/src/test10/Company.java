package test10;

public class Company {

	public static void main(String[] args) {
		Employee[] employees = new Employee[2];
		{
			employees[0] = new Secretary("Hilery", 1, "secretary", 800); //다형성
			employees[1] = new Sales("Clinten", 2, "sales", 1200);
		}
		
		System.out.println("name\tdepartment\tsalary");
		System.out.println("-----------------------------");
		
		for (Employee emr : employees) {
			System.out.println(emr.getName() + "\t" + emr.getDepartment() + "\t" + emr.getSalary());
		}
		
		System.out.println("\n 인센티브 100 지급 \n");
		
		System.out.println("name\tdepartment\tsalary\ttax");
		System.out.println("----------------------------------");
		((Secretary)employees[0]).incentive(100);
		((Sales)employees[1]).incentive(100);
		for (Employee emr : employees) {
			System.out.print(emr.getName() + "\t" + emr.getDepartment() + "\t" + emr.getSalary());
			if(emr instanceof Secretary) {
				System.out.println( "\t" + ( (Secretary)emr ).tax() );
			}else if(emr instanceof Sales) {
				System.out.println( "\t" + "   " + ( (Sales)emr ).tax() );
			}
		}
		
		
		
	}

}
