package com.ohouse.members.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ohouse.common.model.vo.Media;
import com.ohouse.members.service.MembersScrapServiceImpl;

/**
 * Servlet implementation class AjaxScrapPageList
 */
@WebServlet("/scrapPageList.me")
public class AjaxScrapPageList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxScrapPageList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mNo = Integer.parseInt(request.getParameter("mNo"));
		int scrapType = Integer.parseInt(request.getParameter("scrapType"));
		
		ArrayList<Media> list = new MembersScrapServiceImpl().MembersScrapList(mNo, scrapType); 
		
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
