package com.ohouse.product.service;

import java.util.ArrayList;

import com.ohouse.product.model.vo.OptionsCategory;
import com.ohouse.product.model.vo.OptionsName;
import com.ohouse.product.model.vo.Product;

public interface ProductDetailService {
	Product selectProduct(int productId);

	ArrayList<OptionsCategory> selectCategoryList(int productId);

	ArrayList<OptionsName> selectOptionsNameList(int cgNo);
	
}
