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
 * Servlet implementation class NoticeUpdateController
 */
@WebServlet("/update.no")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		//데이터 추출해서 객체로 변환
		int noticeNo = Integer.parseInt(request.getParameter("num"));
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
		Notice n = new Notice();
		n.setNoticeNo(noticeNo);
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		
		//실제 데이터베이스에서 update -> updateNotice()
		int result = new NoticeService().updateNotice(n);
		
		//성공시 -> /kh/detail.no?num=
		if (result > 0) {
			// 재요청(redirect)을 보내야한다
			// 왜? 지금 페이지 경로는 kh/update.no -> 수정요청페이지
			// 하지만 내가 다음으로 보여주고싶은 페이지는? => 상세페이지(kh/detail.no)
			// url경로가 다르니까 재요청을 통해서 화면과 url을 맞춰주자
			request.getSession().setAttribute("alertMsg", "성공적으로 공지사항이 변경되었습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.no?num=" + n.getNoticeNo());
			
		} else { //실패시 -> error페이지
			//실패시에는 왜 request에 errorMsg를 담을까?
			// 에러페이지는 따로 url이 필요하지않다.(왜?  errorPage를 직접 찾아갈 일이 없다.)
			// => 포워딩 => 포워딩시에는 request를 전달할 수 있으니까 
			request.setAttribute("errorMsg", "공지사항 수정에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
