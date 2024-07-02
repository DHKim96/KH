package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public int insertMember(Member m) {
		// INSERT문 => 처리된 행(ROW)의 수 => 트랜잭션 처리
		
		// 필요한 변수들 먼저 세팅
		int result = 0; // 처리된 결과(처리된 행 수)를 받아줄 변수
		
		Connection conn = null; // 연결된 db 정보 담는 객체
		PreparedStatement pstmt = null; // 완성된 sql문 전달해서 실행 후 결과 받는 객체
		
		// 실행할 sql문
		/*
		 * INSERT INTO MEMBER
		 * VALUES(SEQ_USERNO.NEXTVAL, 'user', 'pass01', '홍길동', 
		 * 			NULL, 23 ,'user01@iei.or.kr',
		 *  		'01022222222', '서울', '등산, 영화보기', '2021-08-07');
		 */
		
//		String sql = "INSERT INTO MEMBER VALUES"
//				+ "(SEQ_USERNO.NEXTVAL" + 
//				"'" + m.getUserId() + "', " +
//				"'" + m.getUserPwd() + "', " +
//				"'" + m.getUserName() + "', " +
//				"'" + m.getGender() + "', " +
//					  m.getAge() + "', " +
//				"'" + m.getEmail() + "', " +
//				"'" + m.getPhone() + "', " +
//				"'" + m.getAddress() + "', " +
//				"'" + m.getHobby() + "', " +
//				"SYSDATE" +											
//				")";
// => 노가다 대신 PreparedStatement.set~ 메서드 사용 가능
		
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			// 1) JDBC Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2) Connection 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3) Statement 생성
			pstmt = conn.prepareStatement(sql); // 아직 미완성 sql문임 why '?'를 채워줘야하기에
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			// 4,5) sql문 전달해서 실행 후 값 받아오기
			
			result = pstmt.executeUpdate();
			
			// 6 ) 트랜잭션 처리
			if (result > 0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
		return result;
	}

	/**
	 * DB로부터 조회한 결과값들을 LIST 객체에 담는 메소드
	 * @return
	 */
	public ArrayList<Member> selectList() {
		// select문(여러 행 조회) -> ResultSet 객체 -> ArrayList<Member>에 담기
		
		// 필요한 변수 세팅
		ArrayList<Member> list = new ArrayList<Member>(); // 비어있음
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null; // select문 실행시 조회된 결과값들이 최초로 담기는 공간

		// 실행할 SQL문
		String sql = "SELECT * FROM MEMBER";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while (rset.next()) {
				Member m = new Member();
				
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress( rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				// 현재 참조하고 있는 행에 대한 모든 컬럼을 한 Member객체에 담기
				
				list.add(m);
			}
			
			// 반복문이 끝난 시점
			// 조회된 데이터가 없었다면 리스트는 비어있음
			// 조회된 데이터가 있다면 전부 리스트에 담겨있음
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int updateMember(Member m) {
		
		int result = 0;
		
		Connection conn = null;
		
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
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

			pstmt = conn.prepareStatement(sql); // 아직 미완성 sql문임 why '?'를 채워줘야하기에

			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();

			if(result > 0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 사용자가 입력한 정보를 바탕으로 해당 회원을 DB에서 삭제시켜주는 메소드
	 * @param userId를 받아서 DB에서 해당 회원 정보를 삭제
	 * @return
	 */
	public int deleteMember(String userId) {
		
		int result = 0;
		
		Connection conn = null;
		
		Statement stmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID ="  + "'" + userId + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}




























