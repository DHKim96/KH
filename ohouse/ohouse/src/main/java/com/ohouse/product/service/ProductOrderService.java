package com.ohouse.product.service;

import com.ohouse.product.model.vo.OptionsCategory;
import com.ohouse.product.model.vo.OptionsName;
import com.ohouse.product.model.vo.Order;
import com.ohouse.product.model.vo.OrderProduct;
import com.ohouse.product.model.vo.Product;

public interface ProductOrderService {
	// 상품 객체 반환
	Product selectProductDetail(int pNo);
	// 상품의 카테고리 객체 반환
	OptionsCategory selectCategoryDetail(int cgNo);
	// 상품의 옵션명 객체 반환
	OptionsName selectOptNameDetail(int optNameNo);
	// 주문 객체 DB에 저장
	int insertOrder(Order o);
	//상품 옵션 db에 저장
	int insertOrderProduct(OrderProduct ordpd);
	// 주문 객체 반환
	Order selectOrder(int orderId);
	// 주문 상품 옵션 반환
	OrderProduct selectOrderProduct(OrderProduct ordpd);
}
