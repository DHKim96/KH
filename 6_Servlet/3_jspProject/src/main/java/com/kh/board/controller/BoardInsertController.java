package com.kh.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;
import com.kh.common.MyFileRenamePolicy;
import com.kh.common.vo.Attachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.bo")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 일반 방식이 아닌 multipart/form-data 로 전송 시 request 로부터 값 추출 불가
		// MultipartRequest multiRequest = new MultipartRequest(HttpServletRequest 객체, 저장할 폴더 경로, 제한할 용량, 인코딩, new DefaultFileRenamePolicy());
		
		// 인코딩 타입(enctype) = multipart/form-data 여부 확인
		if(ServletFileUpload.isMultipartContent(request)) {
			// 파일 업로드 위한 라이브러리 : cos.jar()
			// www.servlets.com 에서 다운로드
			
			// 1. 전달되는 파일을 처리할 작업 내용(전달되는 파일 용량 제한, )
			// 1.1. 용량 제한(byte)
			int maxSize = 1024 * 1024 * 10; // 10mb
			// 1.2. 전달된 파일 저장할 폴더 경로 알아내기
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfile/");
			
			/*
			 * 2. 전달된 파일의 파일명 수정 및 서버에 업로드 작업
			 * 
			 * HttpServletRequest => MultipartRequest 로 변환해줘야 함
			 * MultipartRequest multiRequest = new MultipartRequest(HttpServletRequest 객체, 저장할 폴더 경로, 제한할 용량, 인코딩, new DefaultFileRenamePolicy());
			 * 위 구문 한 줄 실행만으로 넘어온 첨부파일이 해당 폴더에 무조건 업로드됨
			 * 단, 업로드시 파일명 수정해줘야 함 따라서 파일명 수정 위한 객체 제시해야 함
			 * (why? 동일 파일명일 시 덮어씌워지며, 파일명에 한글/특문/띄어쓰기 포함 시 서버에 따라 문제 발생 가능)
			 * 
			 * 기본적으로 파일명 안 겹치도록 수정 작업해주는 객체
			 * => DefaultFileRenamePolicy 객체(cos 라이브러리에 내포)
			 * => 내부적으로 rename(원본 파일명){
			 * 	기존에 동일 파일명 존재 시 파일명 뒤에 숫자 붙여줌 ex) aaa.jpg, aaa1.jpg, 
			 * 	return 수정 파일
			 * }
			 * 
			 * 나만의 방식대로 절대 겹치지 않도록 rename 할 수 있게 FileRenamePolicy 클래스 만들기(com.kh.common.MyFileRenamePolicy)
			 */
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
			/*
			 * 3. DB에 기록할 데이터 추출해서 VO에 담아주자
			 * 	> 카테고리번호, 제목, 내용, 작성자 번호
			 *  > 첨부파일 있을 시 원본명, 수정명, 저장 폴더 경로
			 */
			
			String category = multiRequest.getParameter("category");
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			String boardWriter = multiRequest.getParameter("userNo");
			
			Board b = new Board();
			b.setCategory(category);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
			b.setBoardWriter(boardWriter);
			
			Attachment at = null;
			
			if(multiRequest.getOriginalFileName("upfile") != null) { // 원본 파일명
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile")); // 저장한 파일명(수정된)
				at.setFilePath("resources/board_upfile/");
			}
			
			// 4. 서비스 요청
			int result = new BoardService().insertBoard(b, at);
			
			// 5. 응답뷰 요청
			if (result > 0) { // 성공 -> 목록페이지(kh/list.bo?cpage=1)
				request.getSession().setAttribute("alertMsg", "일반게시글 작성 성공");
				response.sendRedirect(request.getContextPath() + "/list.bo?cpage=1");
			} else { // 실패 -> 업로드된 파일 삭제 후 에러 페이지 
				if(at != null) { // 데이터베이스 저장 실패했을 뿐 업로드는 됐음
					new File(savePath + at.getChangeName()).delete(); // 업로드된 파일 삭제
				}
				request.setAttribute("errorMsg", "일반게시글 작성 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
