package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

/*
 *  * DAO(Data Acess Object)
 *  	: DB에 직접적으로 접근해서 사용자의 요청에 맞는 SQL문 실행 후 결과 반환(JDBC)
 */
public class MemberDao {
	
	/**
	 * 사용자가 입력한 정보들을 DB 에 추가시켜주는 메소드
	 * @param m : 사용자가 입력한 값들이 담겨있는 Member 객체
	 * @return : insert문 실행 후 처리된 행(ROW)의 수
	 */
	public int insertMember(Connection conn, Member m) {
		// INSERT문 => 처리된 행(ROW)의 수 => 트랜잭션 처리
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
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
		
		String sql = "SELECT * FROM MEMBER ORDER BY USERNAME";
		
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
		
		String sql = "UPDATE MEMBER " // 띄어쓰기 주의할 것. 테이블명 뒤에 띄어쓰기안할시 SET 명령어에 붙어버려 오류 발생
					+ "SET USERPWD = ?,"
						+ "EMAIL = ?, "
						+ "PHONE = ?,"
						+ "ADDRESS = ?"
						+ "WHERE USERID = ?";
		
		
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

		Statement stmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID ="  + "'" + userId + "'";
		
		try {
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
		}
	
		return result;
	}

	public Member selectByUserId(Connection conn, String userId) {
		
		Member m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?" ;
		
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
		
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%' || ? || '%'";
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




























