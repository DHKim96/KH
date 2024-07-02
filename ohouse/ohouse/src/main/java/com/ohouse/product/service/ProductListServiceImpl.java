package com.ohouse.product.service;

import static com.ohouse.common.template.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.common.model.vo.Scrap;
import com.ohouse.common.template.PageInfo;
import com.ohouse.product.model.dao.ProductListDao;
import com.ohouse.product.model.vo.Product;

public class ProductListServiceImpl implements ProductListService{
	
	private ProductListDao pDao = new ProductListDao();
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = getSqlSession();
		
		int listCount = pDao.selectListCount(sqlSession);
		
		sqlSession.close();
		return listCount;
	}
	
	@Override
	public ArrayList<Product> selectListProduct(PageInfo pi) {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Product> pList = pDao.selectListProduct(sqlSession, pi);
		
		for(Product p : pList) {
			if(p.getSale() > 0) {
				int price = Integer.parseInt(p.getProductPrice());
				price = price - ((price/100) * p.getSale());
				p.setProductPrice(price + "");
			}
		}
		sqlSession.close();
		return pList;
	}

	@Override
	public int selectProductListCount(String condition) {
		SqlSession sqlSession = getSqlSession();
		
		int saleListCount = pDao.selectProductListCount(sqlSession, condition);
		
		sqlSession.close();
		return saleListCount;
	}

	@Override
	public ArrayList<Product> selectProductSaleList(PageInfo pi, String condition) {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Product> psList = pDao.selectProductSaleList(sqlSession, pi, condition);
		
		for(Product ps : psList) {
			if(ps.getSale() > 0) {
				int price = Integer.parseInt(ps.getProductPrice());
				price = price - ((price/100) * ps.getSale());
				ps.setProductPrice(price + "");
			}
		}
		sqlSession.close();
		return psList;
	}

	@Override
	public int productScrapInsert(Scrap scrap) {
		SqlSession sqlSession = getSqlSession();
		
		int result = pDao.productScrapInsert(sqlSession, scrap);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}		
		
		sqlSession.close();
		return result;
	}

	@Override
	public int productScrapstatusCheck(Scrap scrap) {
		SqlSession sqlSession = getSqlSession();
		
		int result = pDao.productScrapstatusCheck(sqlSession, scrap);
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public int productScrapUpdate(Scrap scrap) {
		SqlSession sqlSession = getSqlSession();
		
		int result = pDao.productScrapUpdate(sqlSession, scrap);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}		
		
		
		
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Product> selectProductSaleList() {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Product> psList = pDao.selectProductSaleList(sqlSession);
		
		for(Product ps : psList) {
			if(ps.getSale() > 0) {
				int price = Integer.parseInt(ps.getProductPrice());
				price = price - ((price/100) * ps.getSale());
				ps.setProductPrice(price + "");
			}
		}
		
		sqlSession.close();
		return psList;
	}

	@Override
	public ArrayList<Product> selectListProduct() {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Product> pList = pDao.selectListProduct(sqlSession);
		
		for(Product ps : pList) {
			if(ps.getSale() > 0) {
				int price = Integer.parseInt(ps.getProductPrice());
				price = price - ((price/100) * ps.getSale());
				ps.setProductPrice(price + "");
			}
		}
		
		sqlSession.close();
		return pList;
	}

	@Override
	public ArrayList<Product> selectProductCategoryList(PageInfo pi, int cNo) {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Product> cList = pDao.selectProductCategoryList(sqlSession,pi, cNo);
		
		for(Product pc : cList) {
			if(pc.getSale() > 0) {
				int price = Integer.parseInt(pc.getProductPrice());
				price = price - ((price/100) * pc.getSale());
				pc.setProductPrice(price + "");
			}
		}
		
		sqlSession.close();
		return cList;
	}


}
