package com.ohouse.common.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.community.model.vo.Board;
import com.ohouse.product.model.vo.Product;

public class CommonDao {

	public ArrayList<Product> searchProductList(SqlSession sqlSession, String keyword) {
		return (ArrayList)(sqlSession.selectList("commonMapper.searchProductList", keyword));
	}

	public ArrayList<Board> searchBoardList(SqlSession sqlSession, String keyword) {
		return (ArrayList)(sqlSession.selectList("commonMapper.searchBoardList", keyword));
	}

	public int searchProductListCount(SqlSession sqlSession, String keyword) {
		return sqlSession.selectOne("commonMapper.searchProductListCount", keyword);
	}
	
	public int searchBoardListCount(SqlSession sqlSession, String keyword) {
		return sqlSession.selectOne("commonMapper.searchBoardListCount", keyword);
	}
}
