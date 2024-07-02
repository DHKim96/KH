package com.kh.run;

import com.kh.view.MemberMenu;

public class Run {

	public static void main(String[] args) {
		/* cf) MVC 패턴 : SW 아키텍처 패턴
		 * M(Model)
		 * 	: 데이터 처리 담당
		 * 		데이터를 담기 위한 클래스(VO)
		 * 		데이터들이 보관된 공간(DB)
		 * 		직접적으로 접근해서 데이터 주고받기(DAO)
		 * V(View)
		 * 	: 화면 담당(사용자가 보게 되는 시각적 요소, 출력 및 입력)
		 * C(Controller)
		 * 	: 사용자의 요청을 처리해주는 역할 (service)
		 * 
		 */
		
		new MemberMenu().mainMenu();
		
		
	
		
	}

}
