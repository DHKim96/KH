package com.ohouse.members.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohouse.members.model.vo.Members;
import com.ohouse.members.service.MembersServiceImpl;

/**
 * Servlet implementation class MembersSettingController
 */
@WebServlet("/updatePwd.me")
public class MembersUpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MembersUpdatePwdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String updatePwd = request.getParameter("updatePwd");
		
//		Members updateMem = new MembersServiceImpl().updatePwdMembers(userId, userPwd, updatePwd);
//	
//		if (updateMem == null) { 
//			HttpSession session = request.getSession();
//			session.setAttribute("alertMsg", "비밀번호 수정에 실패하였습니다.");
//						
//			response.sendRedirect(request.getContextPath() + "/updateForm.me");
//		} else { 
//			HttpSession session = request.getSession();
//			session.setAttribute("alertMsg", "성공적으로 수정하였습니다.");
//			session.setAttribute("loginUser", updateMem);
//			
//			response.sendRedirect(request.getContextPath() + "/updateForm.me");
//		}
		
		HashMap<String, String> map = new HashMap<>();
		map.put("userId", userId);
		map.put("userPwd", userPwd);
		map.put("updatePwd", updatePwd);
		
		Members updateMem = new MembersServiceImpl().updatePwdMembers(map); 
		
		HttpSession session = request.getSession();
		if (updateMem == null) { 
			session.setAttribute("alertMsg", "비밀번호 수정에 실패하였습니다.");	
		} else { 
			session.setAttribute("alertMsg", "성공적으로 수정하였습니다.");
			session.setAttribute("loginUser", updateMem);
		}
		response.sendRedirect(request.getContextPath() + "/updateForm.me");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
