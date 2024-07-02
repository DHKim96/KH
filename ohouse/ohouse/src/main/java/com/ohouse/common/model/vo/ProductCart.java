package com.ohouse.common.model.vo;

public class ProductCart {
	private String cartProductId;
	private String cartMembersNo;
	private String cartAmount;
	
	public ProductCart() {}

	public ProductCart(String cartProductId, String cartMembersNo, String cartAmount) {
		super();
		this.cartProductId = cartProductId;
		this.cartMembersNo = cartMembersNo;
		this.cartAmount = cartAmount;
	}

	public String getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(String cartProductId) {
		this.cartProductId = cartProductId;
	}

	public String getCartMembersNo() {
		return cartMembersNo;
	}

	public void setCartMembersNo(String cartMembersNo) {
		this.cartMembersNo = cartMembersNo;
	}

	public String getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(String cartAmount) {
		this.cartAmount = cartAmount;
	}

	@Override
	public String toString() {
		return "ProductCart [cartProductId=" + cartProductId + ", cartMembersNo=" + cartMembersNo + ", cartAmount="
				+ cartAmount + "]";
	}
}
