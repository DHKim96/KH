package com.ohouse.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ohouse.common.template.PageInfo;
import com.ohouse.common.template.Pagination;
import com.ohouse.product.model.vo.Product;
import com.ohouse.product.service.ProductListServiceImpl;

/**
 * Servlet implementation class ProductCategoryAjax
 */
@WebServlet("/ajaxCategoryList.pr")
public class ProductCategoryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCategoryAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		int currentPage = Integer.parseInt((request.getParameter("cpage"))) ;
		int saleListCount = new ProductListServiceImpl().selectListCount();
		
		PageInfo pi = Pagination.getPageInfo(saleListCount, currentPage, 10, 12);
		ArrayList<Product> cList =  new ProductListServiceImpl().selectProductCategoryList(pi, cNo);
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(cList, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
