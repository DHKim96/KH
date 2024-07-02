package com.ohouse.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.community.model.vo.Reply;
import com.ohouse.community.service.CommunityService;
import com.ohouse.community.service.CommunityServiceImpl;

/**
 * Servlet implementation class AjaxReplyInsertController
 */
@WebServlet("/insertReply.co")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		CommunityService service = new CommunityServiceImpl();
		Reply r = new Reply();
		r.setReplyContent(request.getParameter("replyContent"));
		r.setReplyBoardId(request.getParameter("boardId"));
		r.setReplyMembersNo(request.getParameter("membersNo"));
		
		int result = service.insertReply(r);
		if(result > 0) {
			response.getWriter().print("Y");
		} else {
			response.getWriter().print("N");
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
