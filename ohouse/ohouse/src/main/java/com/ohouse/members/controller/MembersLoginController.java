package com.ohouse.members.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.members.model.vo.Members;
import com.ohouse.members.service.MembersServiceImpl;

/**
 * Servlet implementation class MemberLoginController
 */
@WebServlet("/login.me")
public class MembersLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MembersLoginController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String membersId = request.getParameter("id");
		String membersPwd = request.getParameter("password");
		
		Members m = new Members();
		m.setMembersId(membersId);
		m.setMembersPwd(membersPwd);
		
		Members loginUser = new MembersServiceImpl().loginMembers(m);
		
		if(loginUser == null) {
			request.getSession().setAttribute("alertMsg", "로그인에 실패하였습니다.");
			response.sendRedirect(request.getContextPath() + "/loginForm.me");
		} else {
			request.getSession().setAttribute("loginUser", loginUser);
			response.sendRedirect(request.getContextPath());
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
