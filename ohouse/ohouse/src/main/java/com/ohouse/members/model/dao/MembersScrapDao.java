package com.ohouse.members.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.common.model.vo.Media;

public class MembersScrapDao {
	public int MemberScrapCount1(SqlSession sqlSession, int membersNo) {
		return sqlSession.selectOne("membersScrapMapper.selectScrapCountProduct", membersNo);
	}
	
	public int MemberScrapCount2(SqlSession sqlSession, int membersNo) {
		return sqlSession.selectOne("membersScrapMapper.selectScrapCount2", membersNo);
	}
	
	public int MemberScrapCount3(SqlSession sqlSession, int membersNo) {
		return sqlSession.selectOne("membersScrapMapper.selectScrapCount3", membersNo);
	}
	
	public ArrayList<Media> MemberScrapList1(SqlSession sqlSession, int membersNo){
		return (ArrayList)sqlSession.selectList("membersScrapMapper.selectScrapList1", membersNo);
	}
	
	public ArrayList<Media> MemberScrapList2(SqlSession sqlSession, int membersNo){
		return (ArrayList)sqlSession.selectList("membersScrapMapper.selectScrapList2", membersNo);
	}
	
	public ArrayList<Media> MemberScrapList3(SqlSession sqlSession, int membersNo){
		return (ArrayList)sqlSession.selectList("membersScrapMapper.selectScrapList3", membersNo);
	}

}
