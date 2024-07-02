package com.ohouse.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.community.model.vo.Board;
import com.ohouse.community.service.CommunityService;
import com.ohouse.community.service.CommunityServiceImpl;

/**
 * Servlet implementation class CommunityDetailController
 */
@WebServlet("/detail.co")
public class CommunityDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("bid"));
		
		CommunityService service = new CommunityServiceImpl();
		int result = service.increaseViews(boardId);
		
		if(result > 0) {
			Board b = service.selectBoard(boardId);
			request.setAttribute("b", b);
			request.getRequestDispatcher("views/community/communityPage.jsp").forward(request, response);;
		} else {
			request.getSession().setAttribute("alertMsg", "게시글을 조회할 수 없습니다.");
			response.sendRedirect(request.getContextPath() + "/list.co");
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
