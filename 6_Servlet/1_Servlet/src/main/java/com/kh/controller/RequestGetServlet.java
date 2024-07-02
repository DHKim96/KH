package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 같은 경우 반드시 contextPath뒤에 작성되어야한다.
 * http://localhost:8888/1_Servlet/test1.do
 */
@WebServlet("/test1.do")
public class RequestGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get방식으로 요청시 해당 doGet메소드가 저절로 호출된다.
		//System.out.println("GET요청 정상적으로 받았습니다.");
		
		/**
		 * 첫번째 매개변수인 request에는 요청시 전달된 내용들이 담겨있음(사용자가 입력한 값, 요청방식, 요청자의 ip주소 등)
		 * 두번째 매개변수인 response는 요청 처리 후 응답할 때 사용되는 객체
		 * 
		 * 요청 처리를 위해서 요청시 전달된 값들 추출
		 * request의 parameter영역안에 존재
		 * request.getPrameter("키")
		 */
		
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
		
		// 위의 결과에따라 응답페이지(html)만들어서 전송
		//즉, 여기 Java코드 내에 사용자가 보게될 응답 html 구문을 작성
		
		//장점 : java코드 내에 작성하기 때문에 반복문이나 조건문, 유용한메소드 같은 것들을 활용하여 동적인 응답을 내릴 수 있다.
		//단점 : 불편, 복잡, 혹시라도 차후에 html을 수정한다면 java코드를 수정하는 것이기 때문에 수정된 내용을 다시 반영시키고자 
		//      서버를 재실행 해야된다.
		
		// response객체를 통해 사용자에게 html(응답화면) 전달
		// 1) 이제부터 내가 출력할 내용은 문서형태의 html이고 문자셋은 utf-8이다 -> 선언
		response.setContentType("text/html; charset=utf-8");
		
		//2)응답하고자하는 사용자(요청했던 사람)와의 스트림(클라이언트와의 통로)을 생성
		PrintWriter out = response.getWriter();
		
		//3) 위에서가져온 스트림을 통해서 응답html구문을 한줄씩 출력
		out.println("<html>");
		
		out.println("<head>");
		out.println("<style>");
		out.println("</style>");
		out.println("</head>");
		
		
		out.println("<body>");
		out.println("<h2>개인정보응답화면</h2>");
		out.printf("<span>%s</span>님은", name);
		out.printf("<span>%d</span>살이며", age);
		out.printf("<span>%s</span>에 삽니다", city);
		
		out.println("성별은 ");
		if (gender == null) {
			out.println("선택하지 않았습니다.");
		} else {
			if (gender.equals("M")) {
				out.println("<span>남자입니다.</span>");
			} else {
				out.println("<span>여자입니다.</span>");
			}
		}
		
		
		out.println("</body>");
		
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
