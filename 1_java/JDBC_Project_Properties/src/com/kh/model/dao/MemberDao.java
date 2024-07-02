package com.kh.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

/*
 *  * DAO(Data Acess Object)
 *  	: DB에 직접적으로 접근해서 사용자의 요청에 맞는 SQL문 실행 후 결과 반환(JDBC)
 */
public class MemberDao {
	
	/*
	 *	기존 방식
	 *		: DAO 클래스에 사용자가 요청할 때마다 실행해야하는 SQL문을 자바 소스코드 내에 명시적으로 작성 => 정적 코딩 방식
	 *	> 문제점
	 *		: SQL문을 수정해야할 경우 자바소스코드를 수정해야함 => 수정된 내용을 반영하고자 한다면 프로그램을 종료 후 재구동해야함 
	 *	> 해결 방법
	 *		: SQL문들을 별도로 관리하는 외부 파일(.xml)로 만들어서 실시간으로 그 파일에 기록된 sql문을 읽어들여서 실행 => 동적 코딩 방식	
	 */
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 사용자가 입력한 정보들을 DB 에 추가시켜주는 메소드
	 * @param m : 사용자가 입력한 값들이 담겨있는 Member 객체
	 * @return : insert문 실행 후 처리된 행(ROW)의 수
	 */
	public int insertMember(Connection conn, Member m) {
		// INSERT문 => 처리된 행(ROW)의 수 => 트랜잭션 처리
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	/**
	 * DB로부터 조회한 결과값들을 LIST 객체에 담는 메소드
	 * @return
	 */
	public ArrayList<Member> selectList(Connection conn) {
		
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
			
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}

	public int updateMember(Connection conn, Member m) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		/*
		 * update member 
		 * set userPwd = 'xx'
		 * 	  ,email = '~'
		 * 	  ,phone = '~'
		 *    ,address = '~'
		 * where userId = 'xxx';   
		 */
		
		String sql = prop.getProperty("updateMember");
		
		
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, m.getUserPwd());
				pstmt.setString(2, m.getEmail());
				pstmt.setString(3, m.getPhone());
				pstmt.setString(4, m.getAddress());
				pstmt.setString(5, m.getUserId());
				
				result = pstmt.executeUpdate();
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			
		return result;
	}
	
	/**
	 * 사용자가 입력한 정보를 바탕으로 해당 회원을 DB에서 삭제시켜주는 메소드
	 * @param userId를 받아서 DB에서 해당 회원 정보를 삭제
	 * @return
	 */
	public int deleteMember(Connection conn, String userId) {
		
		int result = 0;

		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
	
		return result;
	}

	public Member selectByUserId(Connection conn, String userId) {
		
		Member m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectByUserId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				m = new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
	}

	public ArrayList<Member> selectByUserName(Connection conn, String keyword) {
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectByUserName");
		// like 쓸 때 중간에 물음표가 들어가면 setString 메소드 사용시 ''이 붙어서 넘어가버림 따라서 연결연산자 사용
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Member m = new Member();
				
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
}




























