package com.kh.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.notice.model.vo.Notice;
import com.kh.notice.service.NoticeService;

/**
 * Servlet implementation class NoticeUpdateForm
 */
@WebServlet("/update.no")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 데이터 추출 -> 객체로 만들어서 서비스로 전달
		int noticeNo = Integer.parseInt(request.getParameter("num"));
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
	
		Notice no = new NoticeService().selectNotice(noticeNo);
		// setNo 이 아니라 위 방법으로 해야 코드 무결성?
		no.setNoticeTitle(noticeTitle);
		no.setNoticeContent(noticeContent);
		
		//insertNotice()
		int result = new NoticeService().updateNotice(no);
		// 응답 페이지
		if(result > 0) { // 작성 성공
			request.getSession().setAttribute("alertMsg", "공지사항이 성공적으로 수정됐습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.no?num=" + no.getNoticeNo());
			// 내가 지금 보고 있는 곳과 내가 다음에 갈 곳의 url 경로가 다르기 때문에 재요청 통해서 화면과 url을 맞춰주는 것
		} else {
			request.setAttribute("errorMsg", "공지사항 수정에 실패했습니다.");
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
