package com.ohouse.community.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.common.model.vo.Scrap;

public class CommunityScrapDao {
	
	public Scrap selectBoardScrap(SqlSession sqlSession, Scrap scrap) {
		 return sqlSession.selectOne("communityMapper.selectBoardScrapOne", scrap);
	}
	
	public Scrap selectMediaScrap(SqlSession sqlSession, Scrap scrap) {
		return sqlSession.selectOne("communityMapper.selectMediaScrapOne", scrap);
	}
	
	public int insertBoardScrap(SqlSession sqlSession, Scrap scrap) {
		return sqlSession.insert("communityMapper.insertBoardScrap", scrap);
	}
	
	public int insertMediaScrap(SqlSession sqlSession, Scrap scrap) {
		return sqlSession.insert("communityMapper.insertMediaScrap", scrap);
	}
	
	public int updateBoardScrap(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.update("communityMapper.updateBoardScrap", map);
	}
	
	public int updateMediaScrap(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.update("communityMapper.updateMediaScrap", map);
	}

	public ArrayList<Scrap> selectBoardScrap(SqlSession sqlSession, int boardId) {
		return (ArrayList)sqlSession.selectList("communityMapper.selectBoardScrap", boardId);
	}

	public ArrayList<Scrap> selectMediaScrap(SqlSession sqlSession, int boardId) {
		return (ArrayList)sqlSession.selectList("communityMapper.selectMediaScrap", boardId);
	}
}
