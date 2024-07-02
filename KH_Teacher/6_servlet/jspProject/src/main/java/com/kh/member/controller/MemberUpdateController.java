package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
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
		
		Member m = new Member(userId, userName, phone, email, address, interest);
	
		Member updateMem = new MemberService().updateMember(m);
		
		if (updateMem == null) { //실패
			//에러문구담아서 에러페이지 포워딩
			request.setAttribute("errorMsg", "회원정보 수정에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		} else { // 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", updateMem);
			session.setAttribute("alertMsg", "성공적으로 수정하였습니다.");
			
			//url 재요청 => 마이페이지 재요청(/kh/myPage.me)
			response.sendRedirect(request.getContextPath() + "/myPage.me");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
