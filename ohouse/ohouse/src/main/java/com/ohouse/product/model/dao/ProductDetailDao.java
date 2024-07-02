package com.ohouse.product.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.product.model.vo.OptionsCategory;
import com.ohouse.product.model.vo.OptionsName;
import com.ohouse.product.model.vo.Product;

public class ProductDetailDao {

	public Product selectProduct(SqlSession sqlSession, int productId) {
		return sqlSession.selectOne("orderMapper.selectDetailProduct", productId);
	}

	public ArrayList<OptionsCategory> selectCategoryList(SqlSession sqlSession, int productId) {
		return (ArrayList)sqlSession.selectList("orderMapper.selectCategoryList", productId);
	}

	public ArrayList<OptionsName> selectOptionNameList(SqlSession sqlSession, int cgNo) {
		return (ArrayList)sqlSession.selectList("orderMapper.selectOptionsNameList", cgNo);
	}

}
