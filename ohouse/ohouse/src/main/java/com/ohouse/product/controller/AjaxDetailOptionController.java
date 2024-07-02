package com.ohouse.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ohouse.product.model.vo.OptionsName;
import com.ohouse.product.service.ProductDetailService;
import com.ohouse.product.service.ProductDetailServiceImpl;

/**
 * Servlet implementation class AjaxDetailOptionController
 */
@WebServlet("/detailOption.pr")
public class AjaxDetailOptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxDetailOptionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cgNo = Integer.parseInt(request.getParameter("cgNo"));
		ProductDetailService service = new ProductDetailServiceImpl();
		ArrayList<OptionsName> list = service.selectOptionsNameList(cgNo);
		
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
