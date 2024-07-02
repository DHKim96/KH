package com.ohouse.members.service;

import static com.ohouse.common.template.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.common.model.vo.Media;
import com.ohouse.members.model.dao.MembersDao;
import com.ohouse.members.model.vo.Members;

public class MembersServiceImpl implements MembersService {
	private MembersDao membersDao = new MembersDao();
	
	@Override
	public int insertMembers(Members m) {
		SqlSession sqlSession = getSqlSession();
		int result = membersDao.insertMembers(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public Members loginMembers(Members m) {
		SqlSession sqlSession = getSqlSession();
		Members loginUser = membersDao.loginMembers(sqlSession, m);
		
		sqlSession.close();
		return loginUser;
	}

	@Override
	public int deleteMembers(Members m) {
		SqlSession sqlSession = getSqlSession();
		int result = membersDao.deleteMembers(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public int idCheck(String checkId) {
		SqlSession sqlSession = getSqlSession();
		int result = membersDao.idCheck(sqlSession, checkId);
		
		sqlSession.close();
		return result;
	}
	
	@Override
	public Members updatePwdMembers(HashMap<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		
		int result = membersDao.updatePwdMembers(sqlSession, map);
		
		Members m = null;
		if (result > 0) {
			String membersId  = map.get("userId");
			m = membersDao.selectMembers(sqlSession, membersId);
			
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return m;
		
	}

	@Override
	public int MembersScrapCount(int mNo) {
		SqlSession sqlSession = getSqlSession();
		int result = membersDao.MembersScrapCount(sqlSession, mNo);
		sqlSession.close();
		return result;
	}

	@Override
	public int MemberCommunityCount(int mNo) {
		SqlSession sqlSession = getSqlSession();
		int result = membersDao.MembersCommunityCount(sqlSession, mNo);
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Media> MemberCommunityList(int mNo) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Media> list = membersDao.MemberCommunityList(sqlSession, mNo);
		sqlSession.close();
		return list;
	}

	@Override
	public Members updateMembers(Media media, Members m) {
		SqlSession sqlSession = getSqlSession();
		int result1 = 0;
		
		if(media.getMediaId() != 0) {
			result1 = membersDao.updateProfile(sqlSession, media);
		} else {
			result1 = membersDao.insertProfile(sqlSession, media);
		}
		
		int result2 = membersDao.updateMembers(sqlSession, m);
		
		Members loginUser = null;
		if(result1 * result2 > 0) {
			loginUser = membersDao.selectMembers(sqlSession, m.getMembersId());
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return loginUser;
	}
}
