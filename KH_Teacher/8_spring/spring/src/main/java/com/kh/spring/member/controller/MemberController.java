package com.kh.spring.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.service.MemberService;

@Controller
public class MemberController {
	
	
//	private MemberService memberService = new MemeberServiceImpl();
	/*
	 * 기존 객체 생성 방식
	 * 객체간 결합도가 높아짐(소스코드 수정이 일어날 경우 하나하나 전부 다 바꿔줘야한다.)
	 * 서비스가 동시에 매우 많은 횟수요청이 될 경우 그만큼 객체가 생성된다.
	 * 
	 * Spring의 DI(Dependency Injection)를 이용한 방식
	 * 객체를 생성해서 주입해준다.
	 * new라는 객체생성 키워드없이 @Autowired라는 어노테이션만으로 사용해야한다.
	 * 
	 * ----------------------------------------------------------------
	 * 
	 * 필드 주입 방식
	 * 스프링 컨테이너가 객체를 생성한 후, @Autowired 어노테이션이 붙은 필드에 의존성을 주입한다.
	 * 
	 * 생성자주입방식
	 * 스프링컨테니어가 객체를 생성할 때 생성자를 통해서 필요한 의존성을 주입한다.
	 * 
	 * 필드주입방식 -> 생성자주입방식 : 주입시점차이로인해 객체가 완전히 초기화된 상태로 사용할 수 있음을 보장하고
	 * 테스트 가능성과 유지보수성이 증가한다.
	 **/
	
	
	private final MemberService memberService;
	
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	public MemberController(MemberService memberService, BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.memberService = memberService;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
	}
	
	
	/*
	 * Spring에서 파라미터를 받는 방법
	 * 1. HttpServletRequest를 활용해서 전달받기(jsp/servlet방식)
	 * 해당 메소드의 매개변수로 HttpServletRequest를 작성해두면
	 * 스프링컨테이너가 해당 메소드를 호출시 자동으로 객체생성해서 매게변수로 주입해준다.
	 */
	
//	@RequestMapping("login.me")
//	public String loginMember(HttpServletRequest request) {
//		String userId = request.getParameter("userId");
//		String userPwd = request.getParameter("userPwd");
//		
//		System.out.println("userId : " + userId);
//		System.out.println("userPwd : " + userPwd);
//		
//		return "main";
//		///WEB-INF/views/main.jsp
//	}
	
//	/*
//	 * 2. @RequestParam 어노테이션을 이용하는 방법
//	 * request.getParameter("키")로 벨류를 추출하는 역할을 대신해주는 어노테이션
//	 * value속성의 벨류로 jsp에서 작성했던 name속성값을 담으면 알아서 해당 매개변수로 받아올 수 있다.
//	 * 만약, 넘어온 값이 비어있는 형태라면 defaultValue속성으로 기본값을 지정할 수 있다.
//	 * 
//	 * @RequestParam 생략이 가능하다.
//	 */
//	@RequestMapping("login.me")
//	public String loginMember(@RequestParam(value="userId", defaultValue="testId") String id,@RequestParam String userPwd) {
//		
//		System.out.println("userId : " + id);
//		System.out.println("userPwd : " + userPwd);
//		
//		return "main";
//		///WEB-INF/views/main.jsp
//	}
	
	/*
	 * 3. 커맨드 객체 방식
	 * 
	 * 해당 메소드의 매개변수로
	 * 요청시 전닭밧을 담고자하는 VO 클래스의 타입을 세팅 후
	 * 요청시 전달값의 키값(jsp의 name속성값)을 vo클래스에 담고자하는 필드명으로 작성
	 */
	
//	@RequestMapping("login.me")
//	public String loginMember(Member m) {
//		
//		System.out.println("userId : " + m.getUserId());
//		System.out.println("userPwd : " + m.getUserPwd());
//		
//		Member loginUser = memberService.loginMember(m);
//		
//		if(loginUser == null) {
//			System.out.println("로그인 실패");
//		} else {
//			System.out.println("로그인 성공");
//		}
//		return "main";
//		///WEB-INF/views/main.jsp
//	}
	
	
	/*
	 * 요청처리 후 응답데이터를 담고 응답페이지로 포워딩 또는 url재요청 처리하는 방법
	 * 
	 * 1. 스프링에서 제공하는 Model객체를 이용하는 방법
	 * 포워딩할 응답뷰로 전달하고자하는 데이터를 맵형식(k-v)으로 담을 수 있는 영역
	 * Model객체는 reqesutScope
	 * request.setAttribute() -> model.addAttribute()
	 */
	
//	@RequestMapping("login.me")
//	public String loginMember(Member m, Model model, HttpSession session) {	
//		Member loginUser = memberService.loginMember(m);
//		
//		if(loginUser == null) { //로그인 실패 => 에러문구를 requestScope에 담고 에러페이지로 포워딩
//			model.addAttribute("errorMsg", "로그인실패");
//			
//			// /WEB-INF/views/common/errorPage.jsp
//			return "/common/errorPage";
//		} else { // 로그인 성공 => sessionScope에 로그인유저 담아서 메인으로 url재요청
//			session.setAttribute("loginUser", loginUser);
//			return "redirect:/";
//		}
//	}
	
	//2. 스프링에서 제공하는 ModelAndView객체사용
	
