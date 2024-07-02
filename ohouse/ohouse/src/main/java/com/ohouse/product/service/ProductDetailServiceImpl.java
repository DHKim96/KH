package com.ohouse.product.service;

import static com.ohouse.common.template.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.product.model.dao.ProductDetailDao;
import com.ohouse.product.model.vo.OptionsCategory;
import com.ohouse.product.model.vo.OptionsName;
import com.ohouse.product.model.vo.Product;

public class ProductDetailServiceImpl implements ProductDetailService {
    private ProductDetailDao productDetailDao = new ProductDetailDao();
    
	@Override
	public Product selectProduct(int productId) {
		SqlSession sqlSession = getSqlSession();
        Product p = productDetailDao.selectProduct(sqlSession, productId);
        
        sqlSession.close();
        return p;
	}

	@Override
	public ArrayList<OptionsCategory> selectCategoryList(int productId) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<OptionsCategory> list = productDetailDao.selectCategoryList(sqlSession, productId);
		
		sqlSession.close();
		return list;
	}

	@Override
	public ArrayList<OptionsName> selectOptionsNameList(int cgNo) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<OptionsName> list = productDetailDao.selectOptionNameList(sqlSession, cgNo);
		
		sqlSession.close();
		return list;
	}
}
