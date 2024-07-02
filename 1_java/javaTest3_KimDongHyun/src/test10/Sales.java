package test10;

public class Sales extends Employee implements Bonus{
	public Sales() {
		
	}
	
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	
	public double tax() {
		return super.getSalary() * 0.13 ;
	}
	
	public void incentive(int pay) {
		super.setSalary( super.getSalary() + (int)( pay * 1.2 ) );
	}
}
