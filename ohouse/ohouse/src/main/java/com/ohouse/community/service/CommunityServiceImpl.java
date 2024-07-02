package com.ohouse.community.service;

import static com.ohouse.common.template.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.ohouse.common.model.vo.Media;
import com.ohouse.community.model.dao.CommunityDao;
import com.ohouse.community.model.vo.Board;
import com.ohouse.community.model.vo.Reply;
import com.ohouse.product.model.vo.Product;

public class CommunityServiceImpl implements CommunityService{
	
	private CommunityDao communityDao = new CommunityDao();
	
	@Override
	public ArrayList<Board> selectBoardList() {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Board> list = communityDao.selectBoardList(sqlSession);
		sqlSession.close();
		return list;
	}

	@Override
	public Media selectProfile(int membersNo) {
		SqlSession sqlSession = getSqlSession();
		Media m = communityDao.selectProfile(sqlSession, membersNo);
		sqlSession.close();
		return m;
	}
	
	@Override
	public int increaseViews(int boardId) {
		SqlSession sqlSession = getSqlSession();
		int result = communityDao.increaseViews(sqlSession, boardId);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public Board selectBoard(int boardId) {
		SqlSession sqlSession = getSqlSession();
		Board b = communityDao.selectBoard(sqlSession, boardId);
		sqlSession.close();
		return b;
	}

	@Override
	public ArrayList<Media> selectMediaList(int boardId) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Media> list = communityDao.selectMediaList(sqlSession, boardId);
		sqlSession.close();
		return list;
	}

	@Override
	public ArrayList<Reply> selectReplyList(int boardId) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Reply> list = communityDao.selectReplyList(sqlSession, boardId);
		sqlSession.close();
		return list;
	}

	@Override
	public Media selectProfileById(String membersId) {
		SqlSession sqlSession = getSqlSession();
		Media m = communityDao.selectProfileById(sqlSession, membersId);
		sqlSession.close();
		return m;
	}

	@Override
	public int deleteReply(int replyId) {
		SqlSession sqlSession = getSqlSession();
		int result = communityDao.deleteReply(sqlSession, replyId);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public int insertReply(Reply r) {
		SqlSession sqlSession = getSqlSession();
		int result = communityDao.insertReply(sqlSession, r);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public int insertBoard(Board b, ArrayList<Media> list) {
		SqlSession sqlSession = getSqlSession();
		int result1 = communityDao.insertBoard(sqlSession, b);
		int result2 = communityDao.insertMedia(sqlSession, list);
		
		if(result1 > 0 && result2 > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result1 * result2;
	}

	@Override
	public ArrayList<Product> selectProductList(String key) {
		SqlSession sqlSession = getSqlSession();
		ArrayList<Product> list = communityDao.selectProductList(sqlSession, key);
		sqlSession.close();
		return list;
	}

	@Override
	public int updateBoard(Board b, ArrayList<Media> list) {
		SqlSession sqlSession = getSqlSession();
		int result1 = communityDao.updateBoard(sqlSession, b);
		int result2 = communityDao.updateMedia(sqlSession, list);
		
		if(result1 > 0 || result2 > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result1 + result2;
	}
	
	@Override
	public int deleteBoard(int boardId) {
		SqlSession sqlSession = getSqlSession();
		int result = communityDao.deleteBoard(sqlSession, boardId);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

}
