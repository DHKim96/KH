package com.ohouse.product.service;

import java.util.ArrayList;

import com.ohouse.common.model.vo.Scrap;
import com.ohouse.common.template.PageInfo;
import com.ohouse.product.model.vo.Product;


public interface ProductListService {
	//productBestPage 리스트
	public ArrayList<Product> selectListProduct(PageInfo pi);
	//productMainPage 리스트
	public ArrayList<Product> selectListProduct();
	//productBestPage 리스트갯수
	public int selectListCount();
	
	//productSalePage 리스트갯수
	public int selectProductListCount(String condition);
	
	//productSalePage 리스트
	public ArrayList<Product> selectProductSaleList(PageInfo pi, String condition);
	//productMainSalePage 리스트 
	public ArrayList<Product> selectProductSaleList();
	//productScrapStatusCheck
	public int productScrapstatusCheck(Scrap scrap);
	
	//productScrapInsert
	public int productScrapInsert(Scrap scrap);
	
	//productScrpaUpdate
	public int productScrapUpdate(Scrap scrap);
	
	//productCategroyList
	public ArrayList<Product> selectProductCategoryList(PageInfo pi, int cNo);
}
