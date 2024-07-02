package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {
		// insert문 => 처리된 행 수 => 트랜잭션처리

//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		String sql = prop.getProperty("insertMember"); //미완성
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, m.getUserId());
//			pstmt.setString(2, m.getUserPwd());
//			pstmt.setString(3, m.getUserName());
//			pstmt.setString(4, m.getPhone());
//			pstmt.setString(5, m.getEmail());
//			pstmt.setString(6, m.getAddress());
//			pstmt.setString(7, m.getInterest());
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
		
		int result = sqlSession.insert("memberMapper.insertMember", m);
		return result;
	}
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
}
