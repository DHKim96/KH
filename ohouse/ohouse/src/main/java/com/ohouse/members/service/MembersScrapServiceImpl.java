package com.ohouse.members.service;

import static com.ohouse.common.template.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.common.model.vo.Media;
import com.ohouse.members.model.dao.MembersScrapDao;
import com.ohouse.members.model.vo.Members;

public class MembersScrapServiceImpl implements MembersScrapService  {
	
	private MembersScrapDao membersDao = new MembersScrapDao();

	@Override
	public int MemberScrapCount(int membersNo, int scrapType) {
		SqlSession sqlSession = getSqlSession();
		int result = 0;
		if(scrapType == 1) {
			result = membersDao.MemberScrapCount1(sqlSession, membersNo);
		} else if (scrapType == 2) {
			result =  membersDao.MemberScrapCount2(sqlSession, membersNo);
		} else if (scrapType == 3) {
			result =  membersDao.MemberScrapCount3(sqlSession, membersNo);
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Media> MembersScrapList(int membersNo, int scrapType) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Media> list = null;
		
		if(scrapType == 2) {
			list =  membersDao.MemberScrapList1(sqlSession, membersNo);
		} else if (scrapType == 3) {
			list =  membersDao.MemberScrapList2(sqlSession, membersNo);
		} else if (scrapType == 1){
			list = membersDao.MemberScrapList3(sqlSession, membersNo);
		}
		
		sqlSession.close();
		return list;
	}
	
	

}
