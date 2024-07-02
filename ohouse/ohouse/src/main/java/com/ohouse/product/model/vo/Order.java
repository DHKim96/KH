package com.ohouse.product.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class Order {
	private int ordersId;
	private int membersNo;
	private String recipientName;
	private	String recipientPhone;
	private String recipientEmail;
	private String recipientAddress;
	private int recipientPostcode;
	private Date ordersDate; // 주문일
	private long totalPrice;
	private Date arrivalDate; // 배송완료일
	private String requirement;
	private String deliveryStatus; // 배송상태
	private String ordersStatus;
	private ArrayList<OrderProduct> orderProducts;
	
	
	public Order() {}


	public Order(int ordersId, int membersNo, String recipientName, String recipientPhone, String recipientEmail,
			String recipientAddress, int recipientPostcode, Date ordersDate, long totalPrice, Date arrivalDate,
			String requirement, String deliveryStatus, String ordersStatus, ArrayList<OrderProduct> orderProducts) {
		super();
		this.ordersId = ordersId;
		this.membersNo = membersNo;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
		this.recipientEmail = recipientEmail;
		this.recipientAddress = recipientAddress;
		this.recipientPostcode = recipientPostcode;
		this.ordersDate = ordersDate;
		this.totalPrice = totalPrice;
		this.arrivalDate = arrivalDate;
		this.requirement = requirement;
		this.deliveryStatus = deliveryStatus;
		this.ordersStatus = ordersStatus;
		this.orderProducts = orderProducts;
	}


	public int getOrdersId() {
		return ordersId;
	}


	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}


	public int getMembersNo() {
		return membersNo;
	}


	public void setMembersNo(int membersNo) {
		this.membersNo = membersNo;
	}


	public String getRecipientName() {
		return recipientName;
	}


	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}


	public String getRecipientPhone() {
		return recipientPhone;
	}


	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}


	public String getRecipientEmail() {
		return recipientEmail;
	}


	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}


	public String getRecipientAddress() {
		return recipientAddress;
	}


	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}


	public int getRecipientPostcode() {
		return recipientPostcode;
	}


	public void setRecipientPostcode(int recipientPostcode) {
		this.recipientPostcode = recipientPostcode;
	}


	public Date getOrdersDate() {
		return ordersDate;
	}


	public void setOrdersDate(Date ordersDate) {
		this.ordersDate = ordersDate;
	}


	public long getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Date getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public String getRequirement() {
		return requirement;
	}


	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}


	public String getDeliveryStatus() {
		return deliveryStatus;
	}


	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}


	public String getOrdersStatus() {
		return ordersStatus;
	}


	public void setOrdersStatus(String ordersStatus) {
		this.ordersStatus = ordersStatus;
	}


	public ArrayList<OrderProduct> getOrderProducts() {
		return orderProducts;
	}


	public void setOrderProducts(ArrayList<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}


	@Override
	public String toString() {
		return "Order [ordersId=" + ordersId + ", membersNo=" + membersNo + ", recipientName=" + recipientName
				+ ", recipientPhone=" + recipientPhone + ", recipientEmail=" + recipientEmail + ", recipientAddress="
				+ recipientAddress + ", recipientPostcode=" + recipientPostcode + ", ordersDate=" + ordersDate
				+ ", totalPrice=" + totalPrice + ", arrivalDate=" + arrivalDate + ", requirement=" + requirement
				+ ", deliveryStatus=" + deliveryStatus + ", ordersStatus=" + ordersStatus + ", orderProducts="
				+ orderProducts + "]";
	}
	
	
}

