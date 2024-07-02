package com.ohouse.product.model.vo;

public class OrderProduct {
	 private int orderId;
	 private int productId;
	 private int orderOptions;
	 private int amount;
	 
	 public OrderProduct() {}

	public OrderProduct(int orderId, int productId, int orderOptions, int amount) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.orderOptions = orderOptions;
		this.amount = amount;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderOptions() {
		return orderOptions;
	}

	public void setOrderOptions(int orderOptions) {
		this.orderOptions = orderOptions;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderProduct [orderId=" + orderId + ", productId=" + productId + ", orderOptions=" + orderOptions
				+ ", amount=" + amount + "]";
	}

	 
}
