package com.kh.common;
// 공통 템플릿(매번 반복적으로 작성될 코드를 메소드로 정의)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	// 모든 메소드 전부 static 메소드로 만듦
	/*
	 *  싱글톤 패턴
	 *  	: 메모리 영역에 단 한 번만 올려두고 매번 재사용하는 디자인 패턴
	 */

	// 1. Connection 객체 생성(DB 접속) 후 해당 Connection 객체 반환
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return conn;
	}
	
	// 2. commit 처리해주는 메소드(Connection 객체 전달 받아서)
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
			// isClosed() 가 트루라는 것은 커넥션 객체가 반납이 됐음을 의미
			// 따라서 반납이 되지 않아야 commit 할 수 있으므로 이를 처리해줘야 함
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 3. rollback 처리
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
			// isClosed() 가 트루라는 것은 커넥션 객체가 반납이 됐음을 의미
			// 따라서 반납이 되지 않아야 rollback 할 수 있으므로 이를 처리해줘야 함
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// JDBC용 객체들을 전달받아서 반납처리해주는 메소드
	// 4. Statement 관련 객체를 전달받아서 반납해주는 메소드
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
			// isClosed() 가 트루라는 것은 커넥션 객체가 반납이 됐음을 의미
			// 따라서 반납이 되지 않아야 rollback 할 수 있으므로 이를 처리해줘야 함
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 5. Connection 객체 전달받아서 반납해주는 메소드
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
			// isClosed() 가 트루라는 것은 커넥션 객체가 반납이 됐음을 의미
			// 따라서 반납이 되지 않아야 rollback 할 수 있으므로 이를 처리해줘야 함
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 6. ResultSet 객체 전달받아서 반납
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
			// isClosed() 가 트루라는 것은 커넥션 객체가 반납이 됐음을 의미
			// 따라서 반납이 되지 않아야 rollback 할 수 있으므로 이를 처리해줘야 함
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
