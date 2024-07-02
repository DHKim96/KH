package com.ohouse.members.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.ohouse.common.MyFileRenamePolicy;
import com.ohouse.common.model.vo.Media;
import com.ohouse.members.model.vo.Members;
import com.ohouse.members.service.MembersService;
import com.ohouse.members.service.MembersServiceImpl;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MembersUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MembersUpdateController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Members loginUser = (Members)(request.getSession().getAttribute("loginUser"));
		
		if(ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 1024 * 1024 * 100;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/img/common/");
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			Media media = new Media();
			
			try {
				media.setMediaId(Integer.parseInt(multiRequest.getParameter("mid")));
			} catch (Exception e) {
				media.setMediaId(0);
				media.setMediaMembersId(loginUser.getMembersNo());
			}
			
			if(multiRequest.getOriginalFileName("profile") == null) {
				media.setOriginName("user.png");				
				media.setChangeName("user.png");
			} else {
				media.setOriginName(multiRequest.getOriginalFileName("profile"));				
				media.setChangeName(multiRequest.getFilesystemName("profile"));
			}
			media.setFilePath("resources/img/common/");
			media.setFileLevel(3);
			
			Members m = new Members();
			m.setMembersNo(loginUser.getMembersNo());
			m.setMembersId(loginUser.getMembersId());
			m.setMembersName(multiRequest.getParameter("name"));
			m.setMembersEmail(multiRequest.getParameter("email"));
			m.setMembersPhone(multiRequest.getParameter("phone"));
			m.setMembersBirth(Date.valueOf(multiRequest.getParameter("birth")));
			m.setGender(multiRequest.getParameter("gender"));
			
			MembersService service = new MembersServiceImpl();
			loginUser = service.updateMembers(media, m);
			
			if(loginUser != null) {
				request.getSession().setAttribute("loginUser", loginUser);
				request.getSession().setAttribute("alertMsg", "성공적으로 수정되었습니다.");
			} else {
				request.setAttribute("alertMsg", "수정에 실패하였습니다.");
			}
			response.sendRedirect(request.getContextPath() + "/updateForm.me");
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
