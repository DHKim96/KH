package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.notice.model.vo.Notice;
import com.kh.notice.service.NoticeService;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 데이터 추출 -> 객체로 만들어서 서비스로 전달
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
		/*
		 * 로그인한 회원 정보를 얻어내는 방법
		 * 1) input type="hidden"으로 처음부터 요청시 숨겨서 전달하는 방법
		 * 2) session 영역에서 저장된 회원 객체로부터 얻어오는 방법
		 */
		
		//2번 사용
		HttpSession session = request.getSession();
		int userNo = ((Member)session.getAttribute("loginUser")).getUserNo();
		
		Notice no = new Notice();
		no.setNoticeTitle(noticeTitle);
		no.setNoticeContent(noticeContent);
		no.setNoticeWriter(String.valueOf(userNo));
		
		//insertNotice()
		int result = new NoticeService().insertNotice(no);
		
		// 응답 페이지
		if(result > 0) { // 작성 성공
			session.setAttribute("alertMsg", "공지사항이 성공적으로 등록됐습니다.");
			// jsp url 재요청 => 공지사항 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/list.no");
		} else {
			request.setAttribute("errorMsg", "공지사항 등록에 실패했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
