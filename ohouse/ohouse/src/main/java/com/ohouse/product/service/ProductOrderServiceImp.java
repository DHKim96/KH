package com.ohouse.product.service;

import static com.ohouse.common.template.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.product.model.dao.ProductOrderDao;
import com.ohouse.product.model.vo.OptionsCategory;
import com.ohouse.product.model.vo.OptionsName;
import com.ohouse.product.model.vo.Order;
import com.ohouse.product.model.vo.OrderProduct;
import com.ohouse.product.model.vo.Product;

public class ProductOrderServiceImp implements ProductOrderService {

	private ProductOrderDao pDao = new ProductOrderDao(); 
	
	@Override
	public Product selectProductDetail(int pNo) {
		SqlSession sqlSession = getSqlSession();
		
		Product p = pDao.selectProduct(sqlSession, pNo);
		
		sqlSession.close();
		
		return p;
	}

	@Override
	public OptionsCategory selectCategoryDetail(int cgNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		OptionsCategory cg = pDao.selectCategory(sqlSession, cgNo);
		
		sqlSession.close();
		
		return cg;
	}

	@Override
	public OptionsName selectOptNameDetail(int optNameNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		OptionsName optName = pDao.selectOptNameDetail(sqlSession, optNameNo);
		
		sqlSession.close();
		
		return optName;
	}

	@Override
	public int insertOrder(Order o) {
		SqlSession sqlSession = getSqlSession();
		
		int result = pDao.insertOrder(sqlSession, o);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public int insertOrderProduct(OrderProduct ordpd) {
		SqlSession sqlSession = getSqlSession();

		int result = pDao.insertOrderProduct(sqlSession,ordpd);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public Order selectOrder(int orderId) {
		SqlSession sqlSession = getSqlSession();
		
		Order o = pDao.selectOrder(sqlSession, orderId);
		
		sqlSession.close();
		
		return o;
	}

	@Override
	public OrderProduct selectOrderProduct(OrderProduct orderProduct) {
		SqlSession sqlSession = getSqlSession();
		
		OrderProduct ordpd = pDao.selectOrderProduct(sqlSession, orderProduct);
		
		sqlSession.close();
		
		return ordpd;
	}

}
