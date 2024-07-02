package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/insert.me")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1)인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청시 전달값 추출해서 변수및 객체저장
		String userId = request.getParameter("userId"); // "user03"
		String userPwd = request.getParameter("userPwd"); // "pass03"
		String userName = request.getParameter("userName"); // "김개똥"
		String phone = request.getParameter("phone"); // "010-4141-1111" || ""
		String email = request.getParameter("email"); // "sdkjvh@naver.com" || ""
		String address = request.getParameter("address"); // "경기도 안산시" || ""
		String[] interestArr = request.getParameterValues("interest"); // ["등산","영화"] || null
									
		//String[] ==> String
		// ["등산","영화"]  ==> "등산,영화"
		String interest = "";
		if (interestArr != null) {
			interest = String.join(",", interestArr);
		}
		
		Member m = new Member(userId, userPwd, userName, phone, email, address, interest);
		
		// 3) sql요청 => service => dao => sql실행
		int result = new MemberService().insertMember(m);
		
		// 4) 결과값에따른 페이지반환
		
		if (result > 0) { //회원가입 성공
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원가입이 되었습니다.");
			
			// jsp url 재요청 => index페이지로
			response.sendRedirect(request.getContextPath());
		} else { //회원가입 실패
			//에러문구가 보여지는 에러페이지
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