	@RequestMapping("login.me")
	public ModelAndView loginMember(Member m, ModelAndView mv, HttpSession session, String saveId, HttpServletResponse response) {	
		//암호화 전
//		Member loginUser = memberService.loginMember(m);
//		
//		if(loginUser == null) { //로그인 실패 => 에러문구를 requestScope에 담고 에러페이지로 포워딩
//			//model.addAttribute("errorMsg", "로그인실패");
//			mv.addObject("errorMsg", "로그인실패");
//			
//			// /WEB-INF/views/common/errorPage.jsp
//			//return "/common/errorPage";
//			mv.setViewName("common/errorPage");
//		} else { // 로그인 성공 => sessionScope에 로그인유저 담아서 메인으로 url재요청
//			session.setAttribute("loginUser", loginUser);
//			//return "redirect:/";
//			mv.setViewName("redirect:/");
//		}
		
		
		
		//암호화 후
		//Member m의 id => 사용자가 입력한 아이디
		//		 m의 pwd => 사용자가 입력한 pwd(평문)
		
		Member loginUser = memberService.loginMember(m);
		
		// loginUser id => 아이디로 db에서 검색해온 id
		//loginUser pwd => db에 기록된 암호화된 비밀번호
		
		
		//bcryptPasswordEncoder객체의 matches()
		//matches(평문, 암호문)을 작성하면 내부적으로 복호화작업 후 비교가 이루어짐
		//두 구문이 일치하면 true를 반환 일치하지않으면 false 반환
		
		bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd());
		
		if (loginUser == null) { // 아이디가 없는 경우
			mv.addObject("errorMsg", "일치하는 아이디를 찾을 수 없습니다.");
			
			mv.setViewName("common/errorPage");
			
			//비밀번호가 다른경우
		} else if (!bcryptPasswordEncoder.matches(m.getUserPwd(), loginUser.getUserPwd())){ 
			mv.addObject("errorMsg", "비밀번호가 일치하지 않습니다.");
			mv.setViewName("common/errorPage");
		} else { // 성공
			Cookie ck = new Cookie("saveId", loginUser.getUserId());
			if (saveId == null) {
				ck.setMaxAge(0);
			}
			response.addCookie(ck);
			
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");
		}
		
		return mv;
	}
	
	@RequestMapping("logout.me")
	public String logoutMember(HttpSession session){
		//로그아웃 -> session에서 loginUser 삭제, 만료
		//session.invalidate();
		session.removeAttribute("loginUser");
		
		return "redirect:/";
	}
	
	@RequestMapping("enrollForm.me")
	public String enrollForm() {
		return "member/memberEnrollForm";
	}
	
	
	/*
	 * ajax요청에 대한 응답을 위한 controller에는 @ResponseBody어노테이션을 작성해줘야한다.
	 * 기본적인 세팅이 jsp응답으로 되어있기 때문에 @ResponseBody을작성해주면
	 * 반환값을 http응답 객체에 직접 작성하겠다라는 의미를 가지고있다.
	 */
	//idCheck ajax요청을 받아줄 controller
	@ResponseBody
	@RequestMapping("idCheck.me")
	public String idCheck(String checkId) {
		int result = memberService.idCheck(checkId);
		
		if (result > 0) {// 이미존재한다면
			return "NNNNN";
		} else { //존재하지않는다면
			return "NNNNY";
		}
		
		//return memberService.idCheck(checkId) > 0 ? "NNNNN" : "NNNNY";
	}
	
	@RequestMapping("insert.me")
	public String insertMember(Member m, HttpSession session, Model model) {
		/*
		 * 1. 한글깨짐문제 발생 => web.xml에 스프링에서 제공하는 인코딩 필터 등록
		 * 2. 나이를 입력하지 않을 경우 int자료형에 빈문자열을 대입해야하는 경우가 발생한다.
		 * => 400에러 방생  Member의 age필드 자료형을 String으로 변경해주면 된다.
		 * 3. 비밀번호가 사용자 입력 그대로 전달이 된다(평문)
		 * Bcrypt방식을 이용해서 암호화를 한 후 저장을 하겠다.
		 * => 스프링시큐리티에서 제공하는 모듈을 이용<pom.xml에 라이브러리 추가>
		 */
		
		//암호화작업
		String encPwd = bcryptPasswordEncoder.encode(m.getUserPwd());
		
		m.setUserPwd(encPwd);
		
		int result = memberService.insertMember(m);
		
		if (result > 0) {
			session.setAttribute("alertMsg", "성공적으로 회원가입이 완료되었습니다.");
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "회원가입 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping("myPage.me")
	public String myPage() {
		return "member/myPage";
	}
	
	@RequestMapping("update.me")
	public String updateMember(Member m, HttpSession session, Model model) {
		
		int result = memberService.updateMember(m);
		
		if (result > 0) {
			session.setAttribute("loginUser", memberService.loginMember(m));
			session.setAttribute("alertMsg", "회원정보 수정 성공");
			return "redirect:/myPage.me";
		} else {
			model.addAttribute("errorMsg", "회원정보 수정 실패");
			return "common/errorPage";
		}
		
	}
	
	@RequestMapping("delete.me")
	public String deleteMember(Member m, HttpSession session) {
		
		//1. 암호화된 비밀번호 가져오기
		String encPwd = ((Member)session.getAttribute("loginUser")).getUserPwd();
		
		//2. 비밀번호 일치/불일치 판단후
		if (bcryptPasswordEncoder.matches(m.getUserPwd(), encPwd)) {
			//일치 -> 탈퇴처리 -> session에서 제거 -> 메인페이지로
			int result = memberService.deleteMember(m.getUserId());
			
			if(result > 0) {
				session.removeAttribute("loginUser");
				session.setAttribute("alertMsg", "회원탈퇴가 성공적으로 이루어졌습니다.");
				return "redirect:/";
			} else {
				session.setAttribute("alertMsg", "탈퇴처리 실패");
				return "redirect:/myPage.me";
			}
			
		} else {
			//불일치 -> alertMsg: 비밀번호 다시 입력 -> 마이페이지
			session.setAttribute("alertMsg", "비밀번호를 다시 확인해주세요");
			return "redirect:/myPage.me";
		}
	}
}
