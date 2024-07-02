package com.kh.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.model.vo.Person;

/**
 * Servlet implementation class OperationServlet
 */
@WebServlet("/operation.do")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("big", 10);
		request.setAttribute("small", 3);
		
		request.setAttribute("sOne", "");
		request.setAttribute("sTwo", "");
		request.setAttribute("sThree", "HI");
		
		request.setAttribute("pOne", new Person("", 20, ""));
		request.setAttribute("pTwo", null);
		
		ArrayList<String> list1 = new ArrayList<>(); //텅빈리스트
		request.setAttribute("aOne", list1);
	
		ArrayList<String> list2 = new ArrayList<>(); 
		list2.add("좋은아침입니다.");
		request.setAttribute("aTwo", list2);
	
		request.getRequestDispatcher("views/1_EL/02_eloperation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
