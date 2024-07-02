package com.ohouse.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.product.model.vo.OptionsCategory;
import com.ohouse.product.model.vo.OptionsName;
import com.ohouse.product.model.vo.Product;
import com.ohouse.product.service.ProductOrderService;
import com.ohouse.product.service.ProductOrderServiceImp;

/**
 * Servlet implementation class ProductOrderController
 */
@WebServlet("/orderForm.pr")
public class ProductOrderFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProductOrderFormController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductOrderService pServ = new ProductOrderServiceImp();
		
		int pNo = Integer.parseInt(request.getParameter("pNo"));
		Product p = pServ.selectProductDetail(pNo);
		
		int optNameNo = Integer.parseInt(request.getParameter("optNameNo"));
		OptionsName optName = pServ.selectOptNameDetail(optNameNo);
		
		int amount = Integer.parseInt(request.getParameter("amount"));
				
//		 하나라도 null인 경우를 처리하는 if 문
		if (p == null || optName == null) {
			request.setAttribute("alertMsg", "상세 조회 실패");
			response.sendRedirect(request.getContextPath()+"/detail.pr"); //메인으로 보내기
		} else {
			request.setAttribute("p", p);
		    request.setAttribute("o", optName);
		    request.setAttribute("amount", amount);
		    request.getRequestDispatcher("views/product/productOrderPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
