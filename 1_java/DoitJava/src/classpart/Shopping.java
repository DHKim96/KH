package classpart;

public class Shopping {
	long orderNum;
	String userID;
	String orderDate;
	String userName;
	String productNum;
	String address;
	
	public Shopping(long orderNum, String userID, String orderDate, String userName, String productNum, String address) {
		this.orderNum = orderNum;
		this.userID = userID;
		this.orderDate = orderDate;
		this.userName = userName;
		this.productNum = productNum;
		this.address = address;
	}
	
	public void userInfo() {
		System.out.println("주문 번호 " + this.orderNum + "을 주문한 고객님의 ID는 " + this.userID + "입니다." );
	}
}
