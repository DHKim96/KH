package com.ohouse.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.common.model.vo.Media;
import com.ohouse.community.model.vo.Board;
import com.ohouse.community.service.CommunityService;
import com.ohouse.community.service.CommunityServiceImpl;

/**
 * Servlet implementation class CommunityListController
 */
@WebServlet("/list.co")
public class CommunityListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunityService service = new CommunityServiceImpl();
		ArrayList<Board> bList = service.selectBoardList();
		ArrayList<Media> mList = new ArrayList<>();
		
		for(Board b : bList) {
			mList.add(service.selectProfile(Integer.parseInt(b.getMembersNo())));
		}
		
		request.setAttribute("bList", bList);
		request.setAttribute("mList", mList);
		request.getRequestDispatcher("views/community/communityMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
