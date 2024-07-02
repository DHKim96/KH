package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/confirmPizza.do")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1) 인코딩처리 => 전달값 중 한글이 있을 수 있다. (post일떄만 / get일 때 해도 상관없음)
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청시 전달값 추출, 데이터 가공처리 => 변수나 객체에 넘겨받은 값을 기록한다.
		// request.getParamter("키") : 벨류값
		// request.getParamterValues("키") : ["벨류값","벨류값"...]
		// key가 존재하지 않으면 null
		
		
		//넘겨받은 값을 꺼내보자
		String name = request.getParameter("userName"); //"최지원"
		String phone = request.getParameter("phone"); // "010xxxxxxxx"
		String address = request.getParameter("address");// "경기도 xxxxxxx"
		String message = request.getParameter("message");// 빨리와주세요.~
		
		String pizza = request.getParameter("pizza"); //xx피자
		String[] toppings = request.getParameterValues("topping");// ["고구마무스", "치즈추가"...]
		String[] side = request.getParameterValues("side");
		String payment = request.getParameter("payment");
		
		// 3)요청처리 (db에 sql문 실행 > service > dao)
		
		int price = 0;
		switch(pizza) {
		case "콤비네이션": price += 5000; break;
		case "치즈피자": 
		case "포테이토피자": price += 6000; break;
		case "고구마피자": price += 7000; break;
		case "하와이안피자": price += 8000; break;
		}
		
		if (toppings != null) {
			for(int i = 0; i < toppings.length; i++) {
				switch(toppings[i]) {
				case "치즈추가" :
				case "고구마무스": price += 1500; break;
				case "치즈크러스트" :
				case "치즈바이트": price += 2000; break;
				case "베이컨/소세지" :
				case "파인애플": price += 2500; break;
				}
			}
		}
		
		if (side != null) {
			for(int i = 0; i < side.length; i++) {
				switch(side[i]) {
				case "콜라" :
				case "사이다": price += 2000; break;
				case "갈릭" :
				case "핫소스": price += 500; break;
				case "피클" :
				case "파마산": price += 700; break;
				}
			}
		}
		
		// 4)요청처리 후 사용자가 보게될 응답페이지(결제페이지) 만들어서 넘겨주기
		// 응답페이지(jsp)를 선택해서 포워딩
		// 단, 응답페이지에 필요한 데이터가 없다면 담아서 포워딩 할 것

		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("address", address);
		request.setAttribute("message", message);
		
		request.setAttribute("pizza", pizza);
		request.setAttribute("toppings", toppings);
		request.setAttribute("side", side);
		request.setAttribute("payment", payment);
		request.setAttribute("price", price);
		
		//응답할 뷰 선택
		RequestDispatcher view = request.getRequestDispatcher("views/pizza/pizzaPayment.jsp");
		//선택된 뷰가 사용자에게 보여지도록 포워딩
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
