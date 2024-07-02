package com.kh.notice.service;

import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;
import static com.kh.common.JDBCTemplate.*;

public class NoticeService {

	public ArrayList<Notice> selectNoticeList(){
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		close(conn);
		return list;
	}

	public int insertNotice(Notice no) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertNotice(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Notice increaseCount(int noticeNo) {
		Connection conn = getConnection();
		
		Notice n = null;
		
		int result = new NoticeDao().increaseCount(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
			n = new NoticeDao().selectNotice(conn, noticeNo);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return n;
	}

	public int updateNotice(Notice no) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().updateNotice(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	public Notice selectNotice(int noticeNo) {
		Connection conn = getConnection();
		
		Notice n = new NoticeDao().selectNotice(conn, noticeNo);
	
		close(conn);
		
		return n;
	}

	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().deleteNotice(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

}