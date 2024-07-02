package com.ohouse.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.common.template.PageInfo;
import com.ohouse.common.template.Pagination;
import com.ohouse.product.model.vo.Product;
import com.ohouse.product.service.ProductListServiceImpl;

/**
 * Servlet implementation class ProductSaleListController
 */
@WebServlet("/saleList.pr")
public class ProductSaleListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProductSaleListController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");		
		int currentPage = Integer.parseInt((request.getParameter("cpage"))) ;
		int saleListCount = new ProductListServiceImpl().selectProductListCount(condition);
		
		PageInfo pi = Pagination.getPageInfo(saleListCount, currentPage, 10, 12);
		ArrayList<Product> psList = new ProductListServiceImpl().selectProductSaleList(pi, condition);
		
		
		request.setAttribute("listCount", saleListCount);
		request.setAttribute("psList", psList);
		request.setAttribute("pi", pi);
		request.getRequestDispatcher("views/product/productSalePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
