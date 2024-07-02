package com.ohouse.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.ohouse.common.MyFileRenamePolicy;
import com.ohouse.common.model.vo.Media;
import com.ohouse.community.model.vo.Board;
import com.ohouse.community.service.CommunityService;
import com.ohouse.community.service.CommunityServiceImpl;
import com.ohouse.members.model.vo.Members;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class CommunityUpdateController
 */
@WebServlet("/update.co")
public class CommunityUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 100;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/img/community/communityMain/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			Board b = new Board();
			b.setBoardId(multiRequest.getParameter("bid"));
			b.setFilType(multiRequest.getParameter("type"));
			b.setFilArea(multiRequest.getParameter("area"));
			b.setFilNum(multiRequest.getParameter("num"));
			b.setFilDirection(multiRequest.getParameter("direction"));
			b.setFilPast(multiRequest.getParameter("past"));
			b.setFilLocal(multiRequest.getParameter("local"));
			b.setFilFamily(multiRequest.getParameter("family"));
			b.setFilPet(multiRequest.getParameter("pet"));
			b.setFilFamMemCnt(multiRequest.getParameter("familyMemCnt"));
			b.setFilField(multiRequest.getParameter("field"));
			b.setFilWorker(multiRequest.getParameter("worker"));
			b.setFilRange(multiRequest.getParameter("range"));
			b.setFilPeriod(multiRequest.getParameter("period"));
			b.setFilPeriodType("주");
			b.setFilConPrice(multiRequest.getParameter("constructionPrice"));
			b.setFilUrl(multiRequest.getParameter("url"));
			b.setFilCopy(multiRequest.getParameter("copyright"));
			
			b.setMembersNo(String.valueOf(((Members)request.getSession().getAttribute("loginUser")).getMembersNo()));
			b.setBoardTitle(multiRequest.getParameter("title"));
			b.setIntroduction(multiRequest.getParameter("introduction"));
			b.setDescription(multiRequest.getParameter("description"));
			
			ArrayList<Media> list = new ArrayList<>();
			
			int idx = 1;
			while(idx <= 8) {
				String key = "file" + idx;
				if(multiRequest.getOriginalFileName(key) == null) break;
				
				Media m = new Media();
				m.setMediaId(Integer.parseInt(multiRequest.getParameter("mid")));
				m.setOriginName(multiRequest.getOriginalFileName(key));
				m.setChangeName(multiRequest.getFilesystemName(key));
				m.setFilePath("resources/img/community/communityMain/");
				m.setFileLevel(idx == 1 ? 1 : 2);
				
				list.add(m);
				idx++;
			}
			
			CommunityService service = new CommunityServiceImpl();
			int result = service.updateBoard(b, list);
			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "성공적으로 게시글을 수정하였습니다.");
			} else {
				request.getSession().setAttribute("alertMsg", "게시글 수정 실패");
			}
			
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
