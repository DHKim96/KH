package com.ohouse.product.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.product.model.vo.OptionsCategory;
import com.ohouse.product.model.vo.OptionsName;
import com.ohouse.product.model.vo.Order;
import com.ohouse.product.model.vo.OrderProduct;
import com.ohouse.product.model.vo.Product;

public class ProductOrderDao {

	public Product selectProduct(SqlSession sqlSession, int productId) {
		return sqlSession.selectOne("orderMapper.selectDetailProduct", productId);
	}

	public OptionsCategory selectCategory(SqlSession sqlSession, int cgNo) {
		return sqlSession.selectOne("orderMapper.selectCategory", cgNo);
	}

	public OptionsName selectOptNameDetail(SqlSession sqlSession, int optNameNo) {
		return sqlSession.selectOne("orderMapper.selectOptionsName", optNameNo);
	}

	public int insertOrder(SqlSession sqlSession, Order o) {
		int result = sqlSession.insert("orderMapper.insertOrder", o);
		return  result;
	}

	public int insertOrderProduct(SqlSession sqlSession, OrderProduct ordpd) {
		int result = sqlSession.insert("orderMapper.insertOrderProduct", ordpd);
		return result;
	}

	public Order selectOrder(SqlSession sqlSession, int orderId) {
		return sqlSession.selectOne("orderMapper.selectOrder", orderId);
	}

	public OrderProduct selectOrderProduct(SqlSession sqlSession, OrderProduct orderProduct) {
		return sqlSession.selectOne("orderMapper.selectOrderProduct", orderProduct);

	}

}
