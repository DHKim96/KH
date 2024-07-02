package com.ohouse.common.service;

import static com.ohouse.common.template.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.common.model.dao.CommonDao;
import com.ohouse.community.model.vo.Board;
import com.ohouse.product.model.vo.Product;

public class CommonServiceImpl implements CommonService {
	private CommonDao cDao = new CommonDao();
	
	@Override
	public ArrayList<Product> searchProductList(String keyword) {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Product> products = cDao.searchProductList(sqlSession, keyword);
		
		sqlSession.close();
		
		return products;
	}

	@Override
	public ArrayList<Board> searchBoardList(String keyword) {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> boards = cDao.searchBoardList(sqlSession, keyword);
		
		sqlSession.close();
		
		return boards;
	}

	@Override
	public int searchProductListCount(String keyword) {
		SqlSession sqlSession = getSqlSession();
		
		int productListCount = cDao.searchProductListCount(sqlSession, keyword);
		
		sqlSession.close();
		
		return productListCount;
	}

	@Override
	public int searchBoardListCount(String keyword) {
		SqlSession sqlSession = getSqlSession();
		
		int boardListCount = cDao.searchBoardListCount(sqlSession, keyword);
		
		sqlSession.close();
		
		return boardListCount;
	}
	
	
}
