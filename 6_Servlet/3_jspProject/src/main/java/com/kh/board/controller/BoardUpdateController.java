package com.kh.board.controller;

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
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update.bo")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			//1) 용량 제한 설정
			int maxSize = 1024 * 1024 * 10;
			// 2) 물리적 저장 경로
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfile/");
			// 3) 전달된 파일명 수정 후 서버에 업로드
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());;
			// 4) sql 문 실행에 필요한 값 추출해서 vo에 저장
			int boardNo = Integer.parseInt(multiRequest.getParameter("bno"));
			String category = multiRequest.getParameter("category");
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			
			Board b = new Board();
			b.setBoardNo(boardNo);
			b.setCategory(category);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
			
			Attachment at = null; // 넘어온 첨부파일이 있을 시 생성
			if(multiRequest.getOriginalFileName("upfile") != null){// 넘어온 첨부 파일이 있을 때
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				at.setFilePath("resources/board_upfile/");
				
				// 기존 파일이 있는 상태에서 새로 첨부 파일 추가 (update attachment)
				// 기존 파일이 없는 상태에서 첨부 파일 추가
				if(multiRequest.getParameter("originFileNo") != null) { // 기존 첨부 파일 존재 여부
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
				} else { // 첨부 파일이 없을 때 => insert
					at.setRefBoardNo(boardNo);
				}
			} // 새로운 첨부 파일 없을 시 at = null;
			int result = new BoardService().updateBoard(b, at); 
			// 새로운 첨부 파일 x							b, null => board update
			// 새로운 첨부 파일 o, 기존 첨부 파일 o				b, fileNo 담은 at => board update, attachment update
			// 새로운 첨부 파일 o, 기존 첨부 파일 x				b, refBno 담은 at => board update, attachment insert
			
			if(result > 0) { // 성공
				//  /kh/detail.bo?bno=게시글 번호
				request.getSession().setAttribute("alertMsg", "게시글 수정 성공");
				response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + b.getBoardNo());
			} else {
				// 실패 => error 페이지
				request.setAttribute("errorPage", "게시글 수정 실패");
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
