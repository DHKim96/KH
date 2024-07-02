package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.vo.Member;
import com.kh.service.MemberService;
import com.kh.view.MemberMenu;

/*
 * * Controller
 * 		: View 를 통해서 사용자가 요청한 기능에 대해 처리하는 담당
 * 		  해당 메소드로 전달된 데이터를 가공처리 후 DAO로 전달하며 호출 
 * 		  DAO 로부터 반환받은 결과의 성패 판단 후 응답화면 결정(view 메소드 호출)	
 */
public class MemberController {

	/*
	 *  사용자의 추가 요청을 처리해주는 메소드
	 *  @param userId ~ hobby : 사용자가 입력했던 정보들이 담겨있는 매개변수
	 */
	
	public void insertMember(String userId, String userPwd, String userName,
			String gender, String age, String email,  String phone, String ddress, 
			String hobby) {
	// View로부터 전달받은 값을 바로 DAO 전달 x
		// 어딘가(Member 객체(VO))에 담아서 전달
		
		/*
		 * 가공 방법 
		 * 방법 1. 기본생성자로 생성 후 각 필드마다 setter 메서드 사용해서 저장 
		 * 방법 2. 매개변수 있는 생성자로 전부 전달해서 생성  
		 */
		
		Member m = new Member(userId,  userPwd,  userName, gender, Integer.parseInt(age),  email,  phone,  ddress, hobby);
	
		int result = new MemberService().insertMember(m);
		
		if (result > 0 ) { // 성공 화면
			new MemberMenu().displaySuccess("성공적으로 회원이 추가됐습니다.");
		}
		else { // 실패 화면
			new MemberMenu().displayFail("회원 추가에 실패했습니다.");
		}
		
	}


	/**
	 * 사용자 모두를 조회하는 메소드
	 */
	public void selectList() {
		ArrayList<Member> list = new MemberService().selectList();
		
		// 조회된 결과에 따라 사용자가 보게될 응답화면 지정
		if(list.isEmpty()) { // list 비어있을 경우
			new MemberMenu().displayNoData("조회 결과가 없습니다.");
		}
		else { // 조회된 데이터가 있을 경우
			new MemberMenu().displayMemberList(list);
		}
	}

	public void updateMember(String userId, String userPwd, String email, String phone, String address) {
		Member m = new Member();
		
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		
		int result = new MemberService().updateMember(m);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 정보 수정 완료했습니다.");
		}
		else {
			new MemberMenu().displayFail("회원 정보 수정 실패했습니다");
		}
		
	}
	
	public void deleteMember(String userId) {
		
		int result = new MemberService().deleteMember(userId);
		
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 탈퇴에 성공했습니다");
		}
		else {
			new MemberMenu().displayFail("회원 탈퇴 실패했습니다");
		}
	}

	/**
	 * 사용자의 아이디로 회원정보를 검색 요청 처리해주는 메소드
	 * @param inputMemberId : 사용자가 직접 입력한 검색하고자 하는 회원 아이디
	 */
	public void selectByUserId(String userId) {
		Member m = new MemberService().selectByUserId(userId);
		
		if (m == null ) {
			new MemberMenu().displayNoData(userId + "에 해당하는 조회 결과가 없습니다.");
		}
		else {
			new MemberMenu().displayMember(m);
		}
	}

	
	/**
	 * 이름으로 키워드 검색 요청시 처리해주는 메소드
	 * @param inputKeyword : 사용자가 입력한 검색할 키워드
	 */
	public void selectByUserName(String keyword) {
		ArrayList<Member> list = new MemberService().selectByUserName(keyword);
		
		if(list.isEmpty()) {
			new MemberMenu().displayFail(keyword + "에 해당하는 검색 결과가 없습니다.");
		}
		else {
			new MemberMenu().displayMemberList(list);
		}
	}



















}
