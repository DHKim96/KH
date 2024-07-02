package test10;

public class Secretary extends Employee implements Bonus {
	public Secretary() {
		
	}
	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	public double tax() {
		return (super.getSalary() / 10);
	}
	public void incentive(int pay) {
		super.setSalary( super.getSalary() + (int)( pay * 0.8 ) );
	}
}
