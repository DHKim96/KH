package com.ohouse.common.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.common.model.vo.Media;
import com.ohouse.common.service.CommonService;
import com.ohouse.common.service.CommonServiceImpl;
import com.ohouse.community.model.vo.Board;
import com.ohouse.community.service.CommunityService;
import com.ohouse.community.service.CommunityServiceImpl;
import com.ohouse.product.model.vo.Product;

/**
 * Servlet implementation class SearchItemController
 */
@WebServlet("/search.se")
public class SearchItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchItemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("searchKeyword");  // 사용자가 입력한 검색어
		
		CommonService cServ = new CommonServiceImpl(); 
		CommunityService coServ = new CommunityServiceImpl();
		
		ArrayList<Board> boards = cServ.searchBoardList(keyword);
		ArrayList<Product> products = cServ.searchProductList(keyword);
		ArrayList<Media> mList = new ArrayList<>();
		
		for(Board b : boards) {
			mList.add(coServ.selectProfile(Integer.parseInt(b.getMembersNo())));
		}

		request.setAttribute("boards", boards);
		request.setAttribute("products", products);
		request.setAttribute("mList", mList);
		request.setAttribute("searchKeyword", keyword);
		
		request.getRequestDispatcher("views/common/searchPage.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
