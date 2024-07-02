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
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1) 전달값에 한글이 있을 경우 인코딩 처리(POST일 경우)
		request.setCharacterEncoding("UTF-8");
		
		//2) 요청시 전달값 추출해서 변수 또는 객체에 기록하기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		//3) 요청하기(db에 sql문 활용해서 조회해줘)
		// service클래스에 담당 메서드 호출
		Member loginUser = new MemberService().loginMember(userId, userPwd);
	
		/**
		 * 응답페이지에 전달할 값이 있을 경우 어딘가에는 담아야한다. (담을 수 있는 영역)
		 * 1) apllication : 여기에 담긴 데이터는 웹 애플리케이션 전역에서 다 꺼내서 쓸 수 있음
		 * 2) session : 여기에 담긴 데이터는 직접 지우기 전까지, 세션이 만료(서버가 멈추거나, 브라우저 종료)되기 전까지
		 * 				어떤 jsp든, 어떤 servlet이건 꺼내서 사용할 수 있다.
		 * 3) request : 해당 영역에 담긴 데이터는 현재 이 request객체를 "포워딩한 응답 jsp에서만" 꺼내 쓸 수 있다.
		 * 4) page: 해당 jsp에서담고 해당 jsp에서만 사용할 수 있다.
		 * 
		 * 공통적으로 데이터를 담고자한다면 특정객체.setAttribute("키", 벨류)
		 * 			데이터를 꺼내고자 한다면 특정객체.getAttribute("키")
		 * 			데이터를 지우고자 한다면 특정객체.removeAttribute("키")
		 */
		
		
		//4)처리된 결과를 가지고 사용자가 보게될 응답뷰를 지정해서 포워딩 또는 url재요청
		if(loginUser == null) {
			//조회결과 없음 => 로그인 실패 => 에러문구가 보여지는 에러페이지로 포워딩
			request.setAttribute("errorMsg", "로그인에 실패하였습니다.");
			
			//응답페이지에게 위임
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			
			view.forward(request, response);
		} else {
			//조회결과 있음 => 로그인 성공!!
			//로그인한 회원정보(loginUser)를 session영역에 담기(왜? 여기저기서 다 가져다 쓸 수 있도록)
			//Servlet에서는 session영역에 접근하고자 한다면 우선 세션객체를 얻어야한다
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			//1. 포워딩방식 => 해당방식은 url이 변경되지 않는다. => 우리는 localhost:8001/kh/라는 기존에 메인 url이 있는데
			// 해당 방식으로 화면 응답시 url은 http://localhost:8001/kh/login.me가 나타난다. 
			// 실제 화면은 localhost:8001/kh/의 응답화면이 나타난다.
			//
			
			//2. url재요청 방식
			//기존에 해당 페이지를 응답하는 url이 존재한다면 사용가능
			// 응답페이지 => index.jsp페이지 (jsp url 재요청)
 			response.sendRedirect(request.getContextPath());
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
