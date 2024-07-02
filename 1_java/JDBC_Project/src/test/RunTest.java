package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunTest {
	/*
	 * JDBC를 사용하기 위해서는 자바 프로젝트에 JDBC 드라이버를 추가해줘야 함.
	 * 
	 * * JDBC용 객체
	 * 		1.Connection
	 * 			: DB 의 연결 정보를 담고 있는 객체
	 * 		2.[Prepared]Statement
	 * 			: 연결된 DB 에 SQL문을 전달해서 실행하고 결과를 받아내는 객체
	 * 		3. ResultSet
	 * 			: SELECT문 실행 후 조회된 결과물들을 담는 객체
	 * 	
	 * * JDBC 과정(순서)
	 * 		1. JDBC Driver 등록
	 * 			: 해당 DBMS(오라클)가 제공하는 클래스 등록
	 * 		2. Connection 생성
	 * 			: 연결하고자 하는 DB 정보를 입력해서 해당 DB와 연결할 수 있는 객체 생성
	 * 		3. Statement 생성
	 * 			: Connection 객체 이용하여 생성(SQL문 실행하고 결과 받는 객체)
	 * 		4. SQL문 전달하면서 실행
	 * 			: Statement 객체 이용해 SQL문 실행
	 * 		5. 결과받기
	 * 			: SELECT문 실행(6-1) => ResultSet 객체(조회된 결과 담음).
	 			  DML(INSERT, UPDATE, DELETE) 실행(6-2) => 행 수 반환(int형)
	 * 		6-1. ResultSet 객체에 담긴 데이터 하나씩 추출하여 옮겨담음
	 * 			: ArrayList에 담기
	 * 		6-2. 트랜잭션 처리
	 * 			: 성공했다면 commit, 실패시 rollback 실행
	 * 		7. JDBC 객체 사용 후에는 반드시 자원 반납
	 * 			: close. 단, 생성된 역순으로
	 */
	
	public static void main(String[] args) {
//		// 1. 각자의 pc(localhost)에 jdbc 계정 연결 후 test 테이블에 insert 해보자
//		// insert => 처리된 행의 수 반환(int) => 트랜잭션 처리
//		
//		// 필요한 변수 세팅
//		int result = 0; // 결과(처리된 행 수) 받아줄 변수
//		Connection conn = null; // DB의 연결 정보 보관할 객체
//		Statement stmt = null; // SQL문 전달해서 실행 후 결과 받는 객체
//		
//		// 실행할 SQL문(완전한 상태로 만들어두기)(맨 뒤에 세미콜론 없어야 함!!-복붙시 주의할 것)
//	
//		Scanner sc = new Scanner(System.in);
//		System.out.print("번호 : ");
//		int num = sc.nextInt();
//		sc.nextLine();
//		
//		System.out.print("이름: ");
//		String name = sc.nextLine();
//		
//		String sql = "INSERT INTO TEST VALUES(" + num + ", '" + name + "', SYSDATE)";
//
//		
//			try {
//				
//				// 1) JDBC Driver 등록
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				// 위 코드에서 컴파일 에러 발생 시 ojdbc6.jar 파일 추가하지 않거나 오타 발생한 것
//				System.out.println("OracleDriver 등록성공");
//				
//				// 2) Connection 생성(url, 계정명, 비밀번호)
//				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
//				
//				// 3) Statement 생성
//				stmt = conn.createStatement();
//				
//				// 4, 5) SQL문 전달하면서 실행 후 결과 받기(처리된 행 수)
//				result = stmt.executeUpdate(sql);
//				//sql문이 insert 명령어이기 때문에 int형 result 로 받음
//				
//				// 내가 실행할 SQL문이 DML일 경우 stmt.executeUpdate(SQL문) : int
//				// 내가 실행할 SQL문이 SELECT문일 경우 stmt.executeQuery(SELECT문) : ResultSet
//				
//				// 6) 트랜잭션 처리
//				if (result > 0) { // 요청 sql문 성공
//					System.out.println("데이터 삽입 성공");
//					conn.commit();
//				}
//				else { // 요청 sql문 실패
//					System.out.println("데이터 삽입 실패");
//					conn.rollback();
//				}
//				
//				
//				
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally { 
//				try {
//					// 7) 다 사용한 JDBC 객체 반납(생성의 역순)
//					stmt.close();
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				
//			}
		

	
	// 2. 내 PC DB 상에 JDBC 계정에 TEST 테이블에 모든 데이터 조회해보기
	// SELECT문 => 결과 ResutSet(조회된 데이터가 담겨있음) 
	//	=> ResultSet 으로부터 데이터 추출
	
	// 필요한 변수 세팅
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	
	// 실행할 SQL문 작성
	String sql = "SELECT * FROM TEST";
	
	try {
		
		// 1) JDBC Driver 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 위 코드에서 컴파일 에러 발생 시 ojdbc6.jar 파일 추가하지 않거나 오타 발생한 것
		System.out.println("OracleDriver 등록성공");
		
		// 2) Connection 생성(url, 계정명, 비밀번호)
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
		
		// 3) Statement 생성
		stmt = conn.createStatement();
		
		// 4) 5) SQL문 전달해서 실행 후 결과 받기(ResultSet)
		rset = stmt.executeQuery(sql);
		
		// rest.next() => rest의 다음 행이 들어있는지 확인 후 결과 반환(true/false) + (true일 때)한 행 내려줌
				
		while (rset.next()) {
			// 현재 참조하는 rset 으로부터 어떤 컬럼에 해당하는 값을 어떤 타입으로 추출할 것인지 제시해줘야 함
			// db의 컬럼명 제시(컬럼명이기 때문에 대소문자 구분x)
			
			int tno = rset.getInt("TNO");
			String tname = rset.getString("TNAME");
			Date tdate = rset.getDate("TDATE");
			
			System.out.println(tno + ", " + tname + ", " + tdate);
		}
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			rset.close(); // ResultSet 도 반납해야함
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
			
			
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
