package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/delete.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 받아왔기에 인코딩
		request.setCharacterEncoding("UTF-8");
		// 전달받은 데이터 추출
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		int result = new MemberService().deleteMember(userId, userPwd);
		HttpSession session = request.getSession();
		if(result > 0) {
			session.setAttribute("alertMsg", "회원 탈퇴 성공");
			// session 에 있는 로그인 정보 삭제
			session.removeAttribute("loginUser");
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("alertMsg", "회원 탈퇴 실패");
			response.sendRedirect(request.getContextPath() + "/myPage.me");
		}
		/*
		 * 정보 변경, 비밀번호 변경 -> 데이터를 데이터베이스로 다시 가져와 넣어주기
		 * 탈퇴 성공 시 => 메인페이지 alert(성공했다.) & 로그아웃
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
