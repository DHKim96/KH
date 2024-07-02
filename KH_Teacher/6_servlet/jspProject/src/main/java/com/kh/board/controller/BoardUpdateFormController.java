package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.board.service.BoardService;

/**
 * Servlet implementation class BoardUpdateFormController
 */
@WebServlet("/updateForm.bo")
public class BoardUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//bno 가져오기
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		//카테고리, 보드, 첨부파일 가져오기
		BoardService bService = new BoardService();
		
		ArrayList<Category> list = bService.selectCategoryList();
		Board b = bService.selectBoard(boardNo);
		Attachment at = bService.selectAttachment(boardNo);
		
		//데이터 담아서 응답뷰요청 boardUpdateForm.jsp
		request.setAttribute("list", list);
		request.setAttribute("b", b);
		request.setAttribute("at", at);
		
		request.getRequestDispatcher("views/board/boardUpdateForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
