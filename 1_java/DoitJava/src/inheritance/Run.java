package inheritance;

public class Run {

	public static void main(String[] args) {
		Customer lee = new Customer();
		lee.setCustomerID(10010);
		lee.setCustomerName("이순신");
		lee.setBonusPoint(1000);
		lee.calcPoint(5000);
		System.out.println(lee.showCustomerInfo());
	
		
		
		VIPCustomer kim = new VIPCustomer();
		kim.setCustomerID(10020);
		kim.setCustomerName("김유신");
		kim.setBonusPoint(1000);
		kim.calcPoint(5000);

		System.out.println(kim.showCustomerInfo());
	}

}
