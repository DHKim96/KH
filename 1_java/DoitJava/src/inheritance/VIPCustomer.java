package inheritance;

public class VIPCustomer extends Customer {
	private int agentID;
	double salePoint;
	
	public VIPCustomer() {
		super.setCustomerGrade("VIP");
		super.setBonusRatio(0.05);
		this.salePoint = 0.1;
	}
	
	public int calcPrice(int price) {
		super.bonusPoint += price * super.bonusRatio ;
		return price - (int)(price * salePoint);
	}
	
	public int getAgentID() {
		return agentID;
	}
	
	public String showCustomerInfo() {
		return super.getCustomerName() + "님의 등급은 " + super.getCustomerGrade() + "이며, 보너스 포인트는 " + super.getBonusPoint() + "입니다.";
	}
	
}
