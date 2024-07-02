package com.ohouse.product.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ohouse.common.model.vo.Scrap;
import com.ohouse.common.template.PageInfo;
import com.ohouse.product.model.vo.Product;

public class ProductListDao {
	
	public int selectListCount(SqlSession sqlSession) {
			
		return sqlSession.selectOne("productMapper.selectProductListCount");
		
	}
	
	public ArrayList<Product> selectListProduct(SqlSession sqlSession, PageInfo pi){
		
		int offset = (pi.getCurrentPage()-1)* pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("productMapper.selectProductList",null, rowBounds);
	}
	
	public int selectProductListCount(SqlSession sqlSession, String condition) {
		
		return sqlSession.selectOne("productMapper.selectProductListCount", condition);
		
	}
	
	public ArrayList<Product> selectProductSaleList(SqlSession sqlSession, PageInfo pi, String condition){
		
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		
		return (ArrayList)sqlSession.selectList("productMapper.selectProductSaleList", condition, rowBounds);
	}
	
	public int productScrapInsert(SqlSession sqlSession, Scrap scrap){
		
		return sqlSession.insert("productMapper.insertProductScrap", scrap);
					
	}
	
	public int productScrapstatusCheck(SqlSession sqlSession, Scrap scrap) {
		
		
		return sqlSession.selectOne("productMapper.productScrapstatusCheck", scrap);
	}
	
	public int productScrapUpdate(SqlSession sqlSession, Scrap scrap ) {
		
		return sqlSession.update("productMapper.productScrapUpdate", scrap);
	}
	
	public ArrayList<Product> selectProductSaleList(SqlSession sqlSession){
		return (ArrayList)sqlSession.selectList("productMapper.selectProductSaleList");
	}
	
	public ArrayList<Product> selectListProduct(SqlSession sqlSession){
		return (ArrayList)sqlSession.selectList("productMapper.selectProductList");
	}
	
	public ArrayList selectProductCategoryList(SqlSession sqlSession, PageInfo pi, int cNo) {
		int offset = (pi.getCurrentPage()-1)* pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("productMapper.selectProductCategoryList", cNo, rowBounds);
	}

}
