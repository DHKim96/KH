package com.kh.common;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AjaxTestController
 */
@WebServlet("/jqAjax.do")
public class AjaxTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTestController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		//여러개를 응답하고 싶지만 할 수 없다.
//		response.getWriter().print(name);
//		response.getWriter().print(age);
		
		/*
		 * JSON(자바스크립트에서 객체를 표기했던 방법, 실제로는 파일 형식을 의미)
		 * AJAX 통신을 통한 데이터 전송 시 가장 많이 사용하는 데이터 포맷
		 * 
		 * {key : value, key : value, ...} => JSONObject
		 * [value, value, value, ...] => JSONArray
		 */
		
//		JSONArray jArr = new JSONArray();
//		
//		jArr.add(name);
//		jArr.add(age);
//		
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(jArr);
		
//		JSONObject jObj = new JSONObject(); // {key : value}
//		jObj.put("name", name); // {name : 김개똥}
//		jObj.put("age", age); // {name : 김개똥, age : 21}
//	
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(jObj);
//		
		ArrayList<Member> members = new ArrayList<>();
		members.add(new Member(1, "김개똥", "01011112222"));
		members.add(new Member(2, "최개똥", "01012112222"));
		members.add(new Member(3, "이개똥", "01013112222"));
		
//		JSONArray jArr = new JSONArray();
//		
//		for(Member m : members) {
//			JSONObject jObj = new JSONObject();
//			jObj.put("userNo", m.getUserNo());
//			jObj.put("userName", m.getUserName());
//			jObj.put("phone", m.getPhone());
//			
//			jArr.add(jObj);
//		}
//		
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(jArr);
		
		response.setContentType("text/html; charset=UTF-8");
		
		new Gson().toJson(members, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
