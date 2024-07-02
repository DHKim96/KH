package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.MemberDao;
import com.kh.model.vo.Member;
import com.kh.service.MemberService;
import com.kh.view.MemberMenu;

//Controller : View를 통해서 사용자가 요청한 기능에 대해서 처리하는 담당
//			   해당 메소드로 전달된 데이터[가공처리후] dao로 전달하며 호출
// 			   dao로부터 반환받은 결과 성공인지 실패인지 판단 후 응답화면 결정(view메소드 호출)
public class MemberController {
	/*
	 * 사용자의 추가요청을 처리해주는 메소드
	 * @param userId ~ hobby : 사용자가 이볅했던 정보들이 담겨있는 매게변수
	 * */
	public void insertMember(String userId, String userPwd, String userName, String gender,
			String age, String email, String phone, String address, String hobby) {
		
		//view로부터 전달받은 값을 바로 dao쪽으로 전달x
		// 어딘가(Member객체(vo))에 담아서 전달
		
		//방법1) 기본생성자로 생성 후 각 필드마다 setter를 이용해서 데이터 저장
		//방법2) 매개변수 있는 생성자로 전부 전달해서 생성
	
		Member m = new Member(userId, userPwd, userName, gender, 
				Integer.parseInt(age), email, phone, address, hobby); 
		
		int result = new MemberService().insertMember(m);
		
		if (result > 0) { // insert가 성공적으로 완료되었다
			//성공화면
			new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
		} else { // insert가 실패했다.
			//실패화면
			new MemberMenu().displayFail("회원추가를 실패하였습니다.");
		}
	}
	
	/**
	 * 사용자모두를 조회하는 메소드
	 */
	public void selectList() {
		ArrayList<Member> list = new MemberService().selectList();
		
		//조회된 결과에 따라서 사용자가 보게될 응답화면 지정
		if(list.isEmpty()) { // list가 비어있는 경우
			new MemberMenu().displayNoData("전체 조회 결과가 없습니다.");
		} else { // 조회된 데이터가 있을 경우
			new MemberMenu().displayMemberList(list);
		}
	}
	
	public void updateMember(String userId,String userPwd,
		String email,String phone,String address) {
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		
		int result = new MemberService().updateMember(m);
		
		if (result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 정보 변경되었습니다.");
		} else {
			new MemberMenu().displayFail("회원정보 변경에 실패하였습니다.");
		}
	}
	
	public void deleteMember(String userId) {
		int result = new MemberService().deleteMember(userId);
		
		if (result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원 정보 삭제되었습니다.");
		} else {
			new MemberMenu().displayFail("회원정보 삭제에 실패하였습니다.");
		}
	}
	
	/**
	 * 사용자의 아이디로 회원정보를 검색요청을 처리해주는 메소드
	 * @param userId : 사용자가 직접입력한 검색하고자하는 회원 아이디
	 */
	public void selectByUserId(String userId) {
		Member m = new MemberService().selectByUserId(userId);
		System.out.println(m);
		if (m == null) {
			new MemberMenu().displayNoData(userId + "에 해당하는 조회결과가 없습니다.");
		} else {
			new MemberMenu().displayMember(m);
		}
	}
	
	/**
	 * 이름으로 키워드 검색 요청시 처리해주는 메소드
	 * @param keyword: 사용자가 입력한 검색할 키워드
	 */
	public void selectByUserName(String keyword) {
		ArrayList<Member> list = new MemberService().selectByUserName(keyword);
		if (list.isEmpty()) {
			new MemberMenu().displayNoData(keyword + "에 해당하는 검색 결과가 없습니다.");
		} else {
			new MemberMenu().displayMemberList(list);
		}
	}
	
	
	
}
