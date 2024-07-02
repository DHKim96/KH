package com.ohouse.community.service;

import static com.ohouse.common.template.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.common.model.vo.Scrap;
import com.ohouse.community.model.dao.CommunityScrapDao;

public class CommunityScrapServiceImpl implements CommunityScrapService{
	
	private CommunityScrapDao communityScrapDao = new CommunityScrapDao();

	@Override
	public Scrap selectBoardScrap(Scrap scrap) {
		SqlSession sqlSession = getSqlSession();
		Scrap s = communityScrapDao.selectBoardScrap(sqlSession, scrap);
		sqlSession.close();
		return s;
	}

	@Override
	public Scrap selectMediaScrap(Scrap scrap) {
		SqlSession sqlSession = getSqlSession();
		Scrap s = communityScrapDao.selectMediaScrap(sqlSession, scrap);
		sqlSession.close();
		return s;
	}

	@Override
	public int insertBoardScrap(Scrap scrap) {
		SqlSession sqlSession = getSqlSession();
		int result = communityScrapDao.insertBoardScrap(sqlSession, scrap);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public int insertMediaScrap(Scrap scrap) {
		SqlSession sqlSession = getSqlSession();
		int result = communityScrapDao.insertMediaScrap(sqlSession, scrap);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public int updateBoardScrap(HashMap<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		int result = communityScrapDao.updateBoardScrap(sqlSession, map);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public int updateMediaScrap(HashMap<String, String> map) {
		SqlSession sqlSession = getSqlSession();
		int result = communityScrapDao.updateMediaScrap(sqlSession, map);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Scrap> selectBoardScrap(int boardId) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Scrap> list = communityScrapDao.selectBoardScrap(sqlSession, boardId);
		sqlSession.close();
		return list;
	}

	@Override
	public ArrayList<Scrap> selectMediaScrap(int boardId) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Scrap> list = communityScrapDao.selectMediaScrap(sqlSession, boardId);
		sqlSession.close();
		return list;
	}

}
