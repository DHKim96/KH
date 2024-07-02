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
 * Servlet implementation class ProductBestPageAjax
 */
@WebServlet("/ajaxBestList.pr")
public class ProductBestPageAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductBestPageAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage = Integer.parseInt((request.getParameter("cpage"))) ;
		int saleListCount = new ProductListServiceImpl().selectListCount();
		
		PageInfo pi = Pagination.getPageInfo(saleListCount, currentPage, 10, 12);
		ArrayList<Product> list = new ProductListServiceImpl().selectListProduct(pi);
		
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
