package com.kh.board.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.board.model.vo.Reply;
import com.kh.common.vo.Attachment;
import com.kh.common.vo.PageInfo;


public class BoardService {
	public ArrayList<Board> selectBoardList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public Board increaseCount(int boardNo) {
		Connection conn = getConnection();
		
		Board b = null;
		
		int result = new BoardDao().increaseCount(conn, boardNo);
		
		if(result > 0) {
			commit(conn);
			b = new BoardDao().selectBoard(conn, boardNo);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return b;
	}
	
	public Board selectBoard(int boardNo) {
		Connection conn = getConnection();
		
		Board b = new BoardDao().selectBoard(conn, boardNo);
		
		close(conn);
		
		return b;
	}

	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new BoardDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Category> selectCategoryList() {
		Connection conn = getConnection();
		
		ArrayList<Category> list = new BoardDao().selectCategoryList(conn);
		
		close(conn);
		
		return list;
	}

	public int insertBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		
		int result1 = bDao.insertBoard(conn, b);
		int result2 = 1;
		
		if(at != null) {
			result2 = bDao.insertAttachment(conn, at);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return (result1 * result2);
	}

	public Attachment selectAttachment(int boardNo) {
		Connection conn = getConnection();
		
		Attachment at = new BoardDao().selectAttachment(conn, boardNo);
		
		close(conn);
		
		return at;
	}
	
	public int updateBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		
		int result1 = bDao.updateBoard(conn, b);
		
		int result2 = 1; // 기본은 at == null 이며 이때는 성공
		
		if(at != null) { // 새로운 첨부 파일이 있을 때
			if(at.getFileNo() != 0) { // 기존 첨부 파일 존재하므로  update
				result2 = bDao.updateAttachment(conn, at);
			} else { // 기존 첨부 파일 없으므로 insert
				result2 = bDao.insertNewAttachment(conn, at);
			}
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;
	}

	public int insertThumbnailBoard(Board b, ArrayList<Attachment> attachments) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		
		int result1 = bDao.insertThumbnailBoard(conn, b);
		
		int result2 = bDao.insertAttachmentList(conn, attachments);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 * result2;
	}

	public ArrayList<Board> selectThumbnailList() {
		Connection conn = getConnection();
		
		ArrayList<Board> boards = new BoardDao().selectThumbnailList(conn);
		
		close(conn);
		
		return boards;
	}

	public ArrayList<Attachment> selectAttachmentList(int boardNo) {
		Connection conn = getConnection();
		
		ArrayList<Attachment> attachments = new BoardDao().selectAttachmentList(conn, boardNo);
		
		close(conn);
		
		return attachments;
	}

	public int insertReply(Reply r) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertReply(conn, r);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Reply> selectReplyList(int boardNo) {
		Connection conn = getConnection();
		
		ArrayList<Reply> replyList = new BoardDao().selectReplyList(conn, boardNo);
		
		close(conn);
		
		return replyList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
