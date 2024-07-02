package com.ohouse.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.common.model.vo.Scrap;
import com.ohouse.product.service.ProductListServiceImpl;

/**
 * Servlet implementation class ProductScrapController
 */
@WebServlet("/scrap.pr")
public class ProductScrapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProductScrapController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mNo =  Integer.parseInt(request.getParameter("mNo"));
		int pNo =  Integer.parseInt(request.getParameter("pNo"));
		String status = request.getParameter("status");
		Scrap scrap = new Scrap();
		scrap.setScrapMembersNo(mNo);
		scrap.setScrapProductId(pNo);
		scrap.setScrapStatus(status);
		
		int statusCheck = new ProductListServiceImpl().productScrapstatusCheck(scrap);
		int result = 0;
		if(statusCheck > 0) {
			result = new ProductListServiceImpl().productScrapUpdate(scrap);
		} else {		
			result = new ProductListServiceImpl().productScrapInsert(scrap);
		}
		
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
