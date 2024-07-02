package com.ohouse.members.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohouse.members.model.vo.Members;
import com.ohouse.members.service.MembersServiceImpl;

/**
 * Servlet implementation class MembersDeleateController
 */
@WebServlet("/delete.me")
public class MembersDeleateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembersDeleateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String membersId = request.getParameter("checkId");
		String membersPwd = request.getParameter("checkPwd");
		
		Members m = new Members();
		m.setMembersId(membersId);
		m.setMembersPwd(membersPwd);
		
		int result = new MembersServiceImpl().deleteMembers(m);
		
		HttpSession session = request.getSession();
		if(result > 0) {
			session.removeAttribute("loginUser");
			session.setAttribute("alertMsg", "회원탈퇴 완료하였습니다. 이용해주셔서 감사합니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			session.setAttribute("alertMsg", "비밀번호가 틀립니다.");
			response.sendRedirect(request.getContextPath() + "/updateForm.me");
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
