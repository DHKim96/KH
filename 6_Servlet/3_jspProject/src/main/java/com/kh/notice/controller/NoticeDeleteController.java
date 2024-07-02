package com.kh.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.service.NoticeService;

/**
 * Servlet implementation class NoticeDeleteController
 */
@WebServlet("/delete.no")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 가져오기
		int noticeNo = Integer.parseInt(request.getParameter("num"));
		// delete문 실행
		int result = new NoticeService().deleteNotice(noticeNo);
		// 페이지 리턴
		if(result > 0) { // 작성 성공
			request.getSession().setAttribute("alertMsg", "공지사항 삭제 성공");
			response.sendRedirect(request.getContextPath() + "/list.no");
			// 내가 지금 보고 있는 곳과 내가 다음에 갈 곳의 url 경로가 다르기 때문에 재요청 통해서 화면과 url을 맞춰주는 것
		} else {
			request.setAttribute("errorMsg", "공지사항 삭제 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			//에러페이지는 직접 찾아갈 일이 없기 때문에 따로 url 이 필요하지 않음 따라서 포워딩
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
