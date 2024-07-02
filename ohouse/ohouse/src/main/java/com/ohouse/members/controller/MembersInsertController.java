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
 * Servlet implementation class MemberRegisterController
 */
@WebServlet("/insert.me")
public class MembersInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MembersInsertController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String membersId = request.getParameter("id");
		String membersEmail = request.getParameter("email");
		String membersPwd = request.getParameter("pwd");
		String membersPhone = request.getParameter("phone");
		String membersName = request.getParameter("nickname");
		
		// 아래 데이터는 NOT NULL 조건으로 인해 추가한 값, 추후 수정 예정
		String membersType = "일반회원";
		
		Members m = new Members();
		m.setMembersId(membersId);
		m.setMembersEmail(membersEmail);
		m.setMembersPwd(membersPwd);
		m.setMembersPhone(membersPhone);
		m.setMembersName(membersName);
		m.setMembersType(membersType);
		
		int result = new MembersServiceImpl().insertMembers(m);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "회원가입이 완료되었습니다.");
			response.sendRedirect(request.getContextPath());
		} else {
			request.getSession().setAttribute("alertMsg", "회원가입이 완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/enrollForm.me");
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
