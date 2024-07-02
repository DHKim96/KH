package com.ohouse.community.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohouse.common.model.vo.Scrap;
import com.ohouse.community.service.CommunityScrapService;
import com.ohouse.community.service.CommunityScrapServiceImpl;

/**
 * Servlet implementation class CommunityScrapController
 */
@WebServlet("/scrap.co")
public class AjaxScrapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxScrapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int membersNo = Integer.parseInt(request.getParameter("membersNo"));
		String boardId = request.getParameter("boardId");
		String mediaId = request.getParameter("mediaId");
		
		Scrap scrap = new Scrap();
		scrap.setScrapMembersNo(membersNo);
		
		int result = 0;
		CommunityScrapService service = new CommunityScrapServiceImpl();
		
		if(boardId != null) {
			scrap.setScrapBoardId(Integer.parseInt(boardId));
			Scrap s = service.selectBoardScrap(scrap);
			if(s != null) {
				String scrapStatus = s.getScrapStatus().equals("Y") ? "N" : "Y";
				HashMap<String, String> map = new HashMap<>();
				map.put("scrapId", String.valueOf(s.getScrapId()));
				map.put("scrapStatus", scrapStatus);
				result = service.updateBoardScrap(map);
			} else {
				result = service.insertBoardScrap(scrap);
			}
		} else {
			scrap.setScrapMediaId(Integer.parseInt(mediaId));
			Scrap s = service.selectMediaScrap(scrap);
			if(s != null) {
				String scrapStatus = s.getScrapStatus().equals("Y") ? "N" : "Y";
				HashMap<String, String> map = new HashMap<>();
				map.put("scrapId", String.valueOf(s.getScrapId()));
				map.put("scrapStatus", scrapStatus);
				result = service.updateMediaScrap(map);
			} else {
				result = service.insertMediaScrap(scrap);
			}
		}
		
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
