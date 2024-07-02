package com.ohouse.common.service;

import java.util.ArrayList;

import com.ohouse.community.model.vo.Board;
import com.ohouse.product.model.vo.Product;

public interface CommonService {
	/**
	 * 
	 * @param keyword
	 * @return 검색된 상품 리스트
	 */
	ArrayList<Product> searchProductList(String keyword);
	
	/**
	 * 
	 * @param keyword
	 * @return 검색된 집들이 게시글 리스트
	 */
	ArrayList<Board> searchBoardList(String keyword);
	
	/**
	 * 
	 * @param keyword
	 * @return 검색된 상품 갯수
	 */
	int searchProductListCount(String keyword);
	
	/**
	 * 
	 * @param keyword
	 * @return 검색된 집들이 게시글 갯수
	 */
	int searchBoardListCount(String keyword);
}
