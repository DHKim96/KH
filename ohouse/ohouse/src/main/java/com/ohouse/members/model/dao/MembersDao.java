package com.ohouse.members.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.common.model.vo.Media;
import com.ohouse.members.model.vo.Members;

public class MembersDao {
	public int insertMembers(SqlSession sqlSession, Members m) {
		return sqlSession.insert("membersMapper.insertMembers", m);
	}
	
	public Members loginMembers(SqlSession sqlSession, Members m) {
		return sqlSession.selectOne("membersMapper.loginMembers", m);
	}
	
	public int deleteMembers(SqlSession sqlSession, Members m) {
		return sqlSession.delete("membersMapper.deleteMembers", m);
	}
	
	public int idCheck(SqlSession sqlSession, String checkId) {
		return sqlSession.selectOne("membersMapper.idCheck");
	}
	
	public int updatePwdMembers(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.update("membersMapper.updatePwdMembers", map);
	}
	
	public Members selectMembers(SqlSession sqlSession, String membersId) {
		return sqlSession.selectOne("membersMapper.selectMembers", membersId);
	}
	
	public int MembersScrapCount(SqlSession sqlSession, int membersNo) {
		return sqlSession.selectOne("membersMapper.membersScrapCount", membersNo);
	}
	
	public int MembersCommunityCount(SqlSession sqlSession, int membersNo) {
		return sqlSession.selectOne("membersMapper.membersCommunityCount", membersNo);
	}
	
	public ArrayList<Media> MemberCommunityList(SqlSession sqlSession, int membersNo) {
		return (ArrayList)sqlSession.selectList("membersMapper.memberCommunityList", membersNo);
	}

	public int updateProfile(SqlSession sqlSession, Media media) {
		return sqlSession.update("membersMapper.updateProfile", media);
	}

	public int updateMembers(SqlSession sqlSession, Members m) {
		return sqlSession.update("membersMapper.updateMembers", m);
	}

	public int insertProfile(SqlSession sqlSession, Media media) {
		return sqlSession.insert("membersMapper.insertProfile", media);
	}
}
