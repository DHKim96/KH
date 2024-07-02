package com.ohouse.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ohouse.common.model.vo.Media;
import com.ohouse.community.service.CommunityService;
import com.ohouse.community.service.CommunityServiceImpl;

/**
 * Servlet implementation class AjaxProfileController
 */
@WebServlet("/profile.co")
public class AjaxProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int membersNo = 0;
		
		try {
			membersNo = Integer.parseInt(request.getParameter("mNo"));
		} catch(Exception e) {
			membersNo = 0;
		}
		
		CommunityService service = new CommunityServiceImpl();
		Media m = service.selectProfile(membersNo);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(m, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
