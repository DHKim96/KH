package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//공통 템플릿(매번 반복적으로 작성될 코드를 메소드로 정의)
public class JDBCTemplate {
	//모든메소드 싹다 static 메소드
	//싱글톤 패턴 : 메모리영역에 단 한번만 올려두고 매번 재사용하는 개념
	
	//1. Connection객체 생성(DB접속) 후 해당 Connection객체 반환\
	public static Connection getConnection() {
		
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("resources/driver.properties"));
			
			//1) JDBC Driver등록
			Class.forName(prop.getProperty("driver"));
			
			//2) Connection객체 생성
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// 2. commit처리해주는 메소드(Connection객체 전달 받아서)
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3. rollback처리해주는 메소드(Connection객체 전달 받아서)
	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//JDBC용 객체들을 전달받아서 반납처리해주는 메소드
	// 4. Statement관련 객체를 전달받아서 반납시켜주는 메소드
	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 5. Statement관련 객체를 전달받아서 반납시켜주는 메소드
	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 6. ResulSet 객체를 전달받아서 반납시켜주는 메소드
	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
