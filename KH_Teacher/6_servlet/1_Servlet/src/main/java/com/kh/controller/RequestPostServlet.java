package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/test2.do")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 호출완료");
		
		//POST방식 요청같은 경우는
		//데이터를 추출하기 [전!]에 인코딩설정을 해야함
		request.setCharacterEncoding("UTF-8");
		
		//요청시 전달된 값들은 request의 parameter영역에 담겨있다.
		String name = request.getParameter("name"); // "최지원" | ""
		String gender = request.getParameter("gender"); // "M" | "W" | null
		int age = Integer.parseInt(request.getParameter("age")); // "23" => 23
		String city = request.getParameter("city"); // "경기", "서울"등등
		double height = Double.parseDouble(request.getParameter("height")); // "170" => 170.0000
		
		//체크박스와 같이 복수의 벨류값들을 추출하고자 할때
		String[] foods = request.getParameterValues("food"); // ["한식","분식"]; | null
		
		System.out.println("name : " + name);
		System.out.println("gender : " + gender);
		System.out.println("age : " + age);
		System.out.println("city : " + city);
		System.out.println("height : " + height);

		if (foods == null) {
			System.out.println("foods: 없음");
		} else {
			System.out.println("foods : " + String.join("/", foods));
		}
		
		//추출한 값들을 가지고 요청처리를 해야됨(db와 상호작용)
		//>Service > Dao > DB sql로 실행
		
		/* int result = new MemberService().insertMember(name, gender, age, city, height, foods);
			if (result > 0) {
				// 성공 -> 성공페이지응답
			} else {
				// 실패 -> 실패페이지응답
			}
		*/
		
		//요청처리가 다 되었다는 가정하에 사용자가 보게될 응답html 작성
		
		//순수 Servlet방식 : java코드 내에 html을 기술
		//JSP(Java Server Page) 방식 : html내에 java코드를 쓸 수 있음.
		
		//응답페이지를 만드는 과정을 jsp에 위임(떠넘긴다)
		//단, 응답화면(jsp)에서 필요로하는 데이터들을 차곡차곡담아서 전달해줘야한다.
		// 데이터들을 담기위한 공간 == request의 attribute영역
		// request.setAttribute("키", 벨류)
		
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("city", city);
		request.setAttribute("height", height);
		request.setAttribute("gender", gender);
		request.setAttribute("foods", foods);
		
		//응답하고자하는 뷰(jsp) 선택해서 넘겨줌 => RequestDispatcher객체생성
		RequestDispatcher view = request.getRequestDispatcher("/views/responsePage.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 호출완료");
		doGet(request, response);
	}

}
