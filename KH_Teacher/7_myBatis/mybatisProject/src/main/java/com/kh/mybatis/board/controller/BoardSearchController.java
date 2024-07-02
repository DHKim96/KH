package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.service.BoardService;
import com.kh.mybatis.board.service.BoardServiceImpl;
import com.kh.mybatis.common.template.Pagination;
import com.kh.mybatis.common.vo.PageInfo;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition"); // writer || title || content
		String keyword = request.getParameter("keyword"); //사용자가 입력한 키워드값
		
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		BoardService bService = new BoardServiceImpl();
		int searchCount = bService.selectSearchCount(map);
		int currentPage = Integer.parseInt(request.getParameter("cpage")); //페이지정보
		
		PageInfo pi = Pagination.getPageInfo(searchCount, currentPage, 10 , 5);
		ArrayList<Board> list = bService.selectSearchList(map, pi);
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("condition", condition);
		request.setAttribute("keyword", keyword);
		
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
