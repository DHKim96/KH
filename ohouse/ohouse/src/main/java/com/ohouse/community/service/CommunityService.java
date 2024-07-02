package com.ohouse.community.service;

import java.util.ArrayList;

import com.ohouse.common.model.vo.Media;
import com.ohouse.community.model.vo.Board;
import com.ohouse.community.model.vo.Reply;
import com.ohouse.product.model.vo.Product;

public interface CommunityService {
	// 커뮤니티 메인 게시글 조회, 필터 없음
	ArrayList<Board> selectBoardList();
	
	// 커뮤니티 메인 게시글 프로필 조회
	Media selectProfile(int membersNo);
	
	// 조회수 증가
	int increaseViews(int boardId);
	
	// 게시글 선택
	Board selectBoard(int boardId);

	// 미디어 불러오기
	ArrayList<Media> selectMediaList(int boardId);

	// 댓글 불러오기
	ArrayList<Reply> selectReplyList(int boardId);

	// 프로필 불러오기
	Media selectProfileById(String membersId);

	// 댓글 삭제
	int deleteReply(int replyId);

	// 댓글 삽입
	int insertReply(Reply r);

	// 게시글 삽입
	int insertBoard(Board b, ArrayList<Media> list);

	// 상품 검색
	ArrayList<Product> selectProductList(String key);

	// 게시글 수정
	int updateBoard(Board b, ArrayList<Media> list);

	// 게시글 삭제
	int deleteBoard(int boardId);
}
